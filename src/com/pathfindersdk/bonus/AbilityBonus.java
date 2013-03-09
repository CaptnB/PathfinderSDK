package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusType;

public class AbilityBonus extends Bonus
{
  protected AbilityType ability;

  public AbilityBonus(int value, AbilityType ability, BonusType type)
  {
    super(value, type);
    this.ability = ability;
  }

  public AbilityBonus(int value, AbilityType ability, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
    this.ability = ability;
  }
  
  @Override
  public void applyTo(Creature creature)
  {
    applyToStat(creature.getAbilityScore(ability));
  }
  
  @Override
  public void removeFrom(Creature creature)
  {
    removeFromStat(creature.getAbilityScore(ability));
  }
}
