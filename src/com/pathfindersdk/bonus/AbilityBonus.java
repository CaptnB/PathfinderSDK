package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

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
    
    ArgChecker.checkNotNull(ability);
    ArgChecker.checkIsNot(ability, AbilityType.ANY);

    this.ability = ability;
  }

  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getAbilityScore(ability));
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getAbilityScore(ability));
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new AbilityBonus(getValue() - offset, getType(), ability, getCircumstance()); 
  }

}
