package com.pathfindersdk.stats;

import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.enums.BonusType;

/**
 * This class is a generic character stat (ex: Initiative, AC, etc.). 
 */
public class Stat
{
  // I'd prefer a SortedMap<BonusType, SortedSet<Bonus>> but hey...
  private class BonusGroup
  {
    private SortedSet<Bonus> baseBonuses;
    private SortedSet<Bonus> circumstantialBonuses;
    
    public SortedSet<Bonus> getBaseBonuses()
    {
      return Collections.unmodifiableSortedSet(baseBonuses);
    }
    
    public SortedSet<Bonus> getCircumstantialBonuses()
    {
      return Collections.unmodifiableSortedSet(circumstantialBonuses);
    }
    
    public void addBonus(Bonus bonus)
    {
      if(bonus != null)
      {
        if(bonus.getCircumstance() == null)
        {
          if(baseBonuses == null)
            baseBonuses = new TreeSet<Bonus>();
          
          baseBonuses.add(bonus);
        }
        else
        {
          if(circumstantialBonuses == null)
            circumstantialBonuses = new TreeSet<Bonus>();
          
          circumstantialBonuses.add(bonus);
        }
      }
    }
    
    public void removeBonus(Bonus bonus)
    {
      if(bonus != null)
      {
        if(bonus.getCircumstance() == null)
        {
          if(baseBonuses != null)
            baseBonuses.remove(bonus);
        }
        else
        {
          if(circumstantialBonuses != null)
            circumstantialBonuses.remove(bonus);
        }
      }
    }
  }
  
  protected Integer baseScore;
  protected SortedMap<BonusType, BonusGroup> bonusGroups;
  
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
    SortedSet<Bonus> bonusSet = getAllBaseBonuses();

    for(Bonus bonus : bonusSet)
      total += bonus.getValue();
    
    return total;
  }
  
  public void incrementBaseScore(int increment)
  {
    setBaseScore(baseScore + increment);
  }
  
  public SortedSet<Bonus> getAllBaseBonuses()
  {
    SortedSet<Bonus> bonusSet = new TreeSet<Bonus>();
    
    if(bonusGroups != null)
    {
      for(BonusType type : bonusGroups.keySet())
      {
        BonusGroup group = bonusGroups.get(type);
        
        // Untyped bonuses stack so get them all
        if(type.equals(BonusType.UNTYPED))
        {
          for(Bonus bonus : group.getBaseBonuses())
            bonusSet.add(bonus);
        }
        
        // Typed bonuses don't stack so get the biggest (1st one in SortedSet)
        else
          bonusSet.add(group.getBaseBonuses().first());
      }
    }
    
    return Collections.unmodifiableSortedSet(bonusSet);
  }
  
  public SortedSet<Bonus> getAllCircumstantialBonuses()
  {
    // Circumstantial bonuses may come from any BonusType so this method gathers them all into one TreeSet
    SortedSet<Bonus> bonusSet = new TreeSet<Bonus>();
    
    if(bonusGroups != null)
    {
      for(BonusType type : bonusGroups.keySet())
      {
        BonusGroup group = bonusGroups.get(type);

        for(Bonus bonus : group.getCircumstantialBonuses())
          bonusSet.add(bonus);
      }
    }
    
    return Collections.unmodifiableSortedSet(bonusSet);
  }

  public void addBonus(Bonus bonus)
  {
    if(bonusGroups == null)
      bonusGroups = new TreeMap<BonusType, BonusGroup>();

    // Check if bonus of that type already exist, create it if it doesn't
    BonusGroup bonusGroup = bonusGroups.get(bonus.getType());
    if(bonusGroup == null)
    {
      bonusGroup = new BonusGroup();
      bonusGroups.put(bonus.getType(), bonusGroup);
    }
    bonusGroup.addBonus(bonus);
  }
  
  public void removeBonus(Bonus bonus)
  {
    BonusGroup bonusGroup = bonusGroups.get(bonus.getType());
    if(bonusGroup != null)
    {
      bonusGroup.removeBonus(bonus);
      
      // Remove unused bonus type
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
    SortedSet<Bonus> circSet = getAllCircumstantialBonuses(); 
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
