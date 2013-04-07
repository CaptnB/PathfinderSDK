package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.stats.AbilityScore;

/**
 * This class requires a character to have an ability score (AbilityStat) at a specific value or higher (ex: Dodge feat requires Dex 13).
 */
final public class AbilityPrerequisite implements Prerequisite<Creature>
{
  final private int score;
  final private AbilityType ability;

  public AbilityPrerequisite(int score, AbilityType ability)
  {
    if(ability == null)
      throw new IllegalArgumentException("ability can't be null!");
    
    this.score = score;
    this.ability = ability;
  }
  
  @Override
  public boolean isFilled(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null!");
    
    AbilityScore abilityScore = target.getAbilityScore(ability);

    // Do not consider bonus so take base score
    return (abilityScore.getBaseScore() >= score);
  }

}
