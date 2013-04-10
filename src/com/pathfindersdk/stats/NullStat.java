package com.pathfindersdk.stats;

import com.pathfindersdk.bonus.Bonus;

final public class NullStat extends Stat
{
  // Set base score at 0 and override all setters

  public NullStat()
  {
    super(0);
  }

  @Override
  public void setBaseScore(int baseScore){}
  
  @Override
  public void incrementBaseScore(int increment){}
  
  @Override 
  public void addBonus(Bonus bonus){}
}
