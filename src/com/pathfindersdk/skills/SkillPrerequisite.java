package com.pathfindersdk.skills;

import com.pathfindersdk.general.Prerequisite;
import com.pathfindersdk.creatures.Creature;

/**
 * The Class SkillPrerequisite.
 */
public class SkillPrerequisite extends Prerequisite
{
  
  /** The skill type. */
  private String skillName;
  
  /** The ranks. */
  private Integer ranks;
  
  /**
   * Instantiates a new skill prerequisite.
   *
   * @param skillType the skill type
   * @param ranks the ranks
   */
  public SkillPrerequisite(String skillName, int ranks)
  {
    this.skillName = skillName;
    this.ranks = ranks;
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.general.Prerequisite#check(com.pathfindersdk.creatures.characters.Character)
   */
  @Override
  public Boolean check(Creature creature)
  {
    SkillRank skill = creature.getSkill(skillName);
    if(skill != null && skill.getRanks() >= ranks)
      return true;
    else
      return false;
  }

}
