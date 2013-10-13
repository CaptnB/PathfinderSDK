package com.pathfindersdk.creatures;

import com.pathfindersdk.applicables.Race;
import com.pathfindersdk.creatures.blocks.Description;
import com.pathfindersdk.utils.ArgChecker;



/**
 * This class adds character specific stats on top of creature ones.
 */
public class Character extends Creature
{
  protected Description description;
  protected Race race;

  public Description getDescription()
  {
    return description;
  }

  public void setDescription(Description description)
  {
    ArgChecker.checkNotNull(description);

    // TODO : apply description values
    this.description = description;
  }

  public Race getRace()
  {
    return race;
  }

  public void setRace(Race race)
  {
    ArgChecker.checkNotNull(race);
    
    // TODO : Apply race features
    this.race = race;
  }
  
  @Override
  public String toString()
  {
    String out = "";
    
    out += name + "\n";
    
    return out;
  }

}
