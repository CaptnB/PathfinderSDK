package com.pathfindersdk.books.items;

import java.util.Hashtable;
import java.util.TreeSet;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.creatures.CreatureType;
import com.pathfindersdk.creatures.RacialTrait;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.stats.Stat;

public class RaceItem extends BookItem
{
  protected CreatureType type;
  protected Hashtable<AbilityType, Integer> racialModifiers;
  protected SizeType size;
  protected VisionType vision;
  protected TreeSet<RacialTrait> racialTraits;
  protected TreeSet<AlternateRacialTraitItem> alternateRacialTraits;
  protected TreeSet<LanguageType> baseLanguages;
  protected TreeSet<LanguageType> optionalLanguages;
  protected Hashtable<SpeedType, Stat> speeds;
  // Weapon familiarity...
  
  public RaceItem(String name)
  {
    super(name);
  }
  
  public void setType(CreatureType type)
  {
    this.type = type;
  }

  public void addRacialModifier(Integer score, AbilityType type)
  {
    if(type != null && score != null)
    {
      if(racialModifiers == null)
        racialModifiers = new Hashtable<AbilityType, Integer>();
      
      racialModifiers.put(type, score);
    }
  }
  
  public void setSize(SizeType size)
  {
    this.size = size;
  }
  
  public void setVision(VisionType vision)
  {
    this.vision = vision;
  }
  
  public void addRacialTrait(RacialTrait trait)
  {
    if(trait != null)
    {
      if(racialTraits == null)
        racialTraits = new TreeSet<RacialTrait>();
      
      racialTraits.add(trait);
    }
  }
  
  public void addAlternateRacialTrait(AlternateRacialTraitItem trait)
  {
    if(trait != null)
    {
      if(alternateRacialTraits == null)
        alternateRacialTraits = new TreeSet<AlternateRacialTraitItem>();
      
      alternateRacialTraits.add(trait);
    }
  }
  
  public void addBaseLanguage(LanguageType language)
  {
    if(language != null)
    {
      if(baseLanguages == null)
        baseLanguages = new TreeSet<LanguageType>();
      
      baseLanguages.add(language);
    }
  }
  
  public void addOptionalLanguage(LanguageType language)
  {
    if(language != null)
    {
      if(optionalLanguages == null)
        optionalLanguages = new TreeSet<LanguageType>();
      
      optionalLanguages.add(language);
    }
  }
  
  public void addSpeed(SpeedType type, Stat speed)
  {
    if(type != null && speed != null)
    {
      if(speeds == null)
        speeds = new Hashtable<SpeedType, Stat>();
      
      speeds.put(type, speed);
    }
  }
}
