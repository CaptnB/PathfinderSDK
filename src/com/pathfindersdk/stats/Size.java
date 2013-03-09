package com.pathfindersdk.stats;

import com.pathfindersdk.enums.SizeType;

public class Size extends Stat
{
  protected SizeType baseSize;
  protected int numberOfLegs;
  
  public Size(SizeType baseSize)
  {
    // The Stat score represents the size offset from baseSize (BaseSize.MEDIUM + 2 = BaseSize.HUGE).
    // baseScore shall then always remain at 0.
    super(0);
    
    setBaseSize(baseSize);
    setNumberOfLegs(2); // Most creatures are biped
  }
  
  public Size(SizeType baseSize, int numberOfLegs)
  {
    super(0);
    
    setBaseSize(baseSize);
    setNumberOfLegs(numberOfLegs);
  }
  
  public void setBaseSize(SizeType baseSize)
  {
    this.baseSize = baseSize;
  }
  
  public SizeType getBaseSize()
  {
    return baseSize;
  }
  
  public void setNumberOfLegs(int numberOfLegs)
  {
    // Creatures without legs (Ooze) or creatures with too many legs (Centipede), can't be tripped
    // Use 0 in any case. 0 means "can't be tripped"
    
    if(numberOfLegs < 0)
      this.numberOfLegs = 0;
    else
      this.numberOfLegs = numberOfLegs;
      
  }
  
  public Integer getNumberOfLegs()
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
  
  public Integer getModifier()
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
  
  public Double getSpace()
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
  
  public Boolean isTall()
  {
    // Otyugh is considered tall with 3 legs (don't recall any one-legged monster)
    // I'm assuming that everything without legs or more than 4 is long...
    return (numberOfLegs >= 1 && numberOfLegs < 4);
  }
  
  public Boolean isLong()
  {
    return !isTall();
  }
  
  public Double getReach()
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
}
