package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;

/**
 * This class requires a character to have a skill (SkillStat) at a specific rank or higher (ex: Mounted Combat requires Ride 1).
 */
public class SkillPrerequisite extends Prerequisite
{
  
  protected String skillName;
  protected Integer ranks;
  
  public SkillPrerequisite(String skillName, int ranks)
  {
    this.skillName = skillName;
    this.ranks = ranks;
  }

  @Override
  public Boolean isFilled(Creature creature)
  {
    /*SkillStat skill = creature.getSkill(skillName);
    if(skill != null && skill.getBaseScore() >= ranks)
      return true;
    else*/
      return false;
  }

}
