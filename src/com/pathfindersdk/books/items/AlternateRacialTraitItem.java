package com.pathfindersdk.books.items;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.features.Race;
import com.pathfindersdk.features.RacialTrait;
import com.pathfindersdk.utils.ArgChecker;

/**
 * Immutable class to wrap an alternated racial trait book entry.
 */
final public class AlternateRacialTraitItem extends BookItem
{
  final private String raceName;
  final private Set<String> replacedTraits;
  final private RacialTrait newTrait;

  public AlternateRacialTraitItem(String name, String raceName, RacialTrait newTrait, String ... replacedTraits)
  {
    super(name);
    
    ArgChecker.checkNotNull(raceName);
    ArgChecker.checkNotEmpty(raceName);
    ArgChecker.checkNotNull(newTrait);
    ArgChecker.checkNotNull(replacedTraits);
    for(String trait : replacedTraits)
    {
      ArgChecker.checkNotNull(trait);
      ArgChecker.checkNotEmpty(trait);
    }

    this.raceName = raceName;
    this.newTrait = newTrait;
    this.replacedTraits = new HashSet<String>(Arrays.asList(replacedTraits));
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

  public boolean isAvailable(Race race)
  {
    for(String replacedTrait : replacedTraits)
    {
      if(!race.hasRacialTrait(replacedTrait))
        return false;
    }
    
    return true;
  }

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.ALTERNATE_RACIAL_TRAITS).addItem(this);
  }

}
