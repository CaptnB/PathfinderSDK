package com.pathfindersdk.bonus;

import com.pathfindersdk.stats.Stat;

public interface Bonus
{
  public abstract void applyTo(Stat stat);
  public abstract void removeFrom(Stat stat);
}
