package com.pathfindersdk.skills;

import com.pathfindersdk.creatures.Ability;

public class Skill
{
  private SkillType type;
  private Ability keyAbility;
  private Boolean untrained;
  private Boolean armorCheckPenalty;
  
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
  
  public Boolean isUnTrained()
  {
    return untrained;
  }
  
  public Boolean isArmorCheckPenalty()
  {
    return armorCheckPenalty;
  }

}
