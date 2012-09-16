package com.pathfindersdk.skills;

import com.pathfindersdk.creatures.Ability;

/**
 * The Class Skill.
 */
public class Skill
{
  
  /** The type. */
  private SkillType type;
  
  /** The key ability. */
  private Ability keyAbility;
  
  /** The untrained. */
  private Boolean untrained;
  
  /** The armor check penalty. */
  private Boolean armorCheckPenalty;
  
  /**
   * Instantiates a new skill.
   *
   * @param type the type
   * @param keyAbility the key ability
   * @param untrained the untrained
   * @param armorCheckPenalty the armor check penalty
   */
  public Skill(SkillType type, Ability keyAbility, Boolean untrained, Boolean armorCheckPenalty)
  {
    this.type = type;
    this.keyAbility = keyAbility;
    this.untrained = untrained;
    this.armorCheckPenalty = armorCheckPenalty;
  }
  
  public String getName()
  {
    return type.getName();
  }
  
  public SkillType getType()
  {
    return type;
  }
  
  public Ability getKeyAbility()
  {
    return keyAbility;
  }
  
  /**
   * Checks if is un trained.
   *
   * @return the boolean
   */
  public Boolean isUnTrained()
  {
    return untrained;
  }
  
  /**
   * Checks if is armor check penalty.
   *
   * @return the boolean
   */
  public Boolean isArmorCheckPenalty()
  {
    return armorCheckPenalty;
  }

}
