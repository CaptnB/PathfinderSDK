package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.utils.ArgChecker;

public class NullBonus extends Bonus
{

  public NullBonus()
  {
    super(0, BonusTypeRegister.getInstance().get("Untyped"), null);
  }

  @Override
  public void applyTo(Creature target)
  {
    ArgChecker.checkNotNull(target);
  }

  @Override
  public void removeFrom(Creature target)
  {
    ArgChecker.checkNotNull(target);
  }

  @Override
  public Bonus newBonus(int offset)
  {
    return new NullBonus();
  }

}
