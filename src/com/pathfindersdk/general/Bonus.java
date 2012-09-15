package com.pathfindersdk.general;

import com.pathfindersdk.creatures.characters.Character;

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
   */
  public Bonus(int bonus, BonusType type, Boolean circumstantial)
  {
    this.bonus = bonus;
    this.type = type;
    this.circumstantial = circumstantial;
  }
  
  public abstract void apply(Character character);
}
