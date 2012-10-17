package com.pathfindersdk.stats;

import com.pathfindersdk.basics.SaveType;

public class SaveStat extends Stat
{
  protected SaveType type;
  protected AbilityStat ability;
  
  public SaveStat(SaveType type, AbilityStat ability)
  {
    super(0);
    this.type = type;
    this.ability = ability;
  }

}
