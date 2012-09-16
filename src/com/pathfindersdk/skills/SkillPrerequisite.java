package com.pathfindersdk.skills;

import com.pathfindersdk.general.Prerequisite;
import com.pathfindersdk.creatures.characters.Character;

/**
 * The Class SkillPrerequisite.
 */
public class SkillPrerequisite extends Prerequisite
{
  
  /** The skill type. */
  private SkillType skillType;
  
  /** The ranks. */
  private Integer ranks;
  
  /**
   * Instantiates a new skill prerequisite.
   *
   * @param skillType the skill type
   * @param ranks the ranks
   */
  public SkillPrerequisite(SkillType skillType, int ranks)
  {
    this.skillType = skillType;
    this.ranks = ranks;
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.general.Prerequisite#check(com.pathfindersdk.creatures.characters.Character)
   */
  @Override
  public Boolean check(Character character)
  {
    SkillRank skillRank = character.getSkill(skillType);
    if(skillRank != null && skillRank.getRanks() >= ranks)
      return true;
    else
      return false;
  }

}
