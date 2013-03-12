package com.pathfindersdk.creatures;

import java.util.Hashtable;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Speed;



/**
 * The Class Monster.
 */
public class Monster extends Creature
{
  protected Size size;
  protected CreatureType type;
  protected Hashtable<SpeedType, Speed> speeds;

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
  public Speed getSpeed(SpeedType type)
  {
    if(speeds != null)
      return speeds.get(type);
    else
      return null;
  }

  @Override
  public void addSpeed(Speed speed)
  {
    if(speed != null)
    {
      if(speeds == null)
        speeds = new Hashtable<SpeedType, Speed>();
      
      speeds.put(speed.getType(), speed);
    }    
  }

  @Override
  public void removeSpeed(Speed speed)
  {
    if(speeds != null)
    {
      speeds.remove(speed.getType());
      
      if(speeds.isEmpty())
        speeds = null;
    }
  }

}
