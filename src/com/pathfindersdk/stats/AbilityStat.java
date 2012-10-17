package com.pathfindersdk.stats;

/**
 * This class represents an ability score (ex: CHA 14 (+2)).
 */
public class AbilityStat extends Stat
{
  protected AbilityType type;
  
  public AbilityStat(AbilityType type)
  {
    super(10);
    this.type = type;
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
