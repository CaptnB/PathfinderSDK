package com.pathfindersdk.general;

public class AbilityScore
{
  private Integer score;
  private Ability ability;
  
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

  public void add(int add)
  {
    score += add;
  }

  public Integer getModifier()
  {
    return (int)Math.floor((getScore() - 10) / 2f);
  }
  
  @Override public String toString()
  {
    if(score < 10)
      return ability.toString() + " " + score + " (" + getModifier() + ")";
    else
      return ability.toString() + " " + score + " (+" + getModifier() + ")";
  }
}
