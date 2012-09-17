package com.pathfindersdk.creatures;

import com.pathfindersdk.general.Prerequisite;

public class AbilityPrerequisite extends Prerequisite
{
  private Ability ability;
  private Integer score;

  public AbilityPrerequisite(Ability ability, int score)
  {
    this.ability = ability;
    this.score = score;
  }
  
  @Override
  public Boolean check(Creature creature)
  {
    AbilityScore abilityScore = creature.getAbilityScore(ability);
    if(abilityScore != null && abilityScore.getScore() >= score)
      return true;
    else
      return false;
  }

}
