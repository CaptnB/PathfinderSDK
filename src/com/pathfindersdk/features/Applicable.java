package com.pathfindersdk.features;

import com.pathfindersdk.creatures.Creature;


/**
 * Interface to apply/remove stuff from something else
 */
public interface Applicable<T extends Creature>
{
  public void applyTo(T target);
  public void removeFrom(T target);
}
