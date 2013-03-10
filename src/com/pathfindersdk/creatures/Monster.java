package com.pathfindersdk.creatures;

import com.pathfindersdk.stats.Size;



/**
 * The Class Monster.
 */
public class Monster extends Creature
{
  protected Size size;

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

}
