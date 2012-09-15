package com.pathfindersdk.general;

/**
 * The Class AbilityScore.
 */
public class AbilityScore
{
  
  /** Ability score. */
  private Integer score;
  
  /** Ability type. */
  private Ability ability;
  
  /**
   * Instantiates a new ability score.
   *
   * @param score Score
   * @param ability Ability
   */
  public AbilityScore(int score, Ability ability)
  {
    this.score = score;
    this.ability = ability;
  }
  
  public Ability getAbility()
  {
    return ability;
  }

  public Integer getScore()
  {
    return score;
  }

  /**
   * Adds (or substract) to the score.
   *
   * @param add the add
   */
  public void add(int add)
  {
    score += add;
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
