package com.pathfindersdk.stats;

import java.util.SortedSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.enums.BonusTypeRegister;


public class ArmorClass extends Stat
{
  protected AbilityScore dex;
  protected Size size;
  // TODO : max dex from armor/shield
//  protected int maxDex; this should be a reference to shield/armor.getMaxDex()

  public ArmorClass(AbilityScore dex, Size size)
  {
    // AC = 10 + Dex modifier + Size modifier + Misc bonus
    super(10);
    this.dex = dex;
    this.size = size;
  }

//  public void setMaxDex(int maxDex)
//  {
//    this.maxDex = maxDex;
//  }

  public int getTouch()
  {
    int touch = getBaseScore();
    
    // Touch AC ignores armor, shield and natural AC
    SortedSet<Bonus> bonusSet = getBonusBlock().getApplicableBaseBonus();
    for(Bonus bonus : bonusSet)
    {
      if(!bonus.getType().equals(BonusTypeRegister.getInstance().get("Armor")) && 
         !bonus.getType().equals(BonusTypeRegister.getInstance().get("Shield")) && 
         !bonus.getType().equals(BonusTypeRegister.getInstance().get("Natural Armor")))
      {
        touch += bonus.getValue();
      }
    }
    
    // Add dex modifier (limited by armor max dex if any)
    if(dex != null)
    {
//      if(maxDex > 0)
//        touch += Math.min(dex.getModifier(), maxDex);
//      else
        touch += dex.getModifier();
    }
 
    // Add size modifier
    if(size != null)
      touch += size.getModifier();
    
    return touch;
  }
  
  public int getFlatFooted()
  {
    int flatFooted = getBaseScore();
    
    // Flat-footed AC does not include dex modifier and ignores dodge bonus
    SortedSet<Bonus> bonusSet = getBonusBlock().getApplicableBaseBonus();
    for(Bonus bonus : bonusSet)
    {
      if(bonus.getType() != BonusTypeRegister.getInstance().get("Dodge"))
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
  public int getScore()
  {
    // Add all bonuses
    int ac = super.getScore();
    
    // Add dex modifier (limited by armor max dex if any)
    if(dex != null)
    {
//      if(maxDex > 0)
//        ac += Math.min(dex.getModifier(), maxDex);
//      else
        ac += dex.getModifier();
    }
    
    // Add size modifier
    if(size != null)
      ac += size.getModifier();
    
    return ac;
  }

}
