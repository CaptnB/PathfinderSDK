package com.pathfindersdk.core;

public enum Size
{
  FINE ("Fine", 8, 0.5, 0.0),
  DIMINUTIVE ("Diminutive", 4, 1.0, 0.0),
  TINY ("Tiny", 2, 2.5, 0.0),
  SMALL ("Small", 1, 5.0, 5.0),
  MEDIUM ("Medium", 0, 5.0, 5.0),
  LARGE_TALL ("Large (tall)", -1, 10.0, 10.0),
  LARGE_LONG ("Large (long)", -1, 10.0, 5.0),
  HUGE_TALL ("Huge (tall)", -2, 15.0, 15.0),
  HUGE_LONG ("Huge (long)", -2, 15.0, 10.0),
  GARGANTUAN_TALL ("Gargantuan (tall)", -4, 20.0, 20.0),
  GARGANTUAN_LONG ("Gargantuan (long)", -4, 20.0, 15.0),
  COLOSSAL_TALL ("Colossal (tall)", -8, 30.0, 30.0),
  COLOSSAL_LONG ("Colossal (long)", -8, 30.0, 20.0);
 
  private final String name;
  private final Integer bonus;
  private final Double space;
  private final Double reach;
  
  Size(String name, int bonus, double space, double reach)
  {
    this.name = name;
    this.bonus = bonus;
    this.space = space;
    this.reach = reach;
  }
  
  @Override public String toString()
  {
    return name;
  }
  
  public Integer getSizeBonus()
  {
    return bonus;
  }
  
  public Integer getCmbBonus()
  {
    return -bonus;
  }
  
  public Double getSpace()
  {
    return space;
  }
  
  public Double getReach()
  {
    return reach;
  }
}
