package com.pathfindersdk.core;

public class AbilityScore
{
  private Ability ability;
  private Integer score;
  
  AbilityScore(Ability ability, int score)
  {
    this.ability = ability;
    setScore(score);
  }
  
  public Ability getAbility()
  {
    return ability;
  }

  public Integer getScore()
  {
    return score;
  }

  void setScore(Integer score)
  {
    if(score < 0)
      this.score = 0;
    else
      this.score = score;
  }
  
  public void add(int add)
  {
    setScore(score + add);
  }

  public Integer getModifier()
  {
    return (int)Math.floor((getScore() - 10) / 2f);
  }
}
