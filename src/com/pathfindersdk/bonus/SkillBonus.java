package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

final public class SkillBonus extends Bonus
{
  final private String skillName;

  public SkillBonus(int value, BonusType type, String skillName)
  {
    this(value, type, skillName, null);
  }

  public SkillBonus(int value, BonusType type, String skillName, String circumstance)
  {
    super(value, type, circumstance);
    
    ArgChecker.checkNotNull(skillName);
    ArgChecker.checkNotEmpty(skillName);

    this.skillName = skillName;
  }

  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    applyToStat(target.getSkill(skillName));
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getSkill(skillName));
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new SkillBonus(getValue() - offset, getType(), skillName, getCircumstance()); 
  }

}
