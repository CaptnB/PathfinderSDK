package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SaveType;

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
    
    if(save == null)
      throw new IllegalArgumentException("save can't be null!");
    this.save = save;
  }
  
  @Override
  public void applyTo(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null");
    
    applyToStat(target.getSavingThrow(save));
  }
  
  @Override
  public void removeFrom(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null");
    
    removeFromStat(target.getSavingThrow(save));
  }
}
