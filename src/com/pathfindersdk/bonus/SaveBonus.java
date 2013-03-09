package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SaveType;

public class SaveBonus extends Bonus
{
  protected SaveType save;

  public SaveBonus(int value, SaveType save, BonusType type)
  {
    super(value, type);
    this.save = save;
  }

  public SaveBonus(int value, SaveType save, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
    this.save = save;
  }
  
  @Override
  public void applyTo(Creature creature)
  {
    applyToStat(creature.getSavingThrow(save));
  }
  
  @Override
  public void removeFrom(Creature creature)
  {
    removeFromStat(creature.getSavingThrow(save));
  }
}
