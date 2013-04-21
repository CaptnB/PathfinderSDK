package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;

/**
 * This interface allows checking of prerequisite on a generic target.
 */
public interface Prerequisite
{
  public boolean isFilled(Creature target);
}
