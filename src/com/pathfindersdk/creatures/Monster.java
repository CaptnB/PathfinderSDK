package com.pathfindersdk.creatures;

import com.pathfindersdk.books.items.MonsterItem;



/**
 * The Class Monster.
 */
public class Monster extends Creature
{
  protected String name;
  protected transient MonsterItem monster;

  public Monster(MonsterItem monster)
  {
    if(monster != null)
    {
      setName(monster.getName());
      // set other Monster values with MonsterItem ones
    }
    else
      throw new IllegalArgumentException("MonsterItem can't be null");
  }


}
