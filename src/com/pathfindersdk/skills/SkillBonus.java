package com.pathfindersdk.skills;

import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.BonusType;
import com.pathfindersdk.creatures.Creature;

/**
 * The Class SkillBonus.
 */
public class SkillBonus extends Bonus
{
  
  /** The skill type. */
  private String skillName;
  
  
  /**
   * Instantiates a new skill bonus.
   *
   * @param bonus the bonus
   * @param type the type
   * @param skillType the skill type
   * @param circumstantial the circumstantial
   */
  public SkillBonus(int bonus, BonusType type, String skillName, Boolean circumstantial)
  {
    super(bonus, type, circumstantial);
    this.skillName = skillName;
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.general.Bonus#apply(com.pathfindersdk.creatures.characters.Character)
   */
  @Override
  public void apply(Creature creature)
  {
    SkillRank skill = creature.getSkill(skillName);
    if(skill != null)
    {
      skill.getBonuses().add(this);
    }
  }

  @Override
  public void remove(Creature creature)
  {
    // TODO Auto-generated method stub
    
  }
}
