package com.pathfindersdk.skills;

import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.BonusType;
import com.pathfindersdk.creatures.characters.Character;

public class SkillBonus extends Bonus
{
  private SkillType skillType;
  
  
  public SkillBonus(int bonus, BonusType type, SkillType skillType, Boolean circumstantial)
  {
    super(bonus, type, circumstantial);
    this.skillType = skillType;
  }

  @Override
  public void apply(Character character)
  {
  }
}
