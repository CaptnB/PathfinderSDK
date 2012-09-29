package com.pathfindersdk.creatures;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Size;

/**
 * The Class Monster.
 */
public class Monster extends Creature
{
  protected Size size;
  protected CreatureType type;

  public Monster(String name, Size size, CreatureType type)
  {
    super(name);
    this.size = size;
    this.type = type;
  }

  @Override
  public Size getSize()
  {
    return size;
  }

  @Override
  public CreatureType getCreatureType()
  {
    return type;
  }

}
