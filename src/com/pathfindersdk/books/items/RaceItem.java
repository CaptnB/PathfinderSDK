package com.pathfindersdk.books.items;

import java.util.Collections;
import java.util.Hashtable;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.creatures.CreatureType;
import com.pathfindersdk.creatures.RacialTrait;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BookSectionType;
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
  protected SortedSet<LanguageType> baseLanguages = new TreeSet<LanguageType>();
  protected SortedSet<LanguageType> optionalLanguages;
  protected Hashtable<SpeedType, Stat> speeds;
  // Weapon familiarity...
    
  public RaceItem(String name)
  {
    super(name);
  }
  
  public CreatureType getType()
  {
    return type;
  }

  public void setType(CreatureType type)
  {
    this.type = type;
  }
  
  public Hashtable<AbilityType, Integer> getRacialModifiers()
  {
    return racialModifiers;
  }

  public void setRacialModifiers(Hashtable<AbilityType, Integer> racialModifiers)
  {
    this.racialModifiers = racialModifiers;
  }

  public SizeType getSize()
  {
    return size;
  }

  public void setSize(SizeType size)
  {
    this.size = size;
  }

  public VisionType getVision()
  {
    return vision;
  }

  public void setVision(VisionType vision)
  {
    this.vision = vision;
  }

  public TreeSet<RacialTrait> getRacialTraits()
  {
    return racialTraits;
  }

  public void setRacialTraits(TreeSet<RacialTrait> racialTraits)
  {
    this.racialTraits = racialTraits;
  }

  public TreeSet<AlternateRacialTraitItem> getAlternateRacialTraits()
  {
    return alternateRacialTraits;
  }

  public void setAlternateRacialTraits(
      TreeSet<AlternateRacialTraitItem> alternateRacialTraits)
  {
    this.alternateRacialTraits = alternateRacialTraits;
  }

  public SortedSet<LanguageType> getBaseLanguages()
  {
    return Collections.unmodifiableSortedSet(baseLanguages);
  }

  public void setBaseLanguages(TreeSet<LanguageType> baseLanguages)
  {
    this.baseLanguages = baseLanguages;
  }

  public SortedSet<LanguageType> getOptionalLanguages()
  {
    return optionalLanguages;
  }

  public void setOptionalLanguages(TreeSet<LanguageType> optionalLanguages)
  {
    this.optionalLanguages = optionalLanguages;
  }

  public Hashtable<SpeedType, Stat> getSpeeds()
  {
    return speeds;
  }

  public void setSpeeds(Hashtable<SpeedType, Stat> speeds)
  {
    this.speeds = speeds;
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

  @Override
  protected void index()
  {
    Index.getInstance().getIndex(BookSectionType.RACES).addItem(this);
  }
}
