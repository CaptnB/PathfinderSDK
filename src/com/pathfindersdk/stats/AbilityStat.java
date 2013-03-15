package com.pathfindersdk.stats;

import com.pathfindersdk.basics.Dice;
import com.pathfindersdk.basics.Rollable;

public class AbilityStat extends Stat implements Rollable
{
  protected AbilityScore ability;

  public AbilityStat(AbilityScore ability)
  {
    super(0);
    this.ability = ability;
  }
  
  @Override
  public Integer getScore()
  {
    return super.getScore() + ability.getModifier();
  }

  @Override
  public Integer roll()
  {
    return (new Dice(1, 20)).roll() + getScore() + ability.getModifier();
  }

}
