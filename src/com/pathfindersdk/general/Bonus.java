package com.pathfindersdk.general;

import com.pathfindersdk.creatures.Creature;

/**
 * The Class Bonus. Base class for all typed bonuses.
 */
public abstract class Bonus
{
  
  /** Bonus (or malus) value. */
  protected Integer bonus;
  
  /** Bonus type. */
  protected BonusType type;
  
  /** Bonus circumstantial. */
  protected Boolean circumstantial;   // Not added to total
  
  /** Bonus circumstance. */
  protected String circumstance;
  
  /**
   * Instantiates a new bonus.
   *
   * @param bonus bonus
   * @param type type
   * @param circumstantial the circumstantial
   */
  public Bonus(int bonus, BonusType type)
  {
    this.bonus = bonus;
    this.type = type;
    this.circumstantial = false;
  }
  
  public void setCircumstance(String circumstance)
  {
    this.circumstantial = true;
    this.circumstance = circumstance;
  }
  
  /**
   * Apply bonus.
   *
   * @param creature creature receiving the bonus
   */
  public abstract void apply(Creature creature);
  
  /**
   * Remove bonus.
   *
   * @param creature creature losing the bonus
   */
  public abstract void remove(Creature creature);
}
