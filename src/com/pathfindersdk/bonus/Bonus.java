package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.features.Applicable;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.utils.ArgChecker;


public abstract class Bonus implements Comparable<Bonus>, Applicable<Creature>
{
  final private int value;
  final private BonusType type;
  final private String circumstance;

  public Bonus(int value, BonusType type, String circumstance)
  {
    ArgChecker.checkNotNull(type);
    if(circumstance != null)
      ArgChecker.checkNotEmpty(circumstance);
    
    this.value = value;
    this.type = type;
    this.circumstance = circumstance;
  }
  
  final public int getValue()
  {
    return value;
  }
  
  final public BonusType getType()
  {
    return type;
  }
  
  final public String getCircumstance()
  {
    return circumstance;
  }
  
  final public boolean isCircumstantial()
  {
    return circumstance != null;
  }
  
  public abstract Bonus newBonus(int offset);
  
  @Override
  public int compareTo(Bonus bonus)
  {
    // Sort in descending order (highest bonus first so when bonuses don't stack, the first one is the one to consider)
    return Integer.valueOf(bonus.getValue()).compareTo(Integer.valueOf(getValue()));
  }

  final protected void applyToStat(Stat stat)
  {
    ArgChecker.checkNotNull(stat);
    
    stat.addBonus(this);
  }
  
  final protected void removeFromStat(Stat stat)
  {
    ArgChecker.checkNotNull(stat);
    
    stat.removeBonus(this);
  }
  
  @Override
  public String toString()
  {
    String out = "";
    
    if(value >= 0)
      out += "+";
    
    out += value + " " + type.toString();
    
    if(circumstance != null)
      out += " (" + circumstance + ")";
    
    return out;
  }
  
}
