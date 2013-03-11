package com.pathfindersdk.stats;

import com.pathfindersdk.basics.Dice;
import com.pathfindersdk.basics.Rollable;

public class Initiative extends Stat implements Rollable
{
  protected AbilityScore dex;
  
  public Initiative(AbilityScore dex)
  {
    super(0);
    this.dex = dex;
  }
  
  @Override
  public Integer getScore()
  {
    return super.getScore() + dex.getModifier();
  }

  @Override
  public Integer roll()
  {
    return (new Dice(1, 20).roll() + dex.getModifier() + getScore());
  }

}
