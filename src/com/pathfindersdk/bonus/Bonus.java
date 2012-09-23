package com.pathfindersdk.bonus;

import com.pathfindersdk.stats.Stat;


/**
 * This generic class applies a bonus to a Stat object.
 * Bonus types don't stack except for UNTYPED, the biggest bonus is always considered, circumstantial bonus are not added to total.
 */
public class Bonus implements Comparable<Bonus>
{
  protected Integer value;
  protected BonusType type;
  protected String circumstance;
  
  public Bonus(int value, BonusType type)
  {
    this.value = value;
    this.type = type;
  }
  
  public Bonus(int value, BonusType type, String circumstance)
  {
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
  
  public void apply(Stat stat)
  {
    stat.addBonus(this);
  }

  public void remove(Stat stat)
  {
    stat.removeBonus(this);
  }  

  @Override
  public int compareTo(Bonus bonus)
  {
    // Sort in descending order (highest bonus first so when bonuses don't stack, the first one is the one to consider)
    if(getValue() > bonus.getValue())
      return -1;
    else
      return 1;
  }
  
}
