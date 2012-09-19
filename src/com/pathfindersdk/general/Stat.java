package com.pathfindersdk.general;

import java.util.Enumeration;
import java.util.Hashtable;

public class Stat
{
  private Integer baseScore;
  private Hashtable<BonusType, StatBonus> statBonuses = new Hashtable<BonusType, StatBonus>();
  
  public Stat(int baseScore)
  {
    this.baseScore = baseScore;
  }
  
  public Integer getBaseScore()
  {
    return baseScore;
  }
  
  public Integer getScore()
  {
    // Init total with base score
    Integer total = getBaseScore();
    
    // Get all keys
    Enumeration<BonusType> keys = statBonuses.keys();
    while(keys.hasMoreElements())
    {
      BonusType key = keys.nextElement();
      StatBonus statBonus = statBonuses.get(key);
      
      // If bonus is untyped, then add them all
      if(key == BonusType.UNTYPED)
      {
        for(Bonus bonus : statBonus.getBaseBonuses())
        {
          total += bonus.getValue();
        }
      }
      
      // Bonus is not stackable, take biggest
      else
      {
        total += statBonus.getBaseBonuses().first().getValue();
      }
    }
    
    return total;
  }

  public void addBonus(Bonus bonus)
  {
    // Check if bonus of that type already exist, create it if it doesn't
    StatBonus statBonus = statBonuses.get(bonus.getType());
    if(statBonus == null)
    {
      statBonus = new StatBonus();
      statBonuses.put(bonus.getType(), statBonus);
    }
    
    // Add bonus to right collection 
    if(bonus.getCircumstance() == null)
      statBonus.getBaseBonuses().add(bonus);
    else
      statBonus.getCircumstantialBonuses().add(bonus);
  }
  
  public void removeBonus(Bonus bonus)
  {
    // Check if bonus of that type already exist, create it if it doesn't
    StatBonus statBonus = statBonuses.get(bonus.getType());
    if(statBonus != null)
    {
      // Add bonus to right collection 
      if(bonus.getCircumstance() == null)
        statBonus.getBaseBonuses().remove(bonus);
      else
        statBonus.getCircumstantialBonuses().remove(bonus);
      
      // Remove unused StatBonus
      if(statBonus.getBaseBonuses().isEmpty() && statBonus.getCircumstantialBonuses().isEmpty())
        statBonuses.remove(bonus.getType());
    }
  }

}
