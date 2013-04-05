package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

public class AttackBonus extends Bonus
{

  public AttackBonus(int value, BonusType type)
  {
    super(value, type);
  }

  public AttackBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    applyToStat(target.getAttack());
  }

  @Override
  public void removeFrom(Creature target)
  {
    removeFromStat(target.getAttack());
  }

}
