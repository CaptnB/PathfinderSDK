package com.pathfindersdk.stats;

/**
 * This class represents an ability score (ex: CHA 14 (+2)).
 */
public class AbilityStat extends Stat<AbilityType>
{
  protected AbilityType type;
  
  public AbilityStat(Integer baseScore, AbilityType type)
  {
    super(baseScore);
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

  @Override
  public AbilityType getKey()
  {
    return type;
  }
}
