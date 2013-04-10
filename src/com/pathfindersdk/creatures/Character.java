package com.pathfindersdk.creatures;

import com.pathfindersdk.features.Description;
import com.pathfindersdk.features.Race;
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

    // Clean previous description
    if(this.description != null)
      this.description.removeFrom(this);
    
    // Apply new one
    if(description != null)
      description.applyTo(this);

    this.description = description;
  }

  public Race getRace()
  {
    return race;
  }

  public void setRace(Race race)
  {
    ArgChecker.checkNotNull(race);
    
    // Clean current race
    if(this.race != null)
      this.race.removeFrom(this);
    
    // Apply new one
    if(race != null)
      race.applyTo(this);
    
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
