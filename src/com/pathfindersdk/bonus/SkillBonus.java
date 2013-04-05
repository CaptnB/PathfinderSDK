package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

public class SkillBonus extends Bonus
{
  protected String skillName;

  public SkillBonus(int value, BonusType type, String skillName)
  {
    super(value, type);
    this.skillName = skillName;
  }

  public SkillBonus(int value, BonusType type, String skillName, String circumstance)
  {
    super(value, type, circumstance);
    this.skillName = skillName;
  }

  @Override
  public void applyTo(Creature target)
  {
    applyToStat(target.getSkill(skillName));
  }

  @Override
  public void removeFrom(Creature target)
  {
    removeFromStat(target.getSkill(skillName));
  }

}
