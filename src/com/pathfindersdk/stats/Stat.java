package com.pathfindersdk.stats;

import java.util.Hashtable;
import java.util.TreeSet;

import com.pathfindersdk.bonus.BonusType;
import com.pathfindersdk.bonus.TypedBonus;

/**
 * This class is a generic character stat (ex: Initiative, AC, etc.). 
 */
public class Stat implements StatComponent
{
  // I'd prefer a Hashtable<BonusType, TreeSet<Bonus>> but hey...
  private class BonusGroup
  {
    private TreeSet<TypedBonus> baseBonuses;
    private TreeSet<TypedBonus> circumstantialBonuses;
    
    public TreeSet<TypedBonus> getBaseBonuses()
    {
      if(baseBonuses == null)
        baseBonuses = new TreeSet<TypedBonus>();
      
      return baseBonuses;
    }
    
    public TreeSet<TypedBonus> getCircumstantialBonuses()
    {
      if(circumstantialBonuses == null)
        circumstantialBonuses = new TreeSet<TypedBonus>();
      
      return circumstantialBonuses;
    }
  }
  
  protected Integer baseScore;
  protected Hashtable<BonusType, BonusGroup> bonusGroups;
  
  public Stat(int baseScore)
  {
    this.baseScore = baseScore;
  }
  
  public Integer getBaseScore()
  {
    return baseScore;
  }
  
  public void setBaseScore(int score)
  {
    baseScore = score;
  }
  
  public Integer getScore()
  {
    Integer total = getBaseScore();
    
    if(bonusGroups != null)
    {
      for(BonusType key : bonusGroups.keySet())
      {
        BonusGroup statBonus = bonusGroups.get(key);

        // Add all untyped bonus
        if(key == BonusType.UNTYPED)
          for(TypedBonus bonus : statBonus.getBaseBonuses())
            total += bonus.getValue();
        else
          total += statBonus.getBaseBonuses().first().getValue();
      }
    }
    
    return total;
  }

  public void addBonus(TypedBonus bonus)
  {
    if(bonusGroups == null)
      bonusGroups = new Hashtable<BonusType, BonusGroup>();

    // Check if bonus of that type already exist, create it if it doesn't
    BonusGroup bonusGroup = bonusGroups.get(bonus.getType());
    if(bonusGroup == null)
    {
      bonusGroup = new BonusGroup();
      bonusGroups.put(bonus.getType(), bonusGroup);
    }
    
    // Add bonus to right collection 
    if(bonus.getCircumstance() == null)
      bonusGroup.getBaseBonuses().add(bonus);
    else
      bonusGroup.getCircumstantialBonuses().add(bonus);
  }
  
  public void removeBonus(TypedBonus bonus)
  {
    // Check if bonus of that type already exist, create it if it doesn't
    BonusGroup bonusGroup = bonusGroups.get(bonus.getType());
    if(bonusGroup != null)
    {
      // Add bonus to right collection 
      if(bonus.getCircumstance() == null)
        bonusGroup.getBaseBonuses().remove(bonus);
      else
        bonusGroup.getCircumstantialBonuses().remove(bonus);
      
      // Remove unused StatBonus
      if(bonusGroup.getBaseBonuses().isEmpty() && bonusGroup.getCircumstantialBonuses().isEmpty())
        bonusGroups.remove(bonus.getType());
    }
    
    if(bonusGroups.isEmpty())
      bonusGroups = null;
  }
  
}
