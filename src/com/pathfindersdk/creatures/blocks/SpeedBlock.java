package com.pathfindersdk.creatures.blocks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.utils.ArgChecker;

final public class SpeedBlock
{
  // This private class can hold different speed Stat (for the same SpeedType).
  // Ex: A sorcerer with the Elemental (Earth) bloodline has 30 ft burrow speed. Then the Beast Shape IV spell is cast on the sorcerer
  // which grants 60 ft burrow speed. We need to remember both so the latest does not superseed the previous. The best speed is returned
  // 
  private class SpeedGroup
  {
    private Set<Stat> speeds = new HashSet<Stat>();   // Can't sort Stats, they can change value anytime
    
    public void addSpeed(Stat speed)
    {
      speeds.add(speed);
    }
    
    public void removeSpeed(Stat speed)
    {
      speeds.remove(speed);
    }
    
    public Stat getSpeed()
    {
      Stat biggest = null;
      for(Stat speed : speeds)
      {
        if(biggest == null || biggest.getScore() < speed.getScore())
          biggest = speed;
      }
      return biggest;
    }
  }
  
  final private Map<SpeedType, SpeedGroup> speeds = new HashMap<SpeedType, SpeedGroup>();
  
  public SpeedBlock()
  {
    for(SpeedType type : SpeedType.values())
    {
      speeds.put(type, new SpeedGroup());
    }
  }

  public void addSpeed(SpeedType type, Stat speed)
  {
    ArgChecker.checkNotNull(type);
    ArgChecker.checkNotNull(speed);
    
    speeds.get(type).addSpeed(speed);
  }
  
  public void removeSpeed(SpeedType type, Stat speed)
  {
    ArgChecker.checkNotNull(type);
    ArgChecker.checkNotNull(speed);
    
    speeds.get(type).removeSpeed(speed);
  }

  public Stat getSpeed(SpeedType type)
  {
    return speeds.get(type).getSpeed();
  }
}
