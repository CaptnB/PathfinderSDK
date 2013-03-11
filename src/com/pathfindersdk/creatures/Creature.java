package com.pathfindersdk.creatures;

import java.util.Hashtable;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.enums.SaveType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.Initiative;
import com.pathfindersdk.stats.SavingThrow;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Speed;


/**
 * This base class contains stats common to every creatures (PCs, NPCs and Monsters).
 */
public abstract class Creature
{
  protected String name;
  protected AlignmentType alignment;
  protected Hashtable<SpeedType, Speed> speeds = new Hashtable<SpeedType, Speed>();
  protected Hashtable<AbilityType, AbilityScore> abilityScores = new Hashtable<AbilityType, AbilityScore>(); 
  protected Hashtable<SaveType, SavingThrow> savingThrows = new Hashtable<SaveType, SavingThrow>();
  protected Initiative initiative;
  
  public Creature(String name)
  {
    this.name = name;
    
    abilityScores.put(AbilityType.STR, new AbilityScore(10));
    abilityScores.put(AbilityType.DEX, new AbilityScore(10));
    abilityScores.put(AbilityType.CON, new AbilityScore(10));
    abilityScores.put(AbilityType.INT, new AbilityScore(10));
    abilityScores.put(AbilityType.WIS, new AbilityScore(10));
    abilityScores.put(AbilityType.CHA, new AbilityScore(10));

    savingThrows.put(SaveType.FORT, new SavingThrow(getAbilityScore(AbilityType.CON)));
    savingThrows.put(SaveType.REF,  new SavingThrow(getAbilityScore(AbilityType.DEX)));
    savingThrows.put(SaveType.WILL, new SavingThrow(getAbilityScore(AbilityType.WIS)));
    
    initiative = new Initiative(getAbilityScore(AbilityType.DEX));
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

  public Speed getSpeed(SpeedType type)
  {
    Speed speed = speeds.get(type);
    if(speed == null)
      System.out.println("Speed is null!");
    
    return speed;
  }

  public void addSpeed(Speed speed)
  {
    speeds.put(speed.getType(), speed);
  }

  public void removeSpeed(Speed speed)
  {
    speeds.remove(speed.getType());
  }

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
  
  public SavingThrow getSavingThrow(SaveType type)
  {
    SavingThrow savingThrow = savingThrows.get(type);
    if(savingThrow == null)
      System.out.println("SavingThrow is null!");
    
    return savingThrow;
  }
  
  public SavingThrow getFortitude()
  {
    return getSavingThrow(SaveType.FORT);
  }
  
  public SavingThrow getReflex()
  {
    return getSavingThrow(SaveType.REF);
  }
  
  public SavingThrow getWill()
  {
    return getSavingThrow(SaveType.WILL);
  }
  
  public Initiative getInitiative()
  {
    return initiative;
  }
}
