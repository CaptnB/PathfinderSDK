package com.pathfindersdk.skills;

import com.pathfindersdk.general.Prerequisite;
import com.pathfindersdk.creatures.characters.Character;

public class SkillPrerequisite extends Prerequisite
{
  private SkillType skillType;
  private Integer ranks;
  
  public SkillPrerequisite(SkillType skillType, int ranks)
  {
    this.skillType = skillType;
    this.ranks = ranks;
  }

  @Override
  public Boolean check(Character character)
  {
    Skill skill = character.getSkill(skillType);
    if(skill != null && skill.getRanks() >= ranks)
      return true;
    else
      return false;
  }

}
