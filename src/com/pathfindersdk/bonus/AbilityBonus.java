package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Ability;


public class AbilityBonus extends Bonus
{
  private Ability ability;
  
  public AbilityBonus(int value, BonusType type, Ability ability)
  {
    super(value, type);
    this.ability = ability;
  }
  
  public AbilityBonus(int value, BonusType type, Ability ability, String circumstance)
  {
    super(value, type, circumstance);
    this.ability = ability;
  }
  
  public Ability getAbility()
  {
    return ability;
  }
}
