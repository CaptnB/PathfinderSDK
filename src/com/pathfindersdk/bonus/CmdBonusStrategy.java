package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;

public class CmdBonusStrategy implements BonusStrategy
{
  protected String maneuver;
  
  public CmdBonusStrategy(String maneuver)
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
