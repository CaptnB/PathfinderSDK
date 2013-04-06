package com.pathfindersdk.stats;

import com.pathfindersdk.books.items.SkillItem;

public class SizeSkill extends Skill
{
  protected Size size;

  public SizeSkill(SkillItem skill, AbilityScore ability)
  {
    super(skill, ability);
  }
  
  public void setSize(Size size)
  {
    this.size = size;
  }

  @Override
  public int getScore()
  {
    if(size != null)
      return super.getScore() + size.getSkillModifier();
    else
      return super.getScore();
  }
}
