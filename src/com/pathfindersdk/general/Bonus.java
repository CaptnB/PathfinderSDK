package com.pathfindersdk.general;

import com.pathfindersdk.creatures.Creature;

/**
 * This generic class applies a bonus to a Stat object.
 */
public class Bonus implements Comparable<Bonus>
{
  
  /** Bonus (or malus) value. */
  protected Integer value;
  
  /** Bonus type. */
  protected BonusType type;
  
  protected String circumstance;
  
  /**
   * Instantiates a new bonus.
   *
   * @param bonus bonus
   * @param type type
   * @param circumstantial the circumstantial
   */
  public Bonus(int value, BonusType type)
  {
    this.value = value;
    this.type = type;
    this.circumstance = null;
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
  
  /**
   * Adds bonus to Stat.
   *
   * @param creature creature receiving the bonus
   */
  public void add(Stat stat)
  {
    stat.addBonus(this);
  }
  
  /**
   * Removes bonus from Stat.
   *
   * @param creature creature losing the bonus
   */
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
    else if(getValue() == bonus.getValue())
      return 0;
    else
      return 1;
  }
}
