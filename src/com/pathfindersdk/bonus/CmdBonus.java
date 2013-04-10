package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

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
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getCmd());
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getCmd());
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new CmdBonus(getValue() - offset, getType(), getCircumstance()); 
  }

}
