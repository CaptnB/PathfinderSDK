package com.pathfindersdk.stats;

import com.pathfindersdk.enums.SpeedType;

public class Speed extends Stat
{
  protected SpeedType type;
  
  public Speed(int score, SpeedType type)
  {
    super(score);
    this.type = type;
  }
  
  public void setType(SpeedType type)
  {
    this.type = type;
  }
  
  public SpeedType getType()
  {
    return type;
  }
}
