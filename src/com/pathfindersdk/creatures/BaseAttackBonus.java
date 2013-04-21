package com.pathfindersdk.creatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pathfindersdk.utils.ArgChecker;

final public class BaseAttackBonus
{
  private List<Integer> babs = new ArrayList<Integer>();
  
  public BaseAttackBonus()
  {
    this(0);
  }
  
  public BaseAttackBonus(int bab)
  {
    normalize(bab);
  }
  
  private void normalize(int bab)
  {
    ArgChecker.checkIsPositive(bab);

    List<Integer> newBabs = new ArrayList<Integer>();
    newBabs.add(bab);   // At least one BAB exists at all time
    
    // Spawn additional bab for each multiple of 5 (11 -> +11/+6/+1). No more then 4 BAB
    while(newBabs.get(newBabs.size() - 1) >= 6 && newBabs.size() < 4)
      newBabs.add(newBabs.get(newBabs.size() - 1) - 5);
    
    babs = newBabs;
  }
  
  public void increment(int increment)
  {
    if(increment != 0)
    {
      if(babs.get(0) + increment >= 0)
        normalize(babs.get(0) + increment);
      else
        normalize(0);
    }
  }
  
  public List<Integer> getBabs()
  {
    return Collections.unmodifiableList(babs);
  }
  
  @Override
  public String toString()
  {
    String out = "+" + babs.get(0);
    
    for(int i = 1; i < babs.size(); i++)
      out += "/+" + babs.get(i);
    
    return out;
  }

}
