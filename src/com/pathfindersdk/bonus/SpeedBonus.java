package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SpeedType;

public class SpeedBonus extends Bonus
{
  protected SpeedType speed;

  public SpeedBonus(int value, BonusType type, SpeedType speed)
  {
    super(value, type);
    this.speed = speed;
  }

  public SpeedBonus(int value, BonusType type, SpeedType speed, String circumstance)
  {
    super(value, type, circumstance);
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
