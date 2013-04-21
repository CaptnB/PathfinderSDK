package com.pathfindersdk.equipment;

import com.pathfindersdk.books.items.EquipmentItem;
import com.pathfindersdk.coins.Coins;
import com.pathfindersdk.utils.ArgChecker;


public class Equipment
{
  private String name;
  private Coins cost = new Coins();
  
  public Equipment(EquipmentItem item)
  {
    ArgChecker.checkNotNull(item);
    
    setName(item.getName());
    addCost(item.getCost());
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    ArgChecker.checkNotNull(name);
    ArgChecker.checkNotEmpty(name);
    
    this.name = name;
  }
  
  public Coins getCost()
  {
    return cost;
  }
  
  public void addCost(Coins cost)
  {
    ArgChecker.checkNotNull(cost);
    
    cost.add(cost);
  }
  
  @Override
  public String toString()
  {
    return name + "(" + cost.toString() + ")";
  }

}
