package com.pathfindersdk.books.items;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.applicables.Feature;
import com.pathfindersdk.applicables.Race;
import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;
import com.pathfindersdk.utils.ValidationException;

/**
 * Immutable class to wrap an alternated racial trait book entry.
 */
final public class AlternateRacialTraitItem extends BookItem
{
  final private String raceName;
  final private Set<String> replacedTraits;
  final private Feature newTrait;

  public AlternateRacialTraitItem(String name, String raceName, Feature newTrait, String ... replacedTraits)
  {
    super(name, BookSectionType.ALTERNATE_RACIAL_TRAITS);
    
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
  
  public Feature getNewTrait()
  {
    return newTrait;
  }

  public boolean isAvailable(Race race)
  {
    ArgChecker.checkNotNull(race);
    
    if(race.getRacialTraits() != null)
    {
      // Try to find all Race traits
      for(String replacedTrait : replacedTraits)
      {
        boolean traitFound = false;
        for(Feature trait : race.getRacialTraits())
        {
          if(replacedTrait.compareTo(trait.getName()) == 0)
            traitFound = true;
        }
        
        if(!traitFound)
          return false;   // No need to check further, at least one trait not found
      }
    }
    else
      return false;       // Race doesn't have any traits
    
    return true;          // If everything has been found, then this alternate trait can be applied to Race
  }
  
  public SortedSet<Feature> swapTraits(SortedSet<Feature> traits) throws ValidationException
  {
    ValidationException ve = new ValidationException();
    SortedSet<Feature> newTraits = new TreeSet<Feature>();
    
    newTraits.add(newTrait);
    
    // First remove traits to be replaced
    for(String traitName : replacedTraits)
    {
      boolean traitFound = false;
      for(Feature trait : traits)
      {
        if(trait.toString().equals(traitName))
        {
          traits.remove(trait);
          traitFound = true;
          break;
        }
      }
      if(!traitFound)
      {
        ve.addMessage("Could not find racial trait [" + traitName + "]");
      }
    }
    
    // If race is missing features to be replaced, something went wrong
    if(!ve.getMessages().isEmpty())
      throw ve;
    
    // Add remaining original traits and new one
    for(Feature trait : traits)
      newTraits.add(trait);
    newTraits.add(newTrait);
    
    return newTraits;
  }

}
