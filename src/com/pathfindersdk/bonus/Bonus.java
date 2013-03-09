package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.stats.Stat;


public abstract class Bonus implements Comparable<Bonus>
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
  
  @Override
  public int compareTo(Bonus bonus)
  {
    // Sort in descending order (highest bonus first so when bonuses don't stack, the first one is the one to consider)
    if(getValue() > bonus.getValue())
      return -1;
    else
      return 1;
  }

  public abstract void applyTo(Creature creature);

  public abstract void removeFrom(Creature creature);

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
