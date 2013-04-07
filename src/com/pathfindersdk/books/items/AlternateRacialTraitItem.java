package com.pathfindersdk.books.items;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.features.Feature;
import com.pathfindersdk.features.Race;
import com.pathfindersdk.prerequisites.RacialTraitPrerequisite;

/**
 * Immutable class to wrap an alternated racial trait book entry.
 */
final public class AlternateRacialTraitItem extends BookItem
{
  final private String raceName;
  final private SortedSet<String> replacedTraits;
  final private Feature<Character> newTrait;
  final private transient SortedSet<RacialTraitPrerequisite> prerequisites;

  public AlternateRacialTraitItem(String name, String raceName, SortedSet<String> replacedTraits, Feature<Character> newTrait)
  {
    super(name);
    
    if(raceName == null)
      throw new IllegalArgumentException("raceName can't bu null!");
    
    if(replacedTraits == null)
      throw new IllegalArgumentException("replacedTraits can't be null!");
    
    if(newTrait == null)
      throw new IllegalArgumentException("newTrait can't be null!");
    
    this.raceName = raceName;
    this.replacedTraits = replacedTraits;
    this.newTrait = newTrait;
    
    // Generate prerequisites based on traits that will be replaced
    SortedSet<RacialTraitPrerequisite> prerequisites = new TreeSet<RacialTraitPrerequisite>();
    for(String trait : replacedTraits)
      prerequisites.add(new RacialTraitPrerequisite(trait));
    this.prerequisites = prerequisites;
  }
  
  public String getRaceName()
  {
    return raceName;
  }
  
  public SortedSet<String> getReplacedTraits()
  {
    return Collections.unmodifiableSortedSet(replacedTraits);
  }
  
  public Feature<Character> getNewTrait()
  {
    return newTrait;
  }

  public boolean fillsPrerequisites(Race target)
  {
    for(RacialTraitPrerequisite prereq : prerequisites)
    {
      if(!prereq.isFilled(target))
        return false;
    }
    
    return true;
  }

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.ALTERNATE_RACIAL_TRAITS).addItemWithoutIndexing(this);
  }

}
