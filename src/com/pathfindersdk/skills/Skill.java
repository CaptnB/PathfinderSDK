package com.pathfindersdk.skills;

import java.util.HashSet;

import com.pathfindersdk.creatures.Ability;

/**
 * The Class Skill.
 */
public class Skill
{
  
  /** The name. */
  private String name;
  
  /** The key ability. */
  private Ability keyAbility;
  
  /** Skill usable untrained. */
  private Boolean untrained;
  
  /** Skill accounting armor check penalty. */
  private Boolean armorCheckPenalty;
  
  /** Skill possible expansions. */
  private HashSet<String> expansions = new HashSet<String>();
  
  /** Skill expansion. */
  private String expansion;
  
  /**
   * Instantiates a new skill.
   *
   * @param name the name
   * @param keyAbility the key ability
   * @param untrained the untrained
   * @param armorCheckPenalty the armor check penalty
   */
  public Skill(String name, Ability keyAbility, Boolean untrained, Boolean armorCheckPenalty)
  {
    this.name = name;
    this.keyAbility = keyAbility;
    this.untrained = untrained;
    this.armorCheckPenalty = armorCheckPenalty;
    expansion = null;
  }
  
  public String getName()
  {
    if(expansion == null)
      return name;
    else
      return name + " (" + expansion + ")";
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
  
  /**
   * Checks if is expandable.
   *
   * @return the boolean
   */
  public Boolean isExpandable()
  {
    if(expansions.size() > 0)
      return true;
    else
      return false;
  }
  
  public HashSet<String> getExpansions()
  {
    return expansions;
  }

}
