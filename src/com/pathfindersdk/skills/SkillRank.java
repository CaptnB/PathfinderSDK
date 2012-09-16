package com.pathfindersdk.skills;

import java.util.ArrayList;

/**
 * The Class SkillRank.
 */
public class SkillRank
{
  
  /** The skill. */
  private Skill skill;
  
  /** The class skill. */
  private Boolean classSkill;
  
  /** The ranks. */
  private Integer ranks;
  
  /** The bonuses. */
  private ArrayList<SkillBonus> bonuses = new ArrayList<SkillBonus>();
  
  /**
   * Instantiates a new skill rank.
   *
   * @param skill the skill
   */
  public SkillRank(Skill skill)
  {
    this.skill = skill;
    this.classSkill = false;
    this.ranks = 0;
  }
  
  public Skill getSkill()
  {
    return skill;
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

  /**
   * Adds the bonus.
   *
   * @param bonus the bonus
   */
  public void addBonus(SkillBonus bonus)
  {
    bonuses.add(bonus);
  }
}
