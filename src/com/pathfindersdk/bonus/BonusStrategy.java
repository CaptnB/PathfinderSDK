package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;

public interface BonusStrategy
{
  public abstract void applyTo(Creature creature);
  public abstract void removeFrom(Creature creature);
}
