package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

public class InitiativeBonus extends Bonus
{
  public InitiativeBonus(int value, BonusType type)
  {
    super(value, type);
  }

  public InitiativeBonus(int value, BonusType type, String circumstance)
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
