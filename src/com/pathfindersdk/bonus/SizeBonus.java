package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

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
