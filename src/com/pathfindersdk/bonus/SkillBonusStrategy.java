package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;

public class SkillBonusStrategy implements BonusStrategy
{
  protected String skillName;

  public SkillBonusStrategy(String skillName)
  {
    this.skillName = skillName;
  }
  
  @Override
  public void applyTo(Creature creature)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeFrom(Creature creature)
  {
    // TODO Auto-generated method stub

  }

}
