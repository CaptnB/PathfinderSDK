package com.pathfindersdk.equipment;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.items.ShieldItem;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BodySlotType;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.utils.ArgChecker;

public class Shield extends Equipment implements Equipable
{
  private Bonus shieldBonus;
  private Integer maxDex;       // Only Tower Shield has a max dex, all other shields don't
  private int checkPenalty;
  private double spellFailure;
  private int weight;
  // TODO : special materials (darkwood, adamantine, etc.)
  // TODO : enhancements (mwk, +1, etc.)
  // TODO : special features (Fortification -> critical/sneak attack resistance, Shadow -> +5 Stealth, etc.)
  
  public Shield(ShieldItem item)
  {
    super(item);
    
    setShieldBonus(item.getShieldBonus());
    setMaxDex(item.getMaxDex());
    setCheckPenalty(item.getCheckPenalty());
    setSpellFailure(item.getSpellFailure());
    setWeight(item.getWeight());
  }

  public void setShieldBonus(int shieldBonus)
  {
    ArgChecker.checkIsPositive(shieldBonus);
    
    this.shieldBonus = new AcBonus(shieldBonus, BonusTypeRegister.getInstance().get("Shield"));
  }
  
  public Bonus getShieldBonus()
  {
    return shieldBonus;
  }

  public Integer getMaxDex()
  {
    return maxDex;
  }

  public void setMaxDex(Integer maxDex)
  {
    this.maxDex = maxDex;
  }

  public int getCheckPenalty()
  {
    return checkPenalty;
  }

  public void setCheckPenalty(int checkPenalty)
  {
    ArgChecker.checkIsNegative(checkPenalty);
    
    this.checkPenalty = checkPenalty;
  }

  public double getSpellFailure()
  {
    return spellFailure;
  }

  public void setSpellFailure(double spellFailure)
  {
    ArgChecker.checkInRange(spellFailure, 0.0, 100.0);
    
    this.spellFailure = spellFailure;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight(int weight)
  {
    ArgChecker.checkIsPositive(weight);
    
    this.weight = weight;
  }

  
  @Override
  public void equip(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    // Make sure the slot is empty
    if(target.getEquipment().getSlot(BodySlotType.OFF_HAND) == null)
    {
      // Add shield to target's AC
      target.getArmorClass().setShield(this);
      
      // Add shield to equipped items
      target.getEquipment().setOffHandSlot(this);
    }
  }

  @Override
  public void unequip(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    // Make sure the target is wearing this armor
    if(target.getEquipment().getSlot(BodySlotType.ARMOR) == this)
    {
      // Remove shield from target's AC
      target.getArmorClass().setShield(null);
      
      // Remove armor from equipped items
      target.getEquipment().setOffHandSlot(null);
    }
  }

}
