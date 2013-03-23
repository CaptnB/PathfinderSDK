package com.pathfindersdk.features;

import java.util.ArrayList;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Creature;

public class ClassLevel implements Applicable<Creature>
{
  protected Integer baseAttackBonus;
  protected Integer fortitude;
  protected Integer reflex;
  protected Integer will;
  protected ArrayList<Bonus> specials;
  
  public ClassLevel(int baseAttackBonus, int fortitude, int reflex, int will)
  {
    this.baseAttackBonus = baseAttackBonus;
    this.fortitude = fortitude;
    this.reflex = reflex;
    this.will = will;
  }
  
  public Integer getBaseAttackBonus()
  {
    return baseAttackBonus;
  }
  
  public Integer getFortitude()
  {
    return fortitude;
  }
  
  public Integer getReflex()
  {
    return reflex;
  }
  
  public Integer getWill()
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
