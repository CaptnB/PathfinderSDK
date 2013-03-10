package com.pathfindersdk.equipment;

import java.util.ArrayList;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.BookItem;

public class Equipment extends BookItem
{
  protected Integer cost;
  protected Integer weight;
  protected ArrayList<Bonus> bonuses;

  public Equipment(String name, int cost, int weight)
  {
    super(name);
    this.cost = cost;
    this.weight = weight;
  }
  
  public Integer getCost()
  {
    return cost;
  }
  
  public void setCost(int cost)
  {
    this.cost = cost;
  }
  
  public Integer getWeight()
  {
    return weight;
  }
  
  public void setWeight(int weight)
  {
    this.weight = weight;
  }
  
  public void addBonus(Bonus bonus)
  {
    if(bonus != null)
    {
      if(bonuses == null)
        bonuses = new ArrayList<Bonus>();
      
      bonuses.add(bonus);
    }
  }
  
}
