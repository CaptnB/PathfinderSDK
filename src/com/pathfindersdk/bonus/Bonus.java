package com.pathfindersdk.bonus;

import com.pathfindersdk.applicables.Applicable;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.utils.ArgChecker;


public abstract class Bonus implements Comparable<Bonus>, Applicable
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
    // First sort by BonusType
    if(!getType().equals(bonus.getType()))
      return getType().compareTo(bonus.getType());
    
    // If both are circumstantial
    else if(isCircumstantial() && bonus.isCircumstantial())
    {
      // Highest first
      if(!Integer.valueOf(getValue()).equals(Integer.valueOf(bonus.getValue())))
        return Integer.valueOf(bonus.getValue()).compareTo(Integer.valueOf(getValue()));
      
      // If same type, same value then sort by circumstance
      else
        return getCircumstance().compareTo(bonus.getCircumstance());
    }
    
    // Both are not circumstantial
    else if(!isCircumstantial() && !bonus.isCircumstantial())
    {
      // Same type, sort by value
      return Integer.valueOf(bonus.getValue()).compareTo(Integer.valueOf(getValue()));
    }
    
    // One is circumstantial but not the other
    else
    {
      // They will never be the same so return the non-cicrcumstantial first
      if(isCircumstantial())
        return -1;
      else
        return 1;
    }
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
    
    out += value + type.toString();
    
    if(circumstance != null)
      out += " (" + circumstance + ")";
    
    return out;
  }
  
}
