package com.pathfindersdk.stats;

import com.pathfindersdk.books.items.SkillItem;

/**
 * This class represents a character skill. 
 */
public class Skill extends AbilityStat
{
  protected SkillItem skill;
  protected Boolean classSkill;
  
  public Skill(SkillItem skill, AbilityScore ability)
  {
    super(ability);
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
    
    // Trained class-skill
    else if(isClassSkill() && getBaseScore() > 0)
      return super.getScore() + ability.getModifier() + 3;
    
    // Everything else
    else
      return super.getScore() + ability.getModifier();
  }

}
