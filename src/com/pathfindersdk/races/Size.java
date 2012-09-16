package com.pathfindersdk.races;

/**
 * The Enum Size.
 */
public enum Size
{
  
  /** Fine creature size. */
  FINE ("Fine", 8, 0.5, 0.0),
  
  /** Diminutive creature size. */
  DIMINUTIVE ("Diminutive", 4, 1.0, 0.0),
  
  /** Tiny creature size. */
  TINY ("Tiny", 2, 2.5, 0.0),
  
  /** Small creature size. */
  SMALL ("Small", 1, 5.0, 5.0),
  
  /** Medium creature size. */
  MEDIUM ("Medium", 0, 5.0, 5.0),
  
  /** Large (tall) creature size. */
  LARGE_TALL ("Large (tall)", -1, 10.0, 10.0),
  
  /** Large (long) creature size. */
  LARGE_LONG ("Large (long)", -1, 10.0, 5.0),
  
  /** Huge (tall) creature size. */
  HUGE_TALL ("Huge (tall)", -2, 15.0, 15.0),
  
  /** Huge (long) creature size. */
  HUGE_LONG ("Huge (long)", -2, 15.0, 10.0),
  
  /** Gargantuan (tall) creature size. */
  GARGANTUAN_TALL ("Gargantuan (tall)", -4, 20.0, 20.0),
  
  /** Gargantuan (long) creature size. */
  GARGANTUAN_LONG ("Gargantuan (long)", -4, 20.0, 15.0),
  
  /** Colossal (tall) creature size. */
  COLOSSAL_TALL ("Colossal (tall)", -8, 30.0, 30.0),
  
  /** Colossal (long) creature size. */
  COLOSSAL_LONG ("Colossal (long)", -8, 30.0, 20.0);
 
  /** Size name. */
  private final String name;
  
  /** Size modifier. */
  private final Integer modifier;
  
  /** Size space. */
  private final Double space;
  
  /** Size reach. */
  private final Double reach;
  
  /**
   * Instantiates a new size.
   *
   * @param name the name
   * @param modifier the modifier
   * @param space the space
   * @param reach the reach
   */
  private Size(String name, int modifier, double space, double reach)
  {
    this.name = name;
    this.modifier = modifier;
    this.space = space;
    this.reach = reach;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override public String toString()
  {
    return name;
  }
  
  public Integer getSizeBonus()
  {
    return modifier;
  }
  
  public Integer getCmbBonus()
  {
    return -modifier;
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
