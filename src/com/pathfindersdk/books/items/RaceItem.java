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
    
    if(type == null)
      throw new IllegalArgumentException("type can't be null!");
    
    if(racialModifiers == null)
      throw new IllegalArgumentException("racialModifiers can't be null!");
    
    if(size == null)
      throw new IllegalArgumentException("size can't be null!");
    
    if(speeds == null)
      throw new IllegalArgumentException("speeds can't be null!");
    
    if(vision == null)
      throw new IllegalArgumentException("vision can't be null!");
    
    if(racialTraits == null)
      throw new IllegalArgumentException("racialTraits can't be null!");
    
    if(baseLanguages == null)
      throw new IllegalArgumentException("baseLanguages can't be null!");
    
    if(optionalLanguages == null)
      throw new IllegalArgumentException("optionalLanguages can't be null!");
    
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
    Index.getInstance().getIndex(BookSectionType.RACES).addItemWithoutIndexing(this);
  }

}
