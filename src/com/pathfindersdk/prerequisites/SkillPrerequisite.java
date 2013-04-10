package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class requires a creature to have a skill (SkillStat) at a specific rank or higher (ex: Mounted Combat requires Ride 1).
 */
final public class SkillPrerequisite implements Prerequisite<Creature>
{  
  final private int ranks;
  final private String skillName;
  
  public SkillPrerequisite(int ranks, String skillName)
  {
    ArgChecker.checkNotNull(skillName);
    ArgChecker.checkNotEmpty(skillName);
    
    this.ranks = ranks;
    this.skillName = skillName;
  }

  @Override
  public boolean isFilled(Creature target)
  {
    ArgChecker.checkNotNull(target);

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
