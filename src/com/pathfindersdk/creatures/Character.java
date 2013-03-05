package com.pathfindersdk.creatures;

import com.pathfindersdk.books.items.Race;


/**
 * This class adds character specific stats on top of creature ones.
 */
public class Character extends Creature
{
  protected Race race;

  public Character()
  {
    super("New character");
  }
  
  public void setRace(Race race)
  {
    this.race = race;
  }
  
  public Race getRace()
  {
    return race;
  }
  

}
