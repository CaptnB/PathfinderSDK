package com.pathfindersdk.creatures;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.stats.Size;



/**
 * The Class Monster.
 */
public class Monster extends Creature
{
  protected Size size;
  protected CreatureType type;

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

}
