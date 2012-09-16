package com.pathfindersdk.skills;

import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.BonusType;
import com.pathfindersdk.creatures.characters.Character;

/**
 * The Class SkillBonus.
 */
public class SkillBonus extends Bonus
{
  
  /** The skill type. */
  private SkillType skillType;
  
  
  /**
   * Instantiates a new skill bonus.
   *
   * @param bonus the bonus
   * @param type the type
   * @param skillType the skill type
   * @param circumstantial the circumstantial
   */
  public SkillBonus(int bonus, BonusType type, SkillType skillType, Boolean circumstantial)
  {
    super(bonus, type, circumstantial);
    this.skillType = skillType;
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.general.Bonus#apply(com.pathfindersdk.creatures.characters.Character)
   */
  @Override
  public void apply(Character character)
  {
  }
}
