package com.pathfindersdk.features;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.books.items.AlternateRacialTraitItem;
import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Stat;

/**
 * This class represents a character race with all player 
 */
final public class Race implements Applicable<Character>
{
  final private RaceItem raceItem;
  final private transient Size size;
  final private transient Map<SpeedType, Stat> speeds;
  private transient SortedSet<RacialTrait> racialTraits = new TreeSet<RacialTrait>();
  private SortedSet<AlternateRacialTraitItem> alternateTraits;
  
  public Race(RaceItem raceItem)
  {
    if(raceItem == null)
      throw new IllegalArgumentException("raceItem can't be null!");
    
    this.raceItem = raceItem;
    
    // Derived values
    this.size = new Size(raceItem.getSize());

    Map<SpeedType, Stat> speeds = new HashMap<SpeedType, Stat>();
    Set<SpeedType> speedKeys = raceItem.getSpeeds().keySet();
    for(SpeedType speedKey : speedKeys)
      speeds.put(speedKey, new Stat(raceItem.getSpeeds().get(speedKey)));
    this.speeds = speeds;
    
    for(RacialTrait trait : raceItem.getRacialTraits())
      racialTraits.add(trait);
  }
  
  public SortedSet<RacialTrait> getRacialTraits()
  {
    return Collections.unmodifiableSortedSet(racialTraits);
  }
  
  public void addAlternateRacialTrait(AlternateRacialTraitItem alternateTrait)
  {
    if(alternateTrait == null)
      throw new IllegalArgumentException("alternateTrait can't be null!");

    // Apply alternate trait
    if(alternateTrait.fillsPrerequisites(this))
    {
      // First remove traits to be replaced
      for(String traitName : alternateTrait.getReplacedTraits())
      {
        for(Feature<Character> trait : racialTraits)
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
  public void applyTo(Character character)
  {
    for(AbilityIncrease racialModifier : raceItem.getRacialModifiers())
      racialModifier.applyTo(character);
    
    character.setSize(size);
    
    Set<SpeedType> speedKeys = speeds.keySet();
    for(SpeedType speedKey : speedKeys)
      character.addSpeed(speedKey, speeds.get(speedKey));
    
    character.addVision(raceItem.getVision());
    
    for(Feature<Character> racialTrait : racialTraits)
      racialTrait.applyTo(character);
    
    // TODO: Weapon familiarities
    for(LanguageType language : raceItem.getBaseLanguages())
      character.addLanguage(language);
  }
  
  @Override
  public void removeFrom(Character character)
  {
    // TODO : remove everything
  }
  
  @Override
  public String toString()
  {
    String out = "";
    return out;
  }
}
