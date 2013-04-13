package com.pathfindersdk.books.items;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.creatures.CreatureType;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.features.AbilityIncrease;
import com.pathfindersdk.features.RacialTrait;
import com.pathfindersdk.utils.ArgChecker;

/**
 * Immutable class to wrap a race book entry.
 */
final public class RaceItem extends BookItem
{
  final private CreatureType type;
  final private List<AbilityIncrease> racialModifiers;
  final private SizeType size;
  final private Map<SpeedType, Integer> speeds;
  final private VisionType vision;
  final private SortedSet<RacialTrait> racialTraits;
  // TODO: Check weapon proficiencies/familiarities
  final private SortedSet<LanguageType> baseLanguages;
  final private SortedSet<LanguageType> optionalLanguages;
    
  public RaceItem(String name, CreatureType type, List<AbilityIncrease> racialModifiers, SizeType size, Map<SpeedType, Integer> speeds, 
      VisionType vision, SortedSet<RacialTrait> racialTraits, SortedSet<LanguageType> baseLanguages, SortedSet<LanguageType> optionalLanguages)
  {
    super(name);
    
    ArgChecker.checkNotNull(type);
    ArgChecker.checkNotNull(racialModifiers);
    ArgChecker.checkNotNull(size);
    ArgChecker.checkNotNull(speeds);
    ArgChecker.checkNotNull(vision);
    ArgChecker.checkNotNull(racialTraits);
    ArgChecker.checkNotNull(baseLanguages);
    ArgChecker.checkNotNull(optionalLanguages);
    
    this.type = type;
    this.racialModifiers = racialModifiers;
    this.size = size;
    this.speeds = speeds;
    this.vision = vision;
    this.racialTraits = racialTraits;
    this.baseLanguages = baseLanguages;
    this.optionalLanguages = optionalLanguages;
  }
  
  public CreatureType getType()
  {
    return type;
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

  public SortedSet<RacialTrait> getRacialTraits()
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

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.RACES).addItem(this);
  }

}
