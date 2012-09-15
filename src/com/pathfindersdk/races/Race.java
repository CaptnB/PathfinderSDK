package com.pathfindersdk.races;

import java.util.ArrayList;

import com.pathfindersdk.general.AbilityScore;

public class Race
{
  private String name;
  private ArrayList<AbilityScore> abilityModifiers = new ArrayList<AbilityScore>();
  private Size size;
  private Vision vision;
  private ArrayList<Language> baseLanguages = new ArrayList<Language>();
  private ArrayList<Language> optionalLanguages = new ArrayList<Language>();
  
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
  
  public void addAbilityModifier(AbilityScore abilityModifier)
  {
    abilityModifiers.add(abilityModifier);
  }
  
  public void addBaseLanguage(Language language)
  {
    baseLanguages.add(language);
  }
  
  public void addOptionalLanguage(Language language)
  {
    optionalLanguages.add(language);
  }

}
