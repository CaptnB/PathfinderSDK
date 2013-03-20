package com.pathfindersdk.enums;

/**
 * This enum lists all creature sizes and related space, reach and size bonus.
 */
public enum SizeType
{
  FINE       ("Fine"), 
  DIMINUTIVE ("Diminutive"), 
  TINY       ("Tiny"), 
  SMALL      ("Small"), 
  MEDIUM     ("Medium"), 
  LARGE      ("Large"), 
  HUGE       ("Huge"), 
  GARGANTUAN ("Gargantuan"), 
  COLOSSAL   ("Colossal");

  private final String name;

  private SizeType(String name)
  {
    this.name = name;
  }

  
  public SizeType offset(int offset)
  {
    int offsetOrdinal = this.ordinal() + offset;
    SizeType[] values = SizeType.values();
    
    // Check bounds
    if(offsetOrdinal < 0)
      offsetOrdinal = 0;
    else if(offsetOrdinal >= values.length)
      offsetOrdinal = values.length - 1;
    
    return values[offsetOrdinal];
  }

  @Override
  public String toString()
  {
    return name;
  }
}
