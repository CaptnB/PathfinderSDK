package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.enums.SaveType;
import com.pathfindersdk.utils.ArgChecker;

final public class SaveBonus extends Bonus
{
  final private SaveType save;

  public SaveBonus(int value, BonusType type, SaveType save)
  {
    this(value, type, save, null);
  }

  public SaveBonus(int value, BonusType type, SaveType save, String circumstance)
  {
    super(value, type, circumstance);
  
    ArgChecker.checkNotNull(save);

    this.save = save;
  }
  
  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getSavingThrow(save));
  }
  
  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getSavingThrow(save));
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new SaveBonus(getValue() - offset, getType(), save, getCircumstance()); 
  }

}
