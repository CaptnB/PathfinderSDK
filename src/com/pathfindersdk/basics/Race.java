package com.pathfindersdk.basics;

import java.util.ArrayList;

import com.pathfindersdk.bonus.AbilityBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.stats.SpeedStat;

/**
 * This class represents a character race.
 */
public class Race implements Comparable<Race>, Feature
{
  private String name;
  private CreatureType type;
  private Size size;
  private ArrayList<Vision> visions;
  private ArrayList<Language> baseLanguages;
  private ArrayList<Language> optionalLanguages;
  private ArrayList<AbilityBonus> abilityBonuses;
  private ArrayList<SpeedStat> speeds;
  private ArrayList<RacialTrait> traits;
  
  public Race(String name, CreatureType type, Size size)
  {
    this.name = name;
    this.type = type;
    this.size = size;
  }
  
  public String getName()
  {
    return name;
  }
  
  public CreatureType getType()
  {
    return type;
  }
  
  public Size getSize()
  {
    return size;
  }
  
  public void setSize(Size size)
  {
    this.size = size;
  }
  
  public void addVision(Vision vision)
  {
    if(visions == null)
      visions = new ArrayList<Vision>();
    
    visions.add(vision);
  }
  
  public void addSpeed(SpeedStat speed)
  {
    if(speeds == null)
      speeds = new ArrayList<SpeedStat>();
    
    speeds.add(speed);
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
  
  public void addTrait(RacialTrait trait)
  {
    if(traits == null)
      traits = new ArrayList<RacialTrait>();
    
    traits.add(trait);
  }
  
  @Override
  public void apply(Character character)
  {
    // Apply land speeds
    if(size == Size.SMALL)
    {
      character.addSpeed(20.0, SpeedType.BASE);
      character.addSpeed(15.0, SpeedType.ARMOR);
    }
    
    // Apply AbilityBonus
    for(AbilityBonus bonus : abilityBonuses)
    {
      Ability ability = bonus.getAbility();
      if(ability != Ability.ANY)
      {
        character.getAbility(ability).addBonus(bonus);
      }
      else
      {
        // TODO: Implement ANY ability bonus
      }
    }
    
    // TODO: Racial traits
    // TODO: 
  }
  
  @Override
  public void remove(Character character)
  {
    // Remove AbilityBonus
    for(AbilityBonus bonus : abilityBonuses)
    {
      Ability ability = bonus.getAbility();
      if(ability != Ability.ANY)
      {
        character.getAbility(ability).removeBonus(bonus);
      }
      else
      {
        // TODO: Implement ANY ability bonus
      }
    }
  }
  
  @Override
  public int compareTo(Race race)
  {
    return getName().compareTo(race.getName());
  }
  
}
