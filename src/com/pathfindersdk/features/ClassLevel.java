package com.pathfindersdk.features;

import java.util.ArrayList;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Creature;

public class ClassLevel implements Applicable
{
  protected int baseAttackBonus;
  protected int fortitude;
  protected int reflex;
  protected int will;
  protected ArrayList<Bonus> specials;
  
  public ClassLevel(int baseAttackBonus, int fortitude, int reflex, int will)
  {
    this.baseAttackBonus = baseAttackBonus;
    this.fortitude = fortitude;
    this.reflex = reflex;
    this.will = will;
  }
  
  public int getBaseAttackBonus()
  {
    return baseAttackBonus;
  }
  
  public int getFortitude()
  {
    return fortitude;
  }
  
  public int getReflex()
  {
    return reflex;
  }
  
  public int getWill()
  {
    return will;
  }

  @Override
  public void applyTo(Creature target)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeFrom(Creature target)
  {
    // TODO Auto-generated method stub
    
  }
}
