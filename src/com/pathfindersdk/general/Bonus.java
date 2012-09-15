package com.pathfindersdk.general;

/**
 * The Class Bonus. Base class for all typed bonuses.
 */
public abstract class Bonus
{
  
  /** Bonus (or malus) value. */
  protected Integer bonus;
  
  /** Bonus type. */
  protected BonusType type;
  
  /**
   * Instantiates a new bonus.
   *
   * @param bonus bonus
   * @param type type
   */
  public Bonus(int bonus, BonusType type)
  {
    this.bonus = bonus;
    this.type = type;
  }  
}
