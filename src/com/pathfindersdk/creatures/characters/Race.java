package com.pathfindersdk.creatures.characters;

import java.util.ArrayList;
import java.util.List;

import com.pathfindersdk.bonus.AbilityBonus;
import com.pathfindersdk.creatures.Language;
import com.pathfindersdk.creatures.Size;
import com.pathfindersdk.creatures.Vision;

/**
 * The Class Race.
 */
public class Race implements Comparable<Race>
{
  
  private String name;
  private Size size;
  private Vision vision;
  private List<Language> baseLanguages;
  private List<Language> optionalLanguages;
  private List<AbilityBonus> abilityBonuses;
  
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
  
  public Size getSize()
  {
    return size;
  }
  
  public void setSize(Size size)
  {
    this.size = size;
  }
  
  public Vision getVision()
  {
    return vision;
  }
  
  public void setVision(Vision vision)
  {
    this.vision = vision;
  }
  
  public void addBaseLanguage(Language language)
  {
    if(baseLanguages == null)
      baseLanguages = new ArrayList<Language>();
    
    baseLanguages.add(language);
  }
  
  public void addOptionalLanguage(Language language)
  {
    if(optionalLanguages == null)
      optionalLanguages = new ArrayList<Language>();
    
    optionalLanguages.add(language);
  }
  
  public void addAbilityBonus(AbilityBonus bonus)
  {
    if(abilityBonuses == null)
      abilityBonuses = new ArrayList<AbilityBonus>();
    
    abilityBonuses.add(bonus);
  }
  
  @Override
  public int compareTo(Race race)
  {
    return getName().compareTo(race.getName());
  }
  
}
