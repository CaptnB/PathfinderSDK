package com.pathfindersdk.stats;


/**
 * This class represents an ability score (ex: CHA 14 (+2)).
 */
public class AbilityScore extends Stat implements Rollable
{
  public AbilityScore()
  {
    super(10);
  }
  
  public AbilityScore(int baseScore)
  {
    super(baseScore);
  }
  
  public int getBaseModifier()
  {
    return (int)Math.floor((getBaseScore() - 10.0) / 2.0);
  }

  public int getModifier()
  {
    return (int)Math.floor((getScore() - 10.0) / 2.0);
  }

  @Override
  public int roll()
  {
    return (new Dice(1, 20)).roll() + getModifier();
  }
  
  @Override
  public String toString()
  {
    return getScore() + " (" + (getModifier() < 0 ? "" : "+") + getModifier() + ")";
  }

}
