package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

final public class AttackBonus extends Bonus
{
  
  public AttackBonus(int value, BonusType type)
  {
    this(value, type, null);
  }

  public AttackBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getAttack());
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getAttack());
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new AttackBonus(getValue() - offset, getType(), getCircumstance()); 
  }

}
