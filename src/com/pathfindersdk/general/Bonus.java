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
  
  /**
   * Instantiates a new bonus.
   *
   * @param bonus bonus
   * @param type type
   * @param circumstantial the circumstantial
   */
  public Bonus(int bonus, BonusType type, Boolean circumstantial)
  {
    this.bonus = bonus;
    this.type = type;
    this.circumstantial = circumstantial;
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
