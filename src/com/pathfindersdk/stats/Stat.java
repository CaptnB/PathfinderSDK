package com.pathfindersdk.stats;

import java.util.ArrayList;
import java.util.List;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.BonusBlock;

/**
 * This class is a generic character stat (ex: Initiative, AC, etc.). 
 */
public class Stat
{
  private int baseScore;
  final private transient BonusBlock bonusBlock = new BonusBlock();
  
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

  protected BonusBlock getBonusBlock()
  {
    return bonusBlock;
  }
  
  public int getScore()
  {
    int total = getBaseScore();

    List<Bonus> bonusSet = bonusBlock.getApplicableBaseBonus();
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
    String circumstantial = "";
    List<Bonus> circList = new ArrayList<Bonus>(bonusBlock.getApplicableCircumstantialBonus()); 
    if(!circList.isEmpty())
    {
      circumstantial += " [" + circList.get(0);
      
      for(int i = 1; i < circList.size(); i++)
        circumstantial += ", " + circList.get(i);
      
      circumstantial += "]";
    }

    return getScore() + circumstantial;
  }
}
