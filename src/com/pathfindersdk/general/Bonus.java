package com.pathfindersdk.general;

public abstract class Bonus
{
  protected Integer bonus;
  protected BonusType type;
  
  public Bonus(int bonus, BonusType type)
  {
    this.bonus = bonus;
    this.type = type;
  }  
}
