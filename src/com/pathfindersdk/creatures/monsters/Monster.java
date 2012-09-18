package com.pathfindersdk.creatures.monsters;

import com.pathfindersdk.creatures.Alignment;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.creatures.Size;

/**
 * The Class Monster.
 */
public class Monster extends Creature
{
  private Size size;

  public Monster(String name, Alignment alignment, Size size)
  {
    super(name, alignment);
    this.size = size;
  }

  @Override
  public Size getSize()
  {
    return size;
  }

}
