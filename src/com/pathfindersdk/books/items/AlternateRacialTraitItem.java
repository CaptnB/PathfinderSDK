package com.pathfindersdk.books.items;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.features.Race;
import com.pathfindersdk.features.RacialTrait;
import com.pathfindersdk.prerequisites.RacialTraitPrerequisite;
import com.pathfindersdk.utils.ArgChecker;

/**
 * Immutable class to wrap an alternated racial trait book entry.
 */
final public class AlternateRacialTraitItem extends BookItem
{
  final private String raceName;
  final private Set<String> replacedTraits;
  final private RacialTrait newTrait;
  final private transient Set<RacialTraitPrerequisite> prerequisites;

  public AlternateRacialTraitItem(String name, String raceName, Set<String> replacedTraits, RacialTrait newTrait)
  {
    super(name);
    
    ArgChecker.checkNotNull(raceName);
    ArgChecker.checkNotEmpty(raceName);
    
    ArgChecker.checkNotNull(replacedTraits);
    
    ArgChecker.checkNotNull(newTrait);
    
    this.raceName = raceName;
    this.replacedTraits = replacedTraits;
    this.newTrait = newTrait;
    
    // Generate prerequisites based on traits that will be replaced
    Set<RacialTraitPrerequisite> prerequisites = new LinkedHashSet<RacialTraitPrerequisite>();
    for(String trait : replacedTraits)
      prerequisites.add(new RacialTraitPrerequisite(trait));
    this.prerequisites = prerequisites;
  }
  
  public String getRaceName()
  {
    return raceName;
  }
  
  public Set<String> getReplacedTraits()
  {
    return Collections.unmodifiableSet(replacedTraits);
  }
  
  public RacialTrait getNewTrait()
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
