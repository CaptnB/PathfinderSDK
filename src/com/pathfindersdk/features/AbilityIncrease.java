package com.pathfindersdk.features;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.stats.AbilityScore;

/**
 *  This class represent an AbilityScore increase. While Bonus only gives a temporary boost, AbilityIncrease is permanent 
 *  and counts toward bonus spells, feat prerequisites and the like. AbilityIncrease come from races, every 4th level, etc.
 */
public class AbilityIncrease implements Applicable<Creature>
{
  protected int increment;
  protected AbilityType ability;
  
  public AbilityIncrease(int increment, AbilityType ability)
  {
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
