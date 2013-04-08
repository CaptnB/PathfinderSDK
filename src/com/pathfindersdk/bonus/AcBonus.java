package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

final public class AcBonus extends Bonus
{
  
  public AcBonus(int value, BonusType type)
  {
    this(value, type, null);
  }

  public AcBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null");
    
    applyToStat(target.getArmorClass());
    
    // Deflection, Dodge, Insight, Luck, Morale, Profane and Sacred bonuses to AC also apply to CMD
    if(getType().equals(BonusType.DEFLECTION) ||
       getType().equals(BonusType.DODGE)      ||
       getType().equals(BonusType.INSIGHT)    ||
       getType().equals(BonusType.LUCK)       ||
       getType().equals(BonusType.MORALE)     ||
       getType().equals(BonusType.PROFANE)    ||
       getType().equals(BonusType.SACRED))
    {
      applyToStat(target.getCmd());
    }
  }

  @Override
  public void removeFrom(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null");
    
    removeFromStat(target.getArmorClass());
    removeFromStat(target.getCmd());
  }

}
