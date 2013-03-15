package com.pathfindersdk.creatures;

import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Stat;


/**
 * This class adds character specific stats on top of creature ones.
 */
public class Character extends Creature
{
  protected Race race;

  public Character()
  {
    super("New character");
  }
  
  public void setRace(Race race)
  {
    // Remove current race bonuses
    if(this.race != null)
      this.race.removeFrom(this);
    
    // Make sure to apply new race bonuses
    if(race != null)
      race.applyTo(this);
    
    this.race = race;
  }
  
  public Race getRace()
  {
    return race;
  }
  
  @Override
  public Size getSize()
  {
    if(race != null)
      return race.getSize();
    else
      return null;
  }

  @Override
  public CreatureType getType()
  {
    if(race != null)
      return race.getType();
    else
      return null;
  }

  @Override
  public Stat getSpeed(SpeedType type)
  {
    if(race != null)
      return race.getSpeed(type);
    else
      return null;
  }

  @Override
  public void addSpeed(SpeedType type, Stat speed)
  {
    if(race != null)
      race.addSpeed(type, speed);
  }

  @Override
  public void removeSpeed(SpeedType type, Stat speed)
  {
    if(race != null)
      race.removeSpeed(type, speed);
  }
  
  @Override
  public String toString()
  {
    String out = "";

/*  
    System.out.println("Fortitude : " + character.getFortitude().toString());
    System.out.println("Reflex : " + character.getReflex().toString());
    System.out.println("Will : " + character.getWill().toString());
    System.out.println("Initiative : " + character.getInitiative().toString());
    System.out.println("Base speed : " + character.getSpeed(SpeedType.BASE).toString());
    System.out.println("Armor speed : " + character.getSpeed(SpeedType.ARMOR).toString());
    System.out.println("Burrow speed : " + character.getSpeed(SpeedType.BURROW).toString());*/
    out += "Name : " + (getName() != null ? getName() : "NULL") + "\n";
    out += "Alignment : " + (getAlignment() != null ? getAlignment().toString() : "NULL") + "\n";
    out += (getRace() != null ? getRace().toString() : "NULL"); 
    out += "Strenght : " + (getAbilityScore(AbilityType.STR) != null ? getAbilityScore(AbilityType.STR).toString() : "NULL") + "\n";
    out += "Dexterity : " + (getAbilityScore(AbilityType.DEX) != null ? getAbilityScore(AbilityType.DEX).toString() : "NULL") + "\n";
    out += "Constitution : " + (getAbilityScore(AbilityType.CON) != null ? getAbilityScore(AbilityType.CON).toString() : "NULL") + "\n";
    out += "Intelligence : " + (getAbilityScore(AbilityType.INT) != null ? getAbilityScore(AbilityType.INT).toString() : "NULL") + "\n";
    out += "Wisdom : " + (getAbilityScore(AbilityType.WIS) != null ? getAbilityScore(AbilityType.WIS).toString() : "NULL") + "\n";
    out += "Charisma : " + (getAbilityScore(AbilityType.CHA) != null ? getAbilityScore(AbilityType.CHA).toString() : "NULL") + "\n";
    
    return out;
  }

}
