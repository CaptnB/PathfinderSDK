package com.pathfindersdk.bonus;

import com.pathfindersdk.basics.SaveType;
import com.pathfindersdk.creatures.Creature;

public class SaveBonusStrategy implements BonusStrategy
{
  protected SaveType type;
  
  public SaveBonusStrategy(SaveType type)
  {
    this.type = type;
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
