package com.pathfindersdk.skills;

import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.BonusType;

public class SkillBonus extends Bonus
{
  private SkillType skillType;
  
  
  SkillBonus(int bonus, BonusType type, SkillType skillType, Boolean circumstantial)
  {
    super(bonus, type, circumstantial);
    this.skillType = skillType;
  }

  @Override
  public void apply(com.pathfindersdk.creatures.characters.Character character)
  {
    Skill skill = character.getSkill(skillType);
    //skill.addBonus(this);
  }
}
