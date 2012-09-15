package com.pathfindersdk.skills;

import java.util.ArrayList;

public class SkillRank
{
  private Skill skill;
  private Boolean classSkill;
  private Integer ranks;
  private ArrayList<SkillBonus> bonuses = new ArrayList<SkillBonus>();
  
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
  
  public void incrementRank()
  {
    setRanks(ranks + 1);
  }
  
  public void decrementRank()
  {
    setRanks(ranks - 1);
  }

  public void addBonus(SkillBonus bonus)
  {
    bonuses.add(bonus);
  }
}
