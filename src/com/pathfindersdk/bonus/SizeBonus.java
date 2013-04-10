package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

final public class SizeBonus extends Bonus
{
  
  public SizeBonus(int value, BonusType type)
  {
    this(value, type, null);
  }
  
  public SizeBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getSize());
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getSize());
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new SizeBonus(getValue() - offset, getType(), getCircumstance()); 
  }

}
