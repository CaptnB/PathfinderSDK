package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SaveType;
import com.pathfindersdk.stats.SavingThrow;

public class SaveBonus extends Bonus
{
  protected SaveType save;

  public SaveBonus(int value, SaveType save, BonusType type)
  {
    super(value, type);
    this.save = save;
  }

  public SaveBonus(int value, SaveType save, BonusType type, String circumstance)
  {
    super(value, type, circumstance);
    this.save = save;
  }
  
  @Override
  public void applyTo(Creature creature)
  {
    SavingThrow savingThrow = creature.getSavingThrow(save);
    
    if(savingThrow != null)
      savingThrow.addBonus(this);
    else
      System.out.println("Could not find SavingThrow (type : " + save.toString() + ") from Creature (name : " + creature.getName() + ")");
  }
  
  @Override
  public void removeFrom(Creature creature)
  {
    SavingThrow savingThrow = creature.getSavingThrow(save);
    
    if(savingThrow != null)
      savingThrow.removeBonus(this);
    else
      System.out.println("Could not find SavingThrow (type : " + save.toString() + ") from Creature (name : " + creature.getName() + ")");
  }
}
