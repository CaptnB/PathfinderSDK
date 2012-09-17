package com.pathfindersdk.creatures;

import com.pathfindersdk.general.Prerequisite;

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
    AbilityScore abilityScore = creature.getAbilityScore(ability);
    if(abilityScore != null && abilityScore.getScore() >= score)
      return true;
    else
      return false;
  }

}
