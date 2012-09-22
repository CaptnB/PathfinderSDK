package com.pathfindersdk.prerequisites;

import com.pathfindersdk.bonus.AbilityStat;
import com.pathfindersdk.creatures.Ability;
import com.pathfindersdk.creatures.Creature;

/**
 * This class requires a character to have an ability score (AbilityStat) at a specific value or higher (ex: Dodge feat requires Dex 13).
 */
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
  public Boolean isFilled(Creature creature)
  {
    AbilityStat abilityScore = creature.getAbility(ability);
    if(abilityScore != null && abilityScore.getScore() >= score)
      return true;
    else
      return false;
  }

}
