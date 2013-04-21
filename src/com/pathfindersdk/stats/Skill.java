package com.pathfindersdk.stats;

import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class represents a character skill. 
 */
public class Skill extends AbilityStat
{
  private String name;
  private boolean usableUntrained;
  private boolean armorCheckPenalty;
  private boolean classSkill;
  
  public Skill(SkillItem skillItem, AbilityScore ability)
  {
    super(ability);
    
    ArgChecker.checkNotNull(skillItem);
    
    this.name = skillItem.getName();
    this.usableUntrained = skillItem.isUnTrained();
    this.armorCheckPenalty = skillItem.isArmorCheckPenalty();
    setClassSkill(false);
  }
  
  public boolean isUsableUntrained()
  {
    return usableUntrained;
  }
  
  public boolean isArmorCheckPenalty()
  {
    return armorCheckPenalty;
  }
  
  public boolean isClassSkill()
  {
    return classSkill;
  }
  
  public void setClassSkill(boolean classSkill)
  {
    this.classSkill = classSkill;
  }
  
  public String getName()
  {
    return name;
  }

  @Override
  public int getScore()
  {
    // Cannot use untrained
    if(!isUsableUntrained() && getBaseScore() == 0)
      return 0;
    
    // Trained class-skill
    else if(isClassSkill() && getBaseScore() > 0)
      return super.getScore() + 3;
    
    // Everything else
    else
      return super.getScore();
  }

}
