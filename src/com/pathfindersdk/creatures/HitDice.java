package com.pathfindersdk.creatures;

import java.util.ArrayList;
import java.util.List;

import com.pathfindersdk.stats.Dice;

final public class HitDice
{
  private transient List<Dice> hitDie = new ArrayList<Dice>();
  
  public void addDice(Dice dice)
  {
    hitDie.add(dice);
  }
  
  public void removeLastDice()
  {
    hitDie.remove(hitDie.size() - 1);
  }
  
  public int size()
  {
    return hitDie.size();
  }
}
