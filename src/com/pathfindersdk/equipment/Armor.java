package com.pathfindersdk.equipment;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.items.ArmorItem;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.ArmorType;
import com.pathfindersdk.enums.BodySlotType;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.utils.ArgChecker;

public class Armor extends Equipment implements Equipable
{
  private ArmorType armorType;
  private Bonus armorBonus;
  private int maxDex;
  private int checkPenalty;
  private double spellFailure;
  private int weight;
  // TODO : special materials (darkwood, adamantine, etc.)
  // TODO : enhancements (mwk, +1, etc.)
  // TODO : special features (Fortification -> critical/sneak attack resistance, Shadow -> +5 Stealth, etc.)
  
  public Armor(ArmorItem item)
  {
    super(item);
    
    setArmorType(item.getArmorType());
    setArmorBonus(item.getArmorBonus());
    setMaxDex(item.getMaxDex());
    setCheckPenalty(item.getCheckPenalty());
    setSpellFailure(item.getSpellFailure());
    setWeight(item.getWeight());
  }

  public ArmorType getArmorType()
  {
    return armorType;
  }

  public void setArmorType(ArmorType armorType)
  {
    ArgChecker.checkNotNull(armorType);
    
    this.armorType = armorType;
  }

  public Bonus getArmorBonus()
  {
    return armorBonus;
  }

  public void setArmorBonus(int armorBonus)
  {
    ArgChecker.checkIsPositive(armorBonus);
    
    this.armorBonus = new AcBonus(armorBonus, BonusTypeRegister.getInstance().get("Armor"));
  }

  public int getMaxDex()
  {
    return maxDex;
  }

  public void setMaxDex(int maxDex)
  {
    ArgChecker.checkIsPositive(maxDex);
    
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
    if(target.getEquipment().getSlot(BodySlotType.ARMOR) == null)
    {
      // Add armor to target's AC
      target.getArmorClass().setArmor(this);
      
      // Add armor to equipped items
      target.getEquipment().setArmorSlot(this);
    }
  }

  @Override
  public void unequip(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    // Make sure the target is wearing this armor
    if(target.getEquipment().getSlot(BodySlotType.ARMOR) == this)
    {
      // Remove armor from target's AC
      target.getArmorClass().setArmor(null);
      
      // Remove armor from equipped items
      target.getEquipment().setArmorSlot(null);
    }
  }
}
