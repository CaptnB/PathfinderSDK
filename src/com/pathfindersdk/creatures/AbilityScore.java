package com.pathfindersdk.creatures;

import java.util.HashSet;

/**
 * The Class AbilityScore.
 */
public class AbilityScore
{
  
  /** Ability type. */
  private Ability ability;
  
  /** Ability score. */
  private Integer score;
  
  /** The bonuses. */
  private HashSet<AbilityBonus> bonuses = new HashSet<AbilityBonus>();
  
  /**
   * Instantiates a new ability score.
   *
   * @param score Score
   * @param ability Ability
   */
  public AbilityScore(Ability ability, int score)
  {
    this.ability = ability;
    this.score = score;
  }
  
  public Ability getAbility()
  {
    return ability;
  }

  public Integer getScore()
  {
    return score;
  }
  
  public HashSet<AbilityBonus> getBonuses()
  {
    return bonuses;
  }

  /**
   * Increments the score.
   */
  public void increment()
  {
    score += 1;
  }

  /**
   * Decrements the score.
   */
  public void decrement()
  {
    score -= 1;
  }

  /**
   * Gets the ability score modifier.
   *
   * @return the modifier
   */
  public Integer getModifier()
  {
    return (int)Math.floor((getScore() - 10) / 2f);
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override public String toString()
  {
    if(score < 10)
      return ability.toString() + " " + score + " (" + getModifier() + ")";
    else
      return ability.toString() + " " + score + " (+" + getModifier() + ")";
  }
}
