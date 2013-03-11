package com.pathfindersdk.bonus;

import com.pathfindersdk.books.items.Feature;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.stats.Stat;


public abstract class Bonus implements Comparable<Bonus>, Feature<Creature>
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
  
  // I disabled setters because Bonus are only sorted when they enter the TreeSet and can't trigger a resort...
  
  public Integer getValue()
  {
    return value;
  }
  
/*  public void setValue(int value)
  {
    this.value = value;
  }
*/  
  public BonusType getType()
  {
    return type;
  }
  
/*  public void setType(BonusType type)
  {
    this.type = type;
  }
*/  
  public String getCircumstance()
  {
    return circumstance;
  }
  
/*  public void setCircumstance(String circumstance)
  {
    this.circumstance = circumstance;
  }
*/  
  @Override
  public int compareTo(Bonus bonus)
  {
    // Sort in descending order (highest bonus first so when bonuses don't stack, the first one is the one to consider)
    if(getValue() > bonus.getValue())
      return -1;
    else
      return 1;
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
}
