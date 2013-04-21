package com.pathfindersdk.features;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.books.items.AlternateRacialTraitItem;
import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class represents a character race with all player 
 */
final public class Race
{
  final private String name;
  final private RaceItem raceItem;
  final private transient Size size;
  final private transient Map<SpeedType, Stat> speeds;
  private transient SortedSet<Feature> racialTraits = new TreeSet<Feature>();
  private SortedSet<AlternateRacialTraitItem> alternateTraits;
  
  public Race(RaceItem raceItem)
  {
    ArgChecker.checkNotNull(raceItem);
   
    this.name = raceItem.getName();
    this.raceItem = raceItem;
    
    // Derived values
    this.size = new Size(raceItem.getSize());

    Map<SpeedType, Stat> speeds = new HashMap<SpeedType, Stat>();
    Set<SpeedType> speedKeys = raceItem.getSpeeds().keySet();
    for(SpeedType speedKey : speedKeys)
      speeds.put(speedKey, new Stat(raceItem.getSpeeds().get(speedKey)));
    this.speeds = speeds;
    
    for(Feature trait : raceItem.getRacialTraits())
      racialTraits.add(trait);
  }
  
  public SortedSet<Feature> getRacialTraits()
  {
    return Collections.unmodifiableSortedSet(racialTraits);
  }
  
  public boolean hasRacialTrait(String traitName)
  {
    for(Feature trait : racialTraits)
    {
      if(trait.toString().equals(traitName))
        return true;
    }
    
    return false;
  }
  
  public void addAlternateRacialTrait(AlternateRacialTraitItem alternateTrait)
  {
    ArgChecker.checkNotNull(alternateTrait);

    // Apply alternate trait
    if(alternateTrait.isAvailable(this))
    {
      // First remove traits to be replaced
      for(String traitName : alternateTrait.getReplacedTraits())
      {
        for(Feature trait : racialTraits)
        {
          if(trait.toString().equals(traitName))
          {
            racialTraits.remove(trait);
          }
        }
      }
      
      // Then add new trait
      racialTraits.add(alternateTrait.getNewTrait());
      
      // Keep a trace of the alternate racial trait
      alternateTraits.add(alternateTrait);
    }
  }
  
  public void removeAlternateRacialTrait(AlternateRacialTraitItem alternateTrait)
  {
    // TODO : revert to RaceItem traits
  }
  
 
  @Override
  public String toString()
  {
    String out = "";
    return out;
  }

}
