package com.pathfindersdk.creatures;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Race;
import com.pathfindersdk.basics.Size;

/**
 * This class adds character specific stats on top of creature ones.
 */
public class Character extends Creature
{
  private Race race;

  public Character(String name)
  {
    super(name);
  }
  
  public void setRace(Race race)
  {
    if(race != null)
    {
      // If previous race, remove bonuses and traits
      if(this.race != null)
        this.race.remove(this);
      
      // Apply new race
      this.race = race;
      this.race.apply(this);
    }
  }
  
  public Race getRace()
  {
    return race;
  }

  @Override
  public Size getSize()
  {
    return race.getSize();
  }

  @Override
  public CreatureType getCreatureType()
  {
    return race.getType();
  }

}
