package com.pathfindersdk.prerequisite;

import com.pathfindersdk.creatures.Creature;

/**
 * The Class Prerequisite.
 */
public abstract class Prerequisite
{
  
  /**
   * Checks if prerequisite is filled.
   *
   * @param creature Creature needing to fill the prerequisite
   * @return the boolean
   */
  public abstract Boolean check(Creature creature);
}
