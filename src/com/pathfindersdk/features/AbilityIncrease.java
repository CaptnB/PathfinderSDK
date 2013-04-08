package com.pathfindersdk.features;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.stats.AbilityScore;

/**
 *  This immutable class represent an AbilityScore increase. While AbilityBonus only gives a temporary boost, AbilityIncrease is permanent 
 *  and counts toward bonus spells, feat prerequisites and the like. AbilityIncrease come from races, every 4th level, etc.
 */
final public class AbilityIncrease implements Applicable<Creature>
{
  final private int increment;
  final private AbilityType ability;
  
  public AbilityIncrease(int increment, AbilityType ability)
  {
    if(ability == null)
      throw new IllegalArgumentException("ability can't be null!");
    
    this.increment = increment;
    this.ability = ability;
  }

  @Override
  public void applyTo(Creature target)
  {
    if(target != null)
    {
      AbilityScore score = target.getAbilityScore(ability);
      if(score != null)
      {
        score.incrementBaseScore(increment);
      }
    }
  }

  @Override
  public void removeFrom(Creature target)
  {
    if(target != null)
    {
      AbilityScore score = target.getAbilityScore(ability);
      if(score != null)
      {
        score.incrementBaseScore(-increment);
      }
    }
  }

}
