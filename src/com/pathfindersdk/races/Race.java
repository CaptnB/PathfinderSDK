package com.pathfindersdk.races;

import java.util.HashSet;

import com.pathfindersdk.creatures.AbilityBonus;

/**
 * The Class Race.
 */
public class Race
{
  
  /** Race name. */
  private String name;
  
  /** Racial ability modifiers. */
  private HashSet<AbilityBonus> abilityModifiers = new HashSet<AbilityBonus>();
  
  /** Race size. */
  private Size size;
  
  /** Race vision. */
  private Vision vision;
  
  /** Racial base languages. */
  private HashSet<Language> baseLanguages = new HashSet<Language>();
  
  /** Racial optional languages. */
  private HashSet<Language> optionalLanguages = new HashSet<Language>();
  
  /**
   * Instantiates a new race.
   *
   * @param name race name
   * @param size race size
   * @param vision race vision
   */
  public Race(String name, Size size, Vision vision)
  {
    this.name = name;
    this.size = size;
    this.vision = vision;
  }
  
  public String getName()
  {
    return name;
  }
  
  public HashSet<AbilityBonus> getAbilityModifiers()
  {
    return abilityModifiers;
  }
  
  public Size getSize()
  {
    return size;
  }
  
  public Vision getVision()
  {
    return vision;
  }
  
  public HashSet<Language> getBaseLanguages()
  {
    return baseLanguages;
  }
  
  public HashSet<Language> getOptionalLanguages()
  {
    return optionalLanguages;
  }
  
}
