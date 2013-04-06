package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

final public class CmdBonus extends Bonus
{

  public CmdBonus(int value, BonusType type)
  {
    this(value, type, null);
  }

  public CmdBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    applyToStat(target.getCmd());
  }

  @Override
  public void removeFrom(Creature target)
  {
    removeFromStat(target.getCmd());
  }

}
