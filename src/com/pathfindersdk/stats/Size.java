package com.pathfindersdk.stats;

import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.utils.ArgChecker;

final public class Size extends Stat
{
  final private SizeType baseSize;
  final private int numberOfLegs;
  
  public Size(SizeType baseSize)
  {
    this(baseSize, 2);
  }
  
  public Size(SizeType baseSize, int numberOfLegs)
  {
    // The Stat score represents the size offset from baseSize (BaseSize.MEDIUM + 2 = BaseSize.HUGE).
    // baseScore shall then always remain at 0.
    super(0);

    ArgChecker.checkNotNull(baseSize);
    ArgChecker.checkIsPositive(numberOfLegs);
    
    this.baseSize = baseSize;
    this.numberOfLegs = numberOfLegs;
  }
  
  public SizeType getBaseSize()
  {
    return baseSize;
  }
  
  public int getNumberOfLegs()
  {
    return numberOfLegs;
  }
  
  // To only consider bonuses, make sure baseScore always remains zero
  @Override
  public void setBaseScore(int score) {}
  
  public SizeType getSize()
  {
    return baseSize.offset(getScore());
  }
  
  public int getModifier()
  {
    switch(getSize())
    {
    case FINE:
      return 8;
      
    case DIMINUTIVE:
      return 4;
      
    case TINY:
      return 2;
      
    case SMALL:
      return 1;
      
    case MEDIUM:
      return 0;
      
    case LARGE:
      return -1;
      
    case HUGE: 
      return -2;
      
    case GARGANTUAN:
      return -4;
      
    case COLOSSAL:
      return -8;
      
    default:
      System.out.println("Unknown SizeType");
      return 0;
    }
  }
  
  public int getSkillModifier()
  {
    switch(getSize())
    {
    case FINE:
      return 8;
      
    case DIMINUTIVE:
      return 6;
      
    case TINY:
      return 4;
      
    case SMALL:
      return 2;
      
    case MEDIUM:
      return 0;
      
    case LARGE:
      return -2;
      
    case HUGE: 
      return -4;
      
    case GARGANTUAN:
      return -6;
      
    case COLOSSAL:
      return -8;
      
    default:
      System.out.println("Unknown SizeType");
      return 0;
    }
  }
  
  public double getSpace()
  {
    switch(getSize())
    {
    case FINE:
      return 0.5;
      
    case DIMINUTIVE:
      return 1.0;
      
    case TINY:
      return 2.5;
      
    case SMALL:
      return 5.0;
      
    case MEDIUM:
      return 5.0;
      
    case LARGE:
      return 10.0;
      
    case HUGE: 
      return 15.0;
      
    case GARGANTUAN:
      return 20.0;
      
    case COLOSSAL:
      return 30.0;
      
    default:
      System.out.println("Unknown SizeType");
      return 5.0;
    }
  }
  
  public boolean isTall()
  {
    // Otyugh is considered tall with 3 legs (don't recall any one-legged monster)
    // I'm assuming that everything without legs or more than 4 is long...
    return (numberOfLegs >= 1 && numberOfLegs < 4);
  }
  
  public boolean isLong()
  {
    return !isTall();
  }
  
  public double getReach()
  {
    switch(getSize())
    {
    case FINE:
      return 0.0;
      
    case DIMINUTIVE:
      return 0.0;
      
    case TINY:
      return 0.0;
      
    case SMALL:
      return 5.0;
      
    case MEDIUM:
      return 5.0;
      
    case LARGE:
      if(isTall())
        return 10.0;
      else
        return 5.0;
      
    case HUGE: 
      if(isTall())
        return 15.0;
      else
        return 10.0;
      
    case GARGANTUAN:
      if(isTall())
        return 20.0;
      else
        return 15.0;
      
    case COLOSSAL:
      if(isTall())
        return 30.0;
      else
        return 20.0;
      
    default:
      System.out.println("Unknown SizeType");
      return 5.0;
    }
  }

  @Override
  public String toString()
  {
    return getSize().toString();
  }
}
