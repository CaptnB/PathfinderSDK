package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

final public class SkillBonus extends Bonus
{
  final private String skillName;

  public SkillBonus(int value, BonusType type, String skillName)
  {
    this(value, type, skillName, null);
  }

  public SkillBonus(int value, BonusType type, String skillName, String circumstance)
  {
    super(value, type, circumstance);
    
    if(skillName == null)
      throw new IllegalArgumentException("skillName can't be null!");
    this.skillName = skillName;
  }

  @Override
  public void applyTo(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null");
    
    applyToStat(target.getSkill(skillName));
  }

  @Override
  public void removeFrom(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null");
    
    removeFromStat(target.getSkill(skillName));
  }

}
