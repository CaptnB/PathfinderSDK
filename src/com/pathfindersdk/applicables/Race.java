package com.pathfindersdk.applicables;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.books.items.AlternateRacialTraitItem;
import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.utils.ArgChecker;
import com.pathfindersdk.utils.ValidationException;

/**
 * This class represents a character race with all player 
 */
final public class Race implements Applicable
{
  final private String name;
  final private Size size;
  final private Map<SpeedType, Stat> speeds;
  private SortedSet<Feature> racialTraits;
  private SortedSet<AlternateRacialTraitItem> alternateTraits;
  
  public Race(RaceItem raceItem)
  {
    ArgChecker.checkNotNull(raceItem);
   
    this.name = raceItem.getName();
    this.size = new Size(raceItem.getSize());

    if(!raceItem.getSpeeds().isEmpty())
    {
      speeds = new HashMap<SpeedType, Stat>();
      
      Set<SpeedType> speedKeys = raceItem.getSpeeds().keySet();
      for(SpeedType speedKey : speedKeys)
        speeds.put(speedKey, new Stat(raceItem.getSpeeds().get(speedKey)));
    }
    else
      speeds = null;
    
    if(!raceItem.getRacialTraits().isEmpty())
    {
      racialTraits = new TreeSet<Feature>();
      
      for(Feature trait : raceItem.getRacialTraits())
        racialTraits.add(trait);
      
    }
    else
      racialTraits = null;
  }
  
  public SortedSet<Feature> getRacialTraits()
  {
    return Collections.unmodifiableSortedSet(racialTraits);
  }
  
  public void addAlternateRacialTrait(AlternateRacialTraitItem alternateTrait) throws ValidationException
  {
    ArgChecker.checkNotNull(alternateTrait);

    // Apply alternate trait
    try
    {
      racialTraits = alternateTrait.swapTraits(getRacialTraits());
    }
    catch (ValidationException ve)
    {
      // TODO : Proper logging
      for(String message : ve.getMessages())
        System.out.println(message);
    }
  }
  
  public void removeAlternateRacialTrait(AlternateRacialTraitItem alternateTrait)
  {
    // TODO : revert to RaceItem traits
  }
  
 
  @Override
  public void applyTo(Creature target)
  {
    target.setSize(size);
    
    if(speeds != null)
    {
      Set<SpeedType> types = speeds.keySet();
      for(SpeedType type : types)
        target.addSpeed(type, speeds.get(type));
    }
    
    if(racialTraits != null)
    {
      for(Feature trait : racialTraits)
        trait.applyTo(target);
    }
  }

  @Override
  public void removeFrom(Creature target)
  {
    target.setSize(null);
    
    if(speeds != null)
    {
      Set<SpeedType> types = speeds.keySet();
      for(SpeedType type : types)
        target.removeSpeed(type, speeds.get(type));
    }
    
    if(racialTraits != null)
    {
      for(Feature trait : racialTraits)
        trait.removeFrom(target);
    }
  }

  @Override
  public String toString()
  {
    return name;
  }

}
