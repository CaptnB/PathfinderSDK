package com.pathfindersdk.stats;

import java.util.Hashtable;

public class StatGroup implements StatComponent
{
  protected Hashtable<String, StatComponent> stats;
  
  public StatGroup()
  {
  }
  
  public void addComponent(String name, StatComponent stat)
  {
    if(stat != null)
    {
      if(stats == null)
        stats = new Hashtable<String, StatComponent>();
      
      stats.put(name, stat);
    }
  }

  public void removeComponent(String name)
  {
    if(stats != null)
    {
      stats.remove(name);
    }
  }

}
