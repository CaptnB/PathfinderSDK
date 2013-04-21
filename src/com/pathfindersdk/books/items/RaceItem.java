package com.pathfindersdk.books.items;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.creatures.CreatureType;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.features.AbilityIncrease;
import com.pathfindersdk.features.Feature;
import com.pathfindersdk.utils.ArgChecker;

/**
 * Immutable class to wrap a race book entry.
 */
final public class RaceItem extends BookItem
{
  final private CreatureType creatureType;
  final private List<AbilityIncrease> racialModifiers;
  final private SizeType size;
  final private Map<SpeedType, Integer> speeds;
  final private VisionType vision;
  final private SortedSet<Feature> racialTraits;
  // TODO: Check weapon proficiencies/familiarities
  final private SortedSet<LanguageType> baseLanguages;
  final private SortedSet<LanguageType> optionalLanguages;
    
  public RaceItem(String name, CreatureType creatureType, List<AbilityIncrease> racialModifiers, SizeType size, 
      Map<SpeedType, Integer> speeds, VisionType vision, SortedSet<Feature> racialTraits, 
      SortedSet<LanguageType> baseLanguages, SortedSet<LanguageType> optionalLanguages)
  {
    super(name, BookSectionType.RACES);
    
    ArgChecker.checkNotNull(creatureType);
    ArgChecker.checkNotNull(racialModifiers);
    ArgChecker.checkNotNull(size);
    ArgChecker.checkNotNull(speeds);
    ArgChecker.checkNotNull(vision);
    ArgChecker.checkNotNull(racialTraits);
    ArgChecker.checkNotNull(baseLanguages);
    ArgChecker.checkNotNull(optionalLanguages);
    
    this.creatureType = creatureType;
    this.racialModifiers = racialModifiers;
    this.size = size;
    this.speeds = speeds;
    this.vision = vision;
    this.racialTraits = racialTraits;
    this.baseLanguages = baseLanguages;
    this.optionalLanguages = optionalLanguages;
  }
  
  public CreatureType getCreatureType()
  {
    return creatureType;
  }
  
  public List<AbilityIncrease> getRacialModifiers()
  {
    return Collections.unmodifiableList(racialModifiers);
  }

  public SizeType getSize()
  {
    return size;
  }

  public Map<SpeedType, Integer> getSpeeds()
  {
    return Collections.unmodifiableMap(speeds);
  }

  public VisionType getVision()
  {
    return vision;
  }

  public SortedSet<Feature> getRacialTraits()
  {
    return Collections.unmodifiableSortedSet(racialTraits);
  }

  public SortedSet<LanguageType> getBaseLanguages()
  {
    return Collections.unmodifiableSortedSet(baseLanguages);
  }

  public SortedSet<LanguageType> getOptionalLanguages()
  {
    return Collections.unmodifiableSortedSet(optionalLanguages);
  }

}
