package com.pathfindersdk.stats;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.equipment.Armor;
import com.pathfindersdk.equipment.Shield;
import com.pathfindersdk.utils.ArgChecker;


final public class ArmorClass extends Stat
{
  private AbilityScore dex;
  private List<AbilityScore> abilities; // Monk can add Wisdom
  private Size size;
  private Armor armor;
  private Shield shield;

  public ArmorClass(AbilityScore dex, Size size)
  {
    // AC = 10 + Dex modifier + Size modifier + Misc bonus
    super(10);
    
    ArgChecker.checkNotNull(dex);
    ArgChecker.checkNotNull(size);
    
    this.dex = dex;
    this.size = size;
  }
  
  public void addAbilityScore(AbilityScore score)
  {
    ArgChecker.checkNotNull(score);
    
    if(abilities == null)
      abilities = new ArrayList<AbilityScore>();
    abilities.add(score);
  }
  
  public void removeAbilityScore(AbilityScore score)
  {
    if(abilities != null)
    {
      abilities.remove(score);
      if(abilities.isEmpty())
        abilities = null;
    }
  }
  
  public void setArmor(Armor armor)
  {
    if(this.armor != null)
      removeBonus(this.armor.getArmorBonus());
    
    this.armor = armor;
    
    if(this.armor != null)
      addBonus(this.armor.getArmorBonus());
  }
  
  public void setShield(Shield shield)
  {    
    if(this.shield != null)
      removeBonus(this.shield.getShieldBonus());
    
    this.shield = shield;
    
    if(this.shield != null)
      addBonus(this.shield.getShieldBonus());
  }
  
  private int getMaxDex()
  {
    int maxDex = dex.getModifier();
    
    if(armor != null)
      maxDex = Math.min(armor.getMaxDex(), maxDex);
    
    if(shield != null && shield.getMaxDex() != null)    // Not all shields have a max dex defined
      maxDex = Math.min(shield.getMaxDex(), maxDex);
    
    return maxDex;
  }
  
  private int getAbilityModifiers()
  {
    int modifiers = 0;
    
    if(abilities != null)
    {
      for(AbilityScore ability : abilities)
        modifiers += ability.getModifier();
    }
    
    return modifiers;
  }

  public int getTouchScore()
  {
    // Touch AC ignores armor, shield and natural AC bonus
    int touchBonus = 0;
    SortedSet<Bonus> bonusSet = bonusBlock.getApplicableBaseBonus();
    for(Bonus bonus : bonusSet)
    {
      if(!bonus.getType().equals(BonusTypeRegister.getInstance().get("Armor")) && 
         !bonus.getType().equals(BonusTypeRegister.getInstance().get("Shield")) && 
         !bonus.getType().equals(BonusTypeRegister.getInstance().get("Natural Armor")))
      {
        touchBonus += bonus.getValue();
      }
    }
    
    return getBaseScore() + touchBonus + getMaxDex() + getAbilityModifiers() + size.getModifier();
  }
  
  public int getFlatFootedScore()
  {
    // Flat-footed AC ignores dodge bonus
    int flatFootedBonus = 0;
    SortedSet<Bonus> bonusSet = bonusBlock.getApplicableBaseBonus();
    for(Bonus bonus : bonusSet)
    {
      if(bonus.getType() != BonusTypeRegister.getInstance().get("Dodge"))
      {
        flatFootedBonus += bonus.getValue();
      }
    }
    
    // Flat-footed AC also ignores dex modifier
    return getBaseScore() + flatFootedBonus + getAbilityModifiers() + size.getModifier();
  }
  
  @Override
  public int getScore()
  {
    // 10 + bonus + max dex + size modifier
    return super.getScore() + getMaxDex() + getAbilityModifiers() + size.getModifier();
  }

}
