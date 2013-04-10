package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.utils.ArgChecker;

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
    
    ArgChecker.checkNotNull(speed);

    this.speed = speed;
  }

  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);

    applyToStat(target.getSpeed(speed));
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    removeFromStat(target.getSpeed(speed));
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new SpeedBonus(getValue() - offset, getType(), speed, getCircumstance()); 
  }

}
