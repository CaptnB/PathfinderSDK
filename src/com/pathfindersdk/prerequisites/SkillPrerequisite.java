package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;

/**
 * This class requires a creature to have a skill (SkillStat) at a specific rank or higher (ex: Mounted Combat requires Ride 1).
 */
public class SkillPrerequisite implements Prerequisite<Creature>
{
  
  protected String skillName;
  protected int ranks;
  
  public SkillPrerequisite(String skillName, int ranks)
  {
    this.skillName = skillName;
    this.ranks = ranks;
  }

  @Override
  public boolean isFilled(Creature target)
  {
    /*SkillStat skill = creature.getSkill(skillName);
    if(skill != null && skill.getBaseScore() >= ranks)
      return true;
    else*/
      return false;
  }

}
