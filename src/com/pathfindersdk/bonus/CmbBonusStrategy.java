package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;

public class CmbBonusStrategy implements BonusStrategy
{
  protected String maneuver;
  
  public CmbBonusStrategy(String maneuver)
  {
    this.maneuver = maneuver;
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
