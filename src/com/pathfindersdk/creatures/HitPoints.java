package com.pathfindersdk.creatures;

import java.util.ArrayList;
import java.util.List;

import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.Dice;
import com.pathfindersdk.utils.ArgChecker;

final public class HitPoints
{
  private final transient AbilityScore constitution;
  private transient int flatBonus = 0;
  private transient int perLevelBonus = 0;
  private transient List<Dice> hitDie = new ArrayList<Dice>();
  // TODO : Think about how to implement Toughness feat (the +1 per level after 3rd hit dice part)
  
  public HitPoints(AbilityScore constitution)
  {
    ArgChecker.checkNotNull(constitution);
    
    this.constitution = constitution;
  }
  
  public void addDice(Dice dice)
  {
    ArgChecker.checkNotNull(dice);
    
    hitDie.add(dice);
  }
  
  public void removeDice(Dice dice)
  {
    hitDie.remove(dice);
  }
  
  public void addFlatBonus(int flatBonus)
  {
    ArgChecker.checkIsPositive(flatBonus);
    
    this.flatBonus += flatBonus;
  }
  
  public void removeFlatBonus(int flatBonus)
  {
    ArgChecker.checkIsPositive(flatBonus);
    
    this.flatBonus -= flatBonus;
  }
  
  public void addPerLevelBonus(int perLevelBonus)
  {
    ArgChecker.checkIsPositive(perLevelBonus);
    
    this.perLevelBonus += perLevelBonus;
  }
  
  public void removePerLevelBonusBonus(int perLevelBonus)
  {
    ArgChecker.checkIsPositive(perLevelBonus);
    
    this.perLevelBonus -= perLevelBonus;
  }
  
  public int size()
  {
    return hitDie.size();
  }

  public int getHitPoints()
  {
    int hitPoints = flatBonus;
    
    for(Dice dice : hitDie)
      hitPoints += dice.roll() + constitution.getModifier() + perLevelBonus;
    
    return hitPoints;
  }
}
