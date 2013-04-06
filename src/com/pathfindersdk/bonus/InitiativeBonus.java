package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

final public class InitiativeBonus extends Bonus
{
  
  public InitiativeBonus(Integer value, BonusType type)
  {
    this(value, type, null);
  }

  public InitiativeBonus(Integer value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature creature)
  {
    applyToStat(creature.getInitiative());
  }

  @Override
  public void removeFrom(Creature creature)
  {
    removeFromStat(creature.getInitiative());
  }

}
