package com.pathfindersdk.stats;

/**
 * This class represents an ability score (ex: CHA 14 (+2)).
 */
public class AbilityStat extends Stat
{
  public AbilityStat(Integer baseScore)
  {
    super(baseScore);
  }

  public Integer getBaseModifier()
  {
    return (getBaseScore() - 10) / 2;
  }

  public Integer getModifier()
  {
    return (getScore() - 10) / 2;
  }
}
