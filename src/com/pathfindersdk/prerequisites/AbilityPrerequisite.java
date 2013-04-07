package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;

/**
 * This class requires a character to have an ability score (AbilityStat) at a specific value or higher (ex: Dodge feat requires Dex 13).
 */
public class AbilityPrerequisite implements Prerequisite<Creature>
{
  protected AbilityType ability;
  protected int score;

  public AbilityPrerequisite(AbilityType ability, int score)
  {
    this.ability = ability;
    this.score = score;
  }
  
  @Override
  public boolean isFilled(Creature target)
  {
    /*AbilityStat abilityScore = creature.getAbility(ability);
    if(abilityScore != null && abilityScore.getScore() >= score)
      return true;
    else*/
      return false;
  }

}
