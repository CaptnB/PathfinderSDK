package com.pathfindersdk.stats;


public class AbilityGroup extends StatGroup<AbilityType>
{
  public AbilityGroup()
  {
    super(StatGroupType.ABILITY_SCORES);
  }

  @Override
  public Stat<AbilityType> getStat(AbilityType key)
  {
    if(stats != null)
      return stats.get(key);
    else
      return null;
  }

  @Override
  public void addStat(Stat<AbilityType> stat)
  {
    /*if(stats == null)
      stats = new Hashtable<AbilityType.toString(), AbilityType>();*/
  }

  @Override
  public void removeStat(Stat<AbilityType> stat)
  {
    // TODO Auto-generated method stub
    
  }

}
