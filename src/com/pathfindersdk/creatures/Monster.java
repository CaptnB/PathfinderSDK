package com.pathfindersdk.creatures;

import com.pathfindersdk.books.items.MonsterItem;
import com.pathfindersdk.utils.ArgChecker;



/**
 * The Class Monster.
 */
public class Monster extends Creature
{
  protected String name;
  protected transient MonsterItem monster;

  public Monster(MonsterItem monster)
  {
    ArgChecker.checkNotNull(monster);

    setName(monster.getName());
    // set other Monster values with MonsterItem ones
  }


}
