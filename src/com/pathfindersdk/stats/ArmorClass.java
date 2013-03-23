package com.pathfindersdk.stats;

public class ArmorClass extends Stat
{
  protected AbilityScore dex;
  protected Size size;
  protected Integer maxDex;

  public ArmorClass(AbilityScore dex, Size size)
  {
    super(10);
    
    if(dex != null)
      this.dex = dex;
    else
      throw new IllegalArgumentException("dex must not be null");
    
    if(size != null)
      this.size = size;
    else
      throw new IllegalArgumentException("size must not be null");
  }

  public void setMaxDex(Integer maxDex)
  {
    this.maxDex = maxDex;
  }
  
  @Override
  public Integer getScore()
  {
    return super.getScore() + Math.min(dex.getModifier(), maxDex) + size.getModifier();
  }

}
