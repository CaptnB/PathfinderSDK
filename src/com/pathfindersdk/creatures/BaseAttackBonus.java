package com.pathfindersdk.creatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final public class BaseAttackBonus
{
  private List<Integer> babs = new ArrayList<Integer>();
  
  public BaseAttackBonus()
  {
    // Initialize with at least a non-null value
    babs.add(0);
  }
  
  public void increment(int increment)
  {
    if(increment != 0)
    {
      // Integer are immutable so just create another list
      List<Integer> newBabs = new ArrayList<Integer>();
      for(Integer bab : babs)
      {
        if(bab + increment > 0)   // For negative increments
          newBabs.add(bab + increment);
      }
      
      // Just make sure at least one value remains
      if(newBabs.isEmpty())
        babs.add(0);
      
      // Spawn additional bab for each multiple of 5 (6 -> 6/1, 11 -> 11/6/1). No more then 4 BAB
      while(newBabs.get(newBabs.size() - 1) >= 6 && newBabs.size() < 4)
        newBabs.add(newBabs.get(newBabs.size() - 1) - 5);
      
      // Discard the old list by assigning the new one
      babs = newBabs;
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
