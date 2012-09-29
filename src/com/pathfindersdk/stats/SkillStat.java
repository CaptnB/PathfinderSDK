package com.pathfindersdk.stats;

import com.pathfindersdk.books.items.SkillItem;

/**
 * This class represents a character skill. 
 */
public class SkillStat extends Stat<String>
{
  protected SkillItem skill;
  protected Boolean classSkill;
  
  public SkillStat(SkillItem skill)
  {
    super(0);
    
    this.skill = skill;
    this.classSkill = false;
  }
  
  @Override
  public String toString()
  {
    return skill.toString();
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
    if(!skill.isUnTrained() && getBaseScore() == 0)
      return 0;
    else if(hasClassSkillBonus())
      return super.getScore() + 3;
    else
      return super.getScore();
  }

  @Override
  public String getKey()
  {
    return skill.toString();
  }
}
