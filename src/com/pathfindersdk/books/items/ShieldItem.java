package com.pathfindersdk.books.items;

import com.pathfindersdk.coins.Coins;
import com.pathfindersdk.utils.ArgChecker;


public class ShieldItem extends EquipmentItem
{
  private final int shieldBonus;
  private final Integer maxDex;       // Only Tower Shield has a max dex, all other shields don't
  private final int checkPenalty;
  private final double spellFailure;
  private final int weight;

  public ShieldItem(String name, int shieldBonus, int checkPenalty, 
      double spellFailure, int weight, Coins cost)
  {
    this(name, shieldBonus, null, checkPenalty, spellFailure, weight, cost);
  }
  
  public ShieldItem(String name, int shieldBonus, Integer maxDex, int checkPenalty, 
      double spellFailure, int weight, Coins cost)
  {
    super(name, cost);
    
    ArgChecker.checkIsPositive(shieldBonus);
    if(maxDex != null)
      ArgChecker.checkIsPositive(maxDex);
    ArgChecker.checkIsNegative(checkPenalty);
    ArgChecker.checkInRange(spellFailure, 0.0, 100.0);
    ArgChecker.checkIsPositive(weight);
    
    this.shieldBonus = shieldBonus;
    this.maxDex = maxDex;
    this.checkPenalty = checkPenalty;
    this.spellFailure = spellFailure;
    this.weight = weight;
  }

  public int getShieldBonus()
  {
    return shieldBonus;
  }

  public Integer getMaxDex()
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
