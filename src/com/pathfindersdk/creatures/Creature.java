package com.pathfindersdk.creatures;

import java.util.Hashtable;

import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.enums.SaveType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.AbilityStat;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Stat;


/**
 * This base class contains stats common to every creatures (PCs, NPCs and Monsters).
 */
public abstract class Creature
{
  protected String name;
  protected AlignmentType alignment;
  protected Hashtable<AbilityType, AbilityScore> abilityScores = new Hashtable<AbilityType, AbilityScore>(); 
  protected Hashtable<SaveType, AbilityStat> savingThrows = new Hashtable<SaveType, AbilityStat>();
  protected AbilityStat initiative;
  
  public Creature(String name)
  {
    this.name = name;
    
    abilityScores.put(AbilityType.STR, new AbilityScore(10));
    abilityScores.put(AbilityType.DEX, new AbilityScore(10));
    abilityScores.put(AbilityType.CON, new AbilityScore(10));
    abilityScores.put(AbilityType.INT, new AbilityScore(10));
    abilityScores.put(AbilityType.WIS, new AbilityScore(10));
    abilityScores.put(AbilityType.CHA, new AbilityScore(10));

    savingThrows.put(SaveType.FORT, new AbilityStat(getAbilityScore(AbilityType.CON)));
    savingThrows.put(SaveType.REF,  new AbilityStat(getAbilityScore(AbilityType.DEX)));
    savingThrows.put(SaveType.WILL, new AbilityStat(getAbilityScore(AbilityType.WIS)));
    
    initiative = new AbilityStat(getAbilityScore(AbilityType.DEX));
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public abstract CreatureType getType();
  
  public AlignmentType getAlignment()
  {
    return alignment;
  }
  
  public void setAlignment(AlignmentType alignment)
  {
    this.alignment = alignment;
  }
  
  public abstract Size getSize();

  public abstract Stat getSpeed(SpeedType type);

  public abstract void addSpeed(SpeedType type, Stat speed);

  public abstract void removeSpeed(SpeedType type, Stat speed);

  public AbilityScore getAbilityScore(AbilityType type)
  {
    AbilityScore score = abilityScores.get(type);
    if(score == null)
      System.out.println("Ability Score is null!");
    
    return score; 
  }
  
  public AbilityScore getStrenght()
  {
    return getAbilityScore(AbilityType.STR);
  }
  
  public AbilityScore getDexterity()
  {
    return getAbilityScore(AbilityType.DEX);
  }
  
  public AbilityScore getConstitution()
  {
    return getAbilityScore(AbilityType.CON);
  }
  
  public AbilityScore getIntelligence()
  {
    return getAbilityScore(AbilityType.INT);
  }
  
  public AbilityScore getWisdom()
  {
    return getAbilityScore(AbilityType.WIS);
  }
  
  public AbilityScore getCharisma()
  {
    return getAbilityScore(AbilityType.CHA);
  }
  
  public AbilityStat getSavingThrow(SaveType type)
  {
    AbilityStat savingThrow = savingThrows.get(type);
    if(savingThrow == null)
      System.out.println("SavingThrow is null!");
    
    return savingThrow;
  }
  
  public AbilityStat getFortitude()
  {
    return getSavingThrow(SaveType.FORT);
  }
  
  public AbilityStat getReflex()
  {
    return getSavingThrow(SaveType.REF);
  }
  
  public AbilityStat getWill()
  {
    return getSavingThrow(SaveType.WILL);
  }
  
  public AbilityStat getInitiative()
  {
    return initiative;
  }
}
