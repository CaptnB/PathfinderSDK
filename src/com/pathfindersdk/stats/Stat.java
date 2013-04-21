package com.pathfindersdk.stats;

import java.util.SortedSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.BonusBlock;

/**
 * This class is a generic character stat (ex: Initiative, AC, etc.). 
 */
public class Stat
{
  private int baseScore;
  final protected transient BonusBlock bonusBlock = new BonusBlock();
  
  public Stat(int baseScore)
  {
    this.baseScore = baseScore;
  }
  
  public int getBaseScore()
  {
    return baseScore;
  }
  
  public void setBaseScore(int score)
  {
    baseScore = score;
  }
  
  public void incrementBaseScore(int increment)
  {
    setBaseScore(baseScore + increment);
  }

  public int getScore()
  {
    int total = getBaseScore();

    SortedSet<Bonus> bonusSet = bonusBlock.getApplicableBaseBonus();
    for(Bonus bonus : bonusSet)
      total += bonus.getValue();
    
    return total;
  }
  

  public void addBonus(Bonus bonus)
  {
    bonusBlock.addBonus(bonus);
  }
  
  public void removeBonus(Bonus bonus)
  {
    bonusBlock.removeBonus(bonus);
  }
  
  @Override
  public String toString()
  {
    String out = "";
    
    // Sorted set to get them in alphabetical order
    SortedSet<Bonus> circSet = bonusBlock.getApplicableCircumstantialBonus(); 
    if(!circSet.isEmpty())
    {
      out += " [";
      
      for(Bonus bonus : circSet)
      {
        out += bonus.toString();
        if(bonus != circSet.last())
           out += ", ";
      }
      
      out += "]";
    }

    return getScore() + out;
  }
}
