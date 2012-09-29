package com.pathfindersdk.stats;

import com.pathfindersdk.basics.SpeedType;

/**
 * This class represents a creature's speed.
 */
public class SpeedStat extends Stat<SpeedType>
{
  protected SpeedType type;

  public SpeedStat(int baseScore, SpeedType type)
  {
    super(baseScore);
    this.type = type;
  }
  
  public SpeedType getType()
  {
    return type;
  }

  @Override
  public SpeedType getKey()
  {
    return type;
  }

}
