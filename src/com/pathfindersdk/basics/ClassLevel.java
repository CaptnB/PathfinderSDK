package com.pathfindersdk.basics;

import java.util.ArrayList;

import com.pathfindersdk.bonus.Bonus;

public class ClassLevel
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
}
