package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Skill;


public class SkillStat extends Stat
{
  private Skill skill;
  private Boolean classSkill;
  
  public SkillStat(Skill skill)
  {
    super(0);
    
    this.skill = skill;
    this.classSkill = false;
  }
  
  public String getName()
  {
    return skill.getName();
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
}
