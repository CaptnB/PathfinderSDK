package com.pathfindersdk.creatures;

import java.util.Hashtable;

import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Stat;



/**
 * The Class Monster.
 */
public class Monster extends Creature
{
  protected Size size;
  protected CreatureType type;
  protected Hashtable<SpeedType, Stat> speeds;

  public Monster()
  {
    super("New monster");
  }
  
  @Override
  public Size getSize()
  {
    return size;
  }

  public void setSize(Size size)
  {
    this.size = size;
  }

  @Override
  public CreatureType getType()
  {
    return type;
  }

  public void setCreatureType(CreatureType type)
  {
    this.type = type;
  }

  @Override
  public Stat getSpeed(SpeedType type)
  {
    if(speeds != null)
      return speeds.get(type);
    else
      return null;
  }

  @Override
  public void addSpeed(SpeedType type, Stat speed)
  {
    if(speed != null)
    {
      if(speeds == null)
        speeds = new Hashtable<SpeedType, Stat>();
      
      speeds.put(type, speed);
    }    
  }

  @Override
  public void removeSpeed(SpeedType type, Stat speed)
  {
    if(speeds != null)
    {
      speeds.remove(type);
      
      if(speeds.isEmpty())
        speeds = null;
    }
  }

}
