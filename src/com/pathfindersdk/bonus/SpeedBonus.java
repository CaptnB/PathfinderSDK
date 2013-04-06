package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SpeedType;

final public class SpeedBonus extends Bonus
{
  final private SpeedType speed;

  public SpeedBonus(int value, BonusType type, SpeedType speed)
  {
    this(value, type, speed, null);
  }

  public SpeedBonus(int value, BonusType type, SpeedType speed, String circumstance)
  {
    super(value, type, circumstance);
    
    if(speed == null)
      throw new IllegalArgumentException("speed can't be null");
    this.speed = speed;
  }

  @Override
  public void applyTo(Creature target)
  {
    if(target != null)
    {
      if(target.getSpeed(speed) != null)
      {
        target.getSpeed(speed).addBonus(this);
      }
    }
  }

  @Override
  public void removeFrom(Creature target)
  {
    if(target != null)
    {
      if(target.getSpeed(speed) != null)
      {
        target.getSpeed(speed).removeBonus(this);
      }
    }
  }

}
