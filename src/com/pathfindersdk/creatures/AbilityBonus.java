package com.pathfindersdk.creatures;

import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.BonusType;

public class AbilityBonus extends Bonus
{
  private Ability ability;
  
  public AbilityBonus(Integer bonus, BonusType type, Ability ability, Boolean circumstantial)
  {
    super(bonus, type, circumstantial);
    this.ability = ability;
  }

  @Override
  public void apply(Creature creature)
  {
    AbilityScore abilityScore = creature.getAbilityScore(ability);
    if(abilityScore != null)
      abilityScore.getBonuses().add(this);
  }

  @Override
  public void remove(Creature creature)
  {
    // TODO Auto-generated method stub
    
  }

}
