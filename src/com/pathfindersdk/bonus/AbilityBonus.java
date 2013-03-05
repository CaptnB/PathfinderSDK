package com.pathfindersdk.bonus;

import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusType;

public class AbilityBonus extends Bonus
{
  protected AbilityType ability;

  public AbilityBonus(int value, BonusType type, AbilityType ability)
  {
    super(value, type);
    this.ability = ability;
  }

  public AbilityBonus(int value, BonusType type, AbilityType ability, String circumstance)
  {
    super(value, type, circumstance);
    this.ability = ability;
  }

  public AbilityType getAbility()
  {
    return ability;
  }
}
