package com.pathfindersdk.features;

import com.pathfindersdk.creatures.Creature;

public interface Applicable<T extends Creature>
{
  public void applyTo(T target);
  public void removeFrom(T target);
}
