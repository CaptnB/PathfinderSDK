package com.pathfindersdk.books.items;

import java.util.Collections;
import java.util.HashSet;
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

  public AlternateRacialTraitItem(String name, String raceName, RacialTrait newTrait, String ... replacedTraits)
  {
    super(name);
    
    ArgChecker.checkNotNull(raceName);
    ArgChecker.checkNotEmpty(raceName);
    ArgChecker.checkNotNull(newTrait);
    ArgChecker.checkNotNull(replacedTraits);

    Set<String> replacedTraitsSet = new HashSet<String>();
    Set<RacialTraitPrerequisite> prerequisites = new HashSet<RacialTraitPrerequisite>();
    for(String trait : replacedTraits)
    {
      ArgChecker.checkNotNull(trait);
      ArgChecker.checkNotEmpty(trait);
      
      replacedTraitsSet.add(trait);
      
      // The target race requires to have the trait before changing it
      prerequisites.add(new RacialTraitPrerequisite(trait));
    }
    
    this.raceName = raceName;
    this.replacedTraits = replacedTraitsSet;
    this.newTrait = newTrait;
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
