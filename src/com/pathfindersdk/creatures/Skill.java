package com.pathfindersdk.creatures;


/**
 * The Class Skill.
 */
public class Skill implements Comparable<Skill>
{
  
  private String name;
  private Ability keyAbility;
  private Boolean untrained;
  private Boolean armorCheckPenalty;

  public Skill(String name, Ability keyAbility, Boolean untrained, Boolean armorCheckPenalty)
  {
    this.name = name;
    this.keyAbility = keyAbility;
    this.untrained = untrained;
    this.armorCheckPenalty = armorCheckPenalty;
  }
  
  public String getName()
  {
    return name;
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
  
  @Override
  public int compareTo(Skill skill)
  {
    return getName().compareTo(skill.getName());
  }

}
