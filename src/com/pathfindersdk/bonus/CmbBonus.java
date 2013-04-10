package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

final public class CmbBonus extends Bonus
{

  public CmbBonus(int value, BonusType type)
  {
    this(value, type, null);
  }

  public CmbBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getCmb());
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getCmb());
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new CmbBonus(getValue() - offset, getType(), getCircumstance()); 
  }

}
