package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.stats.AbilityScore;

public class AbilityBonus extends Bonus
{
  protected AbilityType ability;

  public AbilityBonus(int value, AbilityType ability, BonusType type)
  {
    super(value, type);
    this.ability = ability;
  }

  public AbilityBonus(int value, AbilityType ability, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
    this.ability = ability;
  }
  
  @Override
  public void applyTo(Creature creature)
  {
    AbilityScore score = creature.getAbilityScore(ability);
    
    if(score != null)
      score.addBonus(this);
    else
      System.out.println("Could not find AbilityScore (type : " + ability.toString() + ") from Creature (name : " + creature.getName() + ")");
  }
  
  @Override
  public void removeFrom(Creature creature)
  {
    AbilityScore score = creature.getAbilityScore(ability);
    
    if(score != null)
      score.removeBonus(this);
    else
      System.out.println("Could not find AbilityScore (type : " + ability.toString() + ") from Creature (name : " + creature.getName() + ")");
  }
}
