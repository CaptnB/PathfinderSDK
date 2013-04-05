package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

public class CmbBonus extends Bonus
{

  public CmbBonus(int value, BonusType type)
  {
    super(value, type);
  }

  public CmbBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    applyToStat(target.getCmb());
  }

  @Override
  public void removeFrom(Creature target)
  {
    removeFromStat(target.getCmb());
  }

}
