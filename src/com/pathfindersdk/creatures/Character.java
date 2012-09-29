package com.pathfindersdk.creatures;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Size;

/**
 * This class adds character specific stats on top of creature ones.
 */
public class Character extends Creature
{
  //protected RaceItem race;

  public Character(String name)
  {
    super(name);
  }
  
  /*public void setRace(RaceItem race)
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
  }*/
  
  /*public RaceItem getRace()
  {
    return race;
  }*/

  @Override
  public Size getSize()
  {
    //return race.getSize();
    return null;
  }

  @Override
  public CreatureType getCreatureType()
  {
    //return race.getType();
    return null;
  }

}
