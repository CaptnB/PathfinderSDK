package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.stats.AbilityType;

public class AbilityBonusStrategy implements BonusStrategy
{
  protected AbilityType abilityType;
  
  public AbilityBonusStrategy(AbilityType abilityType)
  {
    this.abilityType = abilityType;
  }

  @Override
  public void applyTo(Creature creature)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeFrom(Creature creature)
  {
    // TODO Auto-generated method stub

  }

}
