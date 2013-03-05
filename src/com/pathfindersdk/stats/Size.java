package com.pathfindersdk.stats;

import com.pathfindersdk.enums.SizeType;

public class Size extends Stat
{
  protected SizeType baseSize;
  
  public Size(SizeType baseSize)
  {
    // The Stat score represents the size offset from baseSize (BaseSize.MEDIUM + 2 = BaseSize.HUGE).
    super(0);
    
    this.baseSize = baseSize;
  }
  
  public void setBaseSize(SizeType baseSize)
  {
    this.baseSize = baseSize;
  }
  
  public SizeType getBaseSize()
  {
    return baseSize;
  }

  // To only consider bonuses, make sure baseScore always remains zero
  @Override
  public void setBaseScore(int score) {}
  
  public SizeType getSize(boolean biped)
  {
    return baseSize.offset(getScore(), biped);
  }
}
