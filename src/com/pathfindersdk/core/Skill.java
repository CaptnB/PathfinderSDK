package com.pathfindersdk.core;


public class Skill
{
  private SkillType type;
	private String description;
	private Ability keyAbility;
	private Boolean trainedOnly;
	private Boolean armorCheckPenalty;
	
	public Skill(SkillType type, String description, Ability keyAbility, Boolean trainedOnly, Boolean armorCheckPenalty)
	{
    this.type = type;
    this.description = description;
    this.keyAbility = keyAbility;
    this.trainedOnly = trainedOnly;
    this.armorCheckPenalty = armorCheckPenalty;
	}
	
  public SkillType getType()
  {
    return type;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public Ability getKeyAbility()
  {
    return keyAbility;
  }
  
  public Boolean isTrainedOnly()
  {
    return trainedOnly;
  }
  
  public Boolean isArmorCheckPenalty()
  {
    return armorCheckPenalty;
  }
  
}
