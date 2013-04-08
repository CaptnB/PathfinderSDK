package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusType;

final public class AbilityBonus extends Bonus
{
  final private AbilityType ability;

  public AbilityBonus(int value, BonusType type, AbilityType ability)
  {
    this(value, type, ability, null);
  }

  public AbilityBonus(int value, BonusType type, AbilityType ability, String circumstance)
  {
    super(value, type, circumstance);
    
    if(ability == null)
      throw new IllegalArgumentException("ability can't be null!");

    this.ability = ability;
  }

  @Override
  public void applyTo(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null");
    
    applyToStat(target.getAbilityScore(ability));
  }

  @Override
  public void removeFrom(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null");
    
    removeFromStat(target.getAbilityScore(ability));
  }

}
