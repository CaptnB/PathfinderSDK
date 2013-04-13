package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;

/**
 * This interface allows checking of prerequisite on a generic target.
 */
public interface Prerequisite<T extends Creature>
{
  public boolean isFilled(T target);
}
