package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.stats.AbilityType;

/**
 * This class requires a character to have an ability score (AbilityStat) at a specific value or higher (ex: Dodge feat requires Dex 13).
 */
public class AbilityPrerequisite extends Prerequisite
{
  protected AbilityType ability;
  protected Integer score;

  public AbilityPrerequisite(AbilityType ability, int score)
  {
    this.ability = ability;
    this.score = score;
  }
  
  @Override
  public Boolean isFilled(Creature creature)
  {
    /*AbilityStat abilityScore = creature.getAbility(ability);
    if(abilityScore != null && abilityScore.getScore() >= score)
      return true;
    else*/
      return false;
  }

}
