package com.pathfindersdk.stats;

import com.pathfindersdk.books.items.SkillItem;

/**
 * This class represents a character skill. 
 */
public class SkillStat extends Stat
{
  protected SkillItem skill;
  protected Boolean classSkill;
  
  public SkillStat(SkillItem skill)
  {
    super(0);
    this.skill = skill;
    this.classSkill = false;
  }
  
  public Boolean isClassSkill()
  {
    return classSkill;
  }
  
  public void setClassSkill(Boolean classSkill)
  {
    this.classSkill = classSkill;
  }
  
  public Boolean hasClassSkillBonus()
  {
    return isClassSkill() && getBaseScore() > 0;
  }
  
  @Override
  public Integer getScore()
  {
    // Cannot use untrained
    if(!skill.isUnTrained() && getBaseScore() == 0)
      return 0;
    else if(isClassSkill() && getBaseScore() > 0)
      return super.getScore() + 3;
    else
      return super.getScore();
  }

}
