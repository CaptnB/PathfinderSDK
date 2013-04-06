package com.pathfindersdk.stats;


public class AbilityStat extends Stat implements Rollable
{
  protected AbilityScore ability;

  public AbilityStat(AbilityScore ability)
  {
    super(0);
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
    return (new Dice(1, 20)).roll() + getScore() + ability.getModifier();
  }

}
