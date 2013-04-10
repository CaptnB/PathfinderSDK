package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

final public class InitiativeBonus extends Bonus
{
  
  public InitiativeBonus(int value, BonusType type)
  {
    this(value, type, null);
  }

  public InitiativeBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getInitiative());
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getInitiative());
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new InitiativeBonus(getValue() - offset, getType(), getCircumstance()); 
  }

}
