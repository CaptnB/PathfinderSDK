package com.pathfindersdk.core;


public class Skill
{
  private String name;
	private String description;
	private Ability keyAbility;
	private Boolean trainedOnly;
	private Boolean armorCheckPenalty;
	
	Skill(String name, String description, Ability keyAbility, Boolean trainedOnly, Boolean armorCheckPenalty)
	{
    this.name = name;
    this.description = description;
    this.keyAbility = keyAbility;
    this.trainedOnly = trainedOnly;
    this.armorCheckPenalty = armorCheckPenalty;
	}
	
  public String getName()
  {
    return name;
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
