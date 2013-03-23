package com.pathfindersdk.stats;

public class ArmorClass extends Stat
{
  protected AbilityScore dex;
  protected Integer maxDex;

  public ArmorClass(int baseScore, AbilityScore dex)
  {
    super(10);
    this.dex = dex;
  }

  public void setMaxDex(Integer maxDex)
  {
    this.maxDex = maxDex;
  }
  
  @Override
  public Integer getScore()
  {
    return super.getScore() + Math.min(dex.getModifier(), maxDex);
  }

}
