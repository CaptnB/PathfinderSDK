package com.pathfindersdk.skills;

import java.util.HashSet;

/**
 * The Class SkillRank.
 */
public class SkillRank
{
  
  /** The skill. */
  private Skill skillType;
  
  /** The class skill. */
  private Boolean classSkill;
  
  /** The ranks. */
  private Integer ranks;
  
  /** The bonuses. */
  private HashSet<SkillBonus> bonuses = new HashSet<SkillBonus>();
  
  /**
   * Instantiates a new skill rank.
   *
   * @param skillType the skill type
   */
  public SkillRank(Skill skillType)
  {
    this.skillType = skillType;
    this.classSkill = false;
    this.ranks = 0;
  }
  
  public Skill getSkillType()
  {
    return skillType;
  }
  
  /**
   * Checks if is class skill.
   *
   * @return the boolean
   */
  public Boolean isClassSkill()
  {
    return classSkill;
  }
  
  public void setClassSkill(Boolean classSkill)
  {
    this.classSkill = classSkill;
  }
  
  public Integer getRanks()
  {
    return ranks;
  }
  
  public void setRanks(int ranks)
  {
    if(ranks < 0)
      this.ranks = 0;
    else
      this.ranks = ranks;
  }
  
  /**
   * Increment rank.
   */
  public void incrementRank()
  {
    setRanks(ranks + 1);
  }
  
  /**
   * Decrement rank.
   */
  public void decrementRank()
  {
    setRanks(ranks - 1);
  }

  public HashSet<SkillBonus> getBonuses()
  {
    return bonuses;
  }
}
