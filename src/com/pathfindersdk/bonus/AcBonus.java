package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

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
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getArmorClass());
    
    // Most AC bonus also apply to CMD
    if(!getType().equals(BonusTypeRegister.getInstance().get("Armor"))  && 
       !getType().equals(BonusTypeRegister.getInstance().get("Shield")) && 
       !getType().equals(BonusTypeRegister.getInstance().get("Natural Armor")))
    {
      applyToStat(target.getCmd());
    }
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getArmorClass());
    removeFromStat(target.getCmd());
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new AcBonus(getValue() - offset, getType(), getCircumstance()); 
  }

}
