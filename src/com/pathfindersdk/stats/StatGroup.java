package com.pathfindersdk.stats;

import java.util.Hashtable;

public abstract class StatGroup<K>
{
  protected StatGroupType groupType;
  protected Hashtable<K, Stat<K>> stats;
  
  public StatGroup(StatGroupType groupType)
  {
    this.groupType = groupType;
  }
  
  public StatGroupType getGroupType()
  {
    return groupType;
  }
  
  public abstract Stat<K> getStat(K key);
  
  public abstract void addStat(Stat<K> stat);
  
  public abstract void removeStat(Stat<K> stat);

}
