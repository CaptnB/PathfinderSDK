package com.pathfindersdk.stats;

import java.util.SortedSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.enums.BonusType;


public class ArmorClass extends Stat
{
  protected AbilityScore dex;
  protected Size size;
  protected Integer maxDex;

  public ArmorClass(AbilityScore dex, Size size)
  {
    // AC = 10 + Dex modifier + Size modifier + Misc bonus
    super(10);
    this.dex = dex;
    this.size = size;
  }

  public void setMaxDex(Integer maxDex)
  {
    this.maxDex = maxDex;
  }
  
  public Integer getTouch()
  {
    Integer touch = getBaseScore();
    
    // Touch AC ignores armor, shield and natural AC
    SortedSet<Bonus> bonusSet = getAllBaseBonuses();
    for(Bonus bonus : bonusSet)
    {
      if(bonus.getType() != BonusType.ARMOR && 
         bonus.getType() != BonusType.SHIELD && 
         bonus.getType() != BonusType.NATURAL_ARMOR)
      {
        touch += bonus.getValue();
      }
    }
    
    // Add dex modifier (limited by armor max dex if any)
    if(dex != null)
    {
      if(maxDex != null)
        touch += Math.min(dex.getModifier(), maxDex);
      else
        touch += dex.getModifier();
    }
 
    // Add size modifier
    if(size != null)
      touch += size.getModifier();
    
    return touch;
  }
  
  public Integer getFlatFooted()
  {
    Integer flatFooted = getBaseScore();
    
    // Flat-footed AC does not include dex modifier and ignores dodge bonus
    SortedSet<Bonus> bonusSet = getAllBaseBonuses();
    for(Bonus bonus : bonusSet)
    {
      if(bonus.getType() != BonusType.DODGE)
      {
        flatFooted += bonus.getValue();
      }
    }
    
    // Add size modifier
    if(size != null)
      flatFooted += size.getModifier();
    
    return flatFooted;
  }
  
  @Override
  public Integer getScore()
  {
    // Add all bonuses
    Integer ac = super.getScore();
    
    // Add dex modifier (limited by armor max dex if any)
    if(dex != null)
    {
      if(maxDex != null)
        ac += Math.min(dex.getModifier(), maxDex);
      else
        ac += dex.getModifier();
    }
    
    // Add size modifier
    if(size != null)
      ac += size.getModifier();
    
    return ac;
  }

}
