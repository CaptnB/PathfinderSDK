package com.pathfindersdk.books.items;

import com.pathfindersdk.coins.Coins;
import com.pathfindersdk.enums.ArmorType;
import com.pathfindersdk.utils.ArgChecker;


public class ArmorItem extends EquipmentItem
{
  private final ArmorType armorType;
  private final int armorBonus;
  private final int maxDex;
  private final int checkPenalty;
  private final double spellFailure;
  private final int weight;

  public ArmorItem(String name, ArmorType armorType, int armorBonus, int maxDex, int checkPenalty, 
      double spellFailure, int weight, Coins cost)
  {
    super(name, cost);
    
    ArgChecker.checkNotNull(armorType);
    ArgChecker.checkIsPositive(armorBonus);
    ArgChecker.checkIsPositive(maxDex);
    ArgChecker.checkIsNegative(checkPenalty);
    ArgChecker.checkInRange(spellFailure, 0.0, 100.0);
    ArgChecker.checkIsPositive(weight);
    
    this.armorType = armorType;
    this.armorBonus = armorBonus;
    this.maxDex = maxDex;
    this.checkPenalty = checkPenalty;
    this.spellFailure = spellFailure;
    this.weight = weight;
  }

  public ArmorType getArmorType()
  {
    return armorType;
  }
  
  public int getArmorBonus()
  {
    return armorBonus;
  }

  public int getMaxDex()
  {
    return maxDex;
  }

  public int getCheckPenalty()
  {
    return checkPenalty;
  }

  public double getSpellFailure()
  {
    return spellFailure;
  }

  public int getWeight()
  {
    return weight;
  }
}
