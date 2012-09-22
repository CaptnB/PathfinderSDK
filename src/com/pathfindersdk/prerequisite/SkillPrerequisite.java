package com.pathfindersdk.prerequisite;

import com.pathfindersdk.bonus.SkillStat;
import com.pathfindersdk.creatures.Creature;

/**
 * The Class SkillPrerequisite.
 */
public class SkillPrerequisite extends Prerequisite
{
  
  private String skillName;
  private Integer ranks;
  
  public SkillPrerequisite(String skillName, int ranks)
  {
    this.skillName = skillName;
    this.ranks = ranks;
  }

  @Override
  public Boolean check(Creature creature)
  {
    SkillStat skill = creature.getSkill(skillName);
    if(skill != null && skill.getBaseScore() >= ranks)
      return true;
    else
      return false;
  }

}
