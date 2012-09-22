package com.pathfindersdk.prerequisite;

import com.pathfindersdk.bonus.AbilityStat;
import com.pathfindersdk.creatures.Ability;
import com.pathfindersdk.creatures.Creature;

/**
 * The Class AbilityPrerequisite.
 */
public class AbilityPrerequisite extends Prerequisite
{
  
  /** The ability. */
  private Ability ability;
  
  /** The score. */
  private Integer score;

  /**
   * Instantiates a new ability prerequisite.
   *
   * @param ability the ability
   * @param score the score
   */
  public AbilityPrerequisite(Ability ability, int score)
  {
    this.ability = ability;
    this.score = score;
  }
  
  /* (non-Javadoc)
   * @see com.pathfindersdk.general.Prerequisite#check(com.pathfindersdk.creatures.Creature)
   */
  @Override
  public Boolean check(Creature creature)
  {
    AbilityStat abilityScore = creature.getAbility(ability);
    if(abilityScore != null && abilityScore.getScore() >= score)
      return true;
    else
      return false;
  }

}
