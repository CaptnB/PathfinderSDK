package com.pathfindersdk.applicables;

import com.pathfindersdk.creatures.Creature;


/**
 * Interface to apply/remove stuff from something else
 */
public interface Applicable
{
  public void applyTo(Creature target);
  public void removeFrom(Creature target);
}
