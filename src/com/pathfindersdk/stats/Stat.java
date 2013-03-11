package com.pathfindersdk.stats;

import java.util.Hashtable;
import java.util.TreeSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.enums.BonusType;

/**
 * This class is a generic character stat (ex: Initiative, AC, etc.). 
 */
public class Stat
{
  // I'd prefer a Hashtable<BonusType, TreeSet<Bonus>> but hey...
  private class BonusGroup
  {
    private TreeSet<Bonus> baseBonuses = new TreeSet<Bonus>();
    private TreeSet<Bonus> circumstantialBonuses = new TreeSet<Bonus>();
    
    public TreeSet<Bonus> getBaseBonuses()
    {
      return baseBonuses;
    }
    
    public TreeSet<Bonus> getCircumstantialBonuses()
    {
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
        BonusGroup group = bonusGroups.get(key);

        // Only consider base bonuses as they are permanent (i.e. do not add circumstantial bonuses to total)
        if(!group.getBaseBonuses().isEmpty())
        {
          // Untyped bonuses always stack
          if(key == BonusType.UNTYPED)
            for(Bonus bonus : group.getBaseBonuses())
              total += bonus.getValue();
          
          // Typed bonuses do not stack so use the biggest one (sorted in descending order, first == biggest)
          else
            total += group.getBaseBonuses().first().getValue();
        }
      }
    }
    
    return total;
  }
  
  public TreeSet<Bonus> getAllCircumstantialBonuses()
  {
    // Circumstantial bonuses may come from any BonusType so this method gathers them all into one TreeSet
    TreeSet<Bonus> circSet = new TreeSet<Bonus>();
    
    if(bonusGroups != null)
    {
      for(BonusType key : bonusGroups.keySet())
      {
        BonusGroup group = bonusGroups.get(key);

        if(!group.getCircumstantialBonuses().isEmpty())
          for(Bonus bonus : group.getCircumstantialBonuses())
            circSet.add(bonus);
      }
    }
    
    return circSet;
  }

  public void addBonus(Bonus bonus)
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
  
  public void removeBonus(Bonus bonus)
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
  
  @Override
  public String toString()
  {
    // With all circumstantial bonuses, list them in parenthesis
    String circumstantial = "";
    TreeSet<Bonus> circSet = getAllCircumstantialBonuses(); 
    if(!circSet.isEmpty())
    {
      circumstantial += " (";
      for(Bonus bonus : circSet)
      {
        if(bonus.getValue() >= 0)
          circumstantial += "+";
        
        circumstantial += bonus.getValue().toString() + " " + bonus.getType().toString() + " " + bonus.getCircumstance();
        
        if(bonus != circSet.last())
          circumstantial += ", ";
      }
      circumstantial += ")";
    }

    return getScore().toString() + circumstantial;
  }
}
