package com.pathfindersdk.creatures;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.books.items.Race;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Speed;


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
    // Remove current race bonuses
    if(this.race != null)
      this.race.removeFrom(this);
    
    // Make sure to apply new race bonuses
    if(race != null)
      race.applyTo(this);
    
    this.race = race;
  }
  
  public Race getRace()
  {
    return race;
  }
  
  @Override
  public Size getSize()
  {
    if(race != null)
      return race.getSize();
    else
      return null;
  }

  @Override
  public CreatureType getType()
  {
    if(race != null)
      return race.getType();
    else
      return null;
  }

  @Override
  public Speed getSpeed(SpeedType type)
  {
    if(race != null)
      return race.getSpeed(type);
    else
      return null;
  }

  @Override
  public void addSpeed(Speed speed)
  {
    if(race != null)
      race.addSpeed(speed);
  }

  @Override
  public void removeSpeed(Speed speed)
  {
    if(race != null)
      race.removeSpeed(speed);
  }

}
