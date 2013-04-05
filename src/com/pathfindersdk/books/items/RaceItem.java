package com.pathfindersdk.books.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.CreatureType;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.features.AbilityIncrease;
import com.pathfindersdk.features.Feature;
import com.pathfindersdk.features.WeaponFamiliarity;
import com.pathfindersdk.stats.Stat;

public class RaceItem extends BookItem
{
  protected CreatureType type;
  protected List<AbilityIncrease> racialModifiers;
  protected SizeType size;
  protected VisionType vision;
  protected SortedSet<Feature<Character>> racialTraits;
  protected SortedSet<AlternateRacialTraitItem> alternateRacialTraits;
  protected SortedSet<LanguageType> baseLanguages;
  protected SortedSet<LanguageType> optionalLanguages;
  protected SortedMap<SpeedType, Stat> speeds;
  protected WeaponFamiliarity weaponFamiliarity;
    
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
  
  public List<AbilityIncrease> getRacialModifiers()
  {
    if(racialModifiers != null)
      return Collections.unmodifiableList(racialModifiers);
    else
      return null;
  }

  public void addRacialModifier(AbilityIncrease racialModifier)
  {
    if(racialModifier != null)
    {
      if(racialModifiers == null)
        racialModifiers = new ArrayList<AbilityIncrease>();
      
      racialModifiers.add(racialModifier);
    }
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

  public SortedSet<Feature<Character>> getRacialTraits()
  {
    if(racialTraits != null)
      return Collections.unmodifiableSortedSet(racialTraits);
    else
      return null;
  }

  public void addRacialTrait(Feature<Character> trait)
  {
    if(trait != null)
    {
      if(racialTraits == null)
        racialTraits = new TreeSet<Feature<Character>>();
      
      racialTraits.add(trait);
    }
  }

  public SortedSet<AlternateRacialTraitItem> getAlternateRacialTraits()
  {
    if(alternateRacialTraits != null)
      return Collections.unmodifiableSortedSet(alternateRacialTraits);
    else
      return null;
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

  public SortedSet<LanguageType> getBaseLanguages()
  {
    if(baseLanguages != null)
      return Collections.unmodifiableSortedSet(baseLanguages);
    else
      return null;
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

  public SortedSet<LanguageType> getOptionalLanguages()
  {
    if(optionalLanguages != null)
      return Collections.unmodifiableSortedSet(optionalLanguages);
    else
      return null;
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

  public SortedMap<SpeedType, Stat> getSpeeds()
  {
    if(speeds != null)
      return Collections.unmodifiableSortedMap(speeds);
    else
      return null;
  }

  public void addSpeed(SpeedType type, Stat speed)
  {
    if(type != null && speed != null)
    {
      if(speeds == null)
        speeds = new TreeMap<SpeedType, Stat>();
      
      speeds.put(type, speed);
    }
  }
  
  public WeaponFamiliarity getWeaponFamiliarity()
  {
    return weaponFamiliarity;
  }

  public void setWeaponFamiliarity(WeaponFamiliarity weaponFamiliarity)
  {
    this.weaponFamiliarity = weaponFamiliarity;
  }

  @Override
  public RaceItem deepCopy()
  {
    // TODO Auto-generated method stub
    return null;
  }

}
