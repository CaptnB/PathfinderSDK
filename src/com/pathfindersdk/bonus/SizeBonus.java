package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

public class SizeBonus extends Bonus
{
  public SizeBonus(int value, BonusType type)
  {
    super(value, type);
  }
  
  public SizeBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature creature)
  {
    applyToStat(creature.getSize());
  }

  @Override
  public void removeFrom(Creature creature)
  {
    removeFromStat(creature.getSize());
  }

}
