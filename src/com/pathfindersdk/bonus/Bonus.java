package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.features.Applicable;
import com.pathfindersdk.stats.Stat;


public abstract class Bonus implements Comparable<Bonus>, Applicable<Creature>
{
  final private Integer value;
  final private BonusType type;
  final private String circumstance;

  public Bonus(Integer value, BonusType type)
  {
    this(value, type, null);
  }
  
  public Bonus(Integer value, BonusType type, String circumstance)
  {
    if(value == null)
      throw new IllegalArgumentException("value can't be null");
    
    if(type == null)
      throw new IllegalArgumentException("type can't be null");
    
    this.value = value;
    this.type = type;
    this.circumstance = circumstance;
  }
  
  public Integer getValue()
  {
    return value;
  }
  
  public BonusType getType()
  {
    return type;
  }
  
  public String getCircumstance()
  {
    return circumstance;
  }
  
  public Boolean isCircumstantial()
  {
    return circumstance != null;
  }
  
  @Override
  public int compareTo(Bonus bonus)
  {
    // Sort in descending order (highest bonus first so when bonuses don't stack, the first one is the one to consider)
    return bonus.getValue().compareTo(getValue());
  }

  protected void applyToStat(Stat stat)
  {
    if(stat != null)
      stat.addBonus(this);
    else
      System.out.println("Stat is null, could not add Bonus [" + this.getClass().getSimpleName() + "]");
  }
  
  protected void removeFromStat(Stat stat)
  {
    if(stat != null)
      stat.removeBonus(this);
    else
      System.out.println("Stat is null, could not remove Bonus [" + this.getClass().getSimpleName() + "]");
  }
  
  @Override
  public String toString()
  {
    String out = "";
    
    if(value >= 0)
      out += "+";
    
    out += value + " " + type.toString();
    
    if(circumstance != null)
      out += " " + circumstance;
    
    return out;
  }
  
}
