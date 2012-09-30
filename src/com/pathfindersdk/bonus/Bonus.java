package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;

public interface Bonus
{
  public abstract void applyTo(Creature creature);
  public abstract void removeFrom(Creature creature);
}
