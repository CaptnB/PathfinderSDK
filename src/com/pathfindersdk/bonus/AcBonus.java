package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

final public class AcBonus extends Bonus
{
  
  public AcBonus(int value, BonusType type)
  {
    this(value, type, null);
  }

  public AcBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    applyToStat(target.getArmorClass());
  }

  @Override
  public void removeFrom(Creature target)
  {
    removeFromStat(target.getArmorClass());
  }

}
