package com.pathfindersdk.features;

import java.util.SortedSet;

import com.pathfindersdk.books.items.AlternateRacialTraitItem;
import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.LanguageType;

/**
 * This class represents a character race.
 */
public class Race extends Feature<Character>
{
  protected transient RaceItem race;
  protected SortedSet<LanguageType> bonusLanguages;               // Bonus languages from high INT score
  protected SortedSet<AlternateRacialTraitItem> alternateTraits;  // Optional alternate racial traits
  
  public Race(RaceItem race)
  {
    super("");    // Can't check for race == null before...
    
    if(race != null)
      this.name = race.getName();
    else
      throw new IllegalArgumentException("race can't be null");
  }
  
  @Override
  public void applyTo(Character character)
  {
    /*for(LanguageType language : race.getBaseLanguages())
      character.addLanguage(language);*/
  }

  @Override
  public void removeFrom(Character character)
  {
    /*for(Bonus bonus : bonuses)
      bonus.removeFrom(character);*/
  }
  
  @Override
  public String toString()
  {
    String out = "";
    return out;
  }
}
