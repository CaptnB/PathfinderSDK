package com.pathfindersdk.stats;

import com.pathfindersdk.utils.ArgChecker;


public class AbilityStat extends Stat implements Rollable
{
  final protected AbilityScore ability;

  public AbilityStat(AbilityScore ability)
  {
    super(0);
    
    ArgChecker.checkNotNull(ability);
    
    this.ability = ability;
  }
  
  @Override
  public int getScore()
  {
    return super.getScore() + ability.getModifier();
  }

  @Override
  public int roll()
  {
    return (new Dice(1, 20)).roll() + getScore();
  }

}
