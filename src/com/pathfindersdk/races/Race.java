package com.pathfindersdk.races;

import java.util.ArrayList;

import com.pathfindersdk.creatures.AbilityScore;

/**
 * The Class Race.
 */
public class Race
{
  
  /** Race name. */
  private String name;
  
  /** Racial ability modifiers. */
  private ArrayList<AbilityScore> abilityModifiers = new ArrayList<AbilityScore>();
  
  /** Race size. */
  private Size size;
  
  /** Race vision. */
  private Vision vision;
  
  /** Racial base languages. */
  private ArrayList<Language> baseLanguages = new ArrayList<Language>();
  
  /** Racial optional languages. */
  private ArrayList<Language> optionalLanguages = new ArrayList<Language>();
  
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
  
  public ArrayList<AbilityScore> getAbilityModifiers()
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
  
  public ArrayList<Language> getBaseLanguages()
  {
    return baseLanguages;
  }
  
  public ArrayList<Language> getOptionalLanguages()
  {
    return optionalLanguages;
  }
  
  /**
   * Adds a racial ability modifier.
   *
   * @param abilityModifier racial ability modifier
   */
  public void addAbilityModifier(AbilityScore abilityModifier)
  {
    abilityModifiers.add(abilityModifier);
  }
  
  /**
   * Adds a base language.
   *
   * @param language base language
   */
  public void addBaseLanguage(Language language)
  {
    baseLanguages.add(language);
  }
  
  /**
   * Adds an optional language.
   *
   * @param language optional language
   */
  public void addOptionalLanguage(Language language)
  {
    optionalLanguages.add(language);
  }

}
