package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.stats.Initiative;

public class InitiativeBonus extends Bonus
{
  public InitiativeBonus(int value, BonusType type)
  {
    super(value, type);
  }

  public InitiativeBonus(int value, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
  }

  @Override
  public void applyTo(Creature creature)
  {
    Initiative init = creature.getInitiative();
    
    if(init != null)
      init.addBonus(this);
    else
      System.out.println("Could not find Initiative from Creature (name : " + creature.getName() + ")");
  }

  @Override
  public void removeFrom(Creature creature)
  {
    Initiative init = creature.getInitiative();
    
    if(init != null)
      init.removeBonus(this);
    else
      System.out.println("Could not find Initiative from Creature (name : " + creature.getName() + ")");
  }

}
