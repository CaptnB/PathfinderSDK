package com.pathfindersdk.bonus;

import com.pathfindersdk.stats.AbilityStat;

public class AbilityModifierBonus extends Bonus
{
  private AbilityStat ability;
  
  public AbilityModifierBonus(BonusType type, AbilityStat ability)
  {
    super(0, type);
    this.ability = ability;
  }
  
  @Override
  public Integer getValue()
  {
    return ability.getModifier();
  }

}
