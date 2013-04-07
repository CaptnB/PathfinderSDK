package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.stats.Stat;

/**
 * This class requires a creature to have a skill (SkillStat) at a specific rank or higher (ex: Mounted Combat requires Ride 1).
 */
final public class SkillPrerequisite implements Prerequisite<Creature>
{  
  final private int ranks;
  final private String skillName;
  
  public SkillPrerequisite(int ranks, String skillName)
  {
    if(skillName == null)
      throw new IllegalArgumentException("skillName can't be null!");
    
    this.ranks = ranks;
    this.skillName = skillName;
  }

  @Override
  public boolean isFilled(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null!");

    Stat skill = target.getSkill(skillName);
    if(skill != null)
    {
      // Only check ranks
      if(skill.getBaseScore() >= ranks)
        return true;
    }
    
    return false;
  }

}
