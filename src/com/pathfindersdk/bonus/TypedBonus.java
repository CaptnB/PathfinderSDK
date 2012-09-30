package com.pathfindersdk.bonus;

import com.pathfindersdk.creatures.Creature;


/**
 * This generic class applies a bonus to a Stat object.
 * Bonus types don't stack except for UNTYPED, the biggest bonus is always considered, circumstantial bonus are not added to total.
 */
public class TypedBonus implements Bonus, Comparable<TypedBonus>
{
  protected Integer value;
  protected BonusType type;
  protected Boolean stackable;
  protected String circumstance;
  protected BonusStrategy strategy;
  
  public TypedBonus(int value, BonusType type, BonusStrategy strategy)
  {
    this.value = value;
    this.type = type;
    this.strategy = strategy;
  }
  
  public TypedBonus(int value, BonusType type, BonusStrategy strategy, String circumstance)
  {
    this.value = value;
    this.type = type;
    this.strategy = strategy;
    this.circumstance = circumstance;
  }
  
  public Integer getValue()
  {
    return value;
  }
  
  public BonusType getType()
  {
    return type;
  }
  
  public String getCircumstance()
  {
    return circumstance;
  }
  
  @Override
  public void applyTo(Creature creature)
  {
    strategy.applyTo(creature);
  }

  @Override
  public void removeFrom(Creature creature)
  {
    strategy.removeFrom(creature);
  }

  @Override
  public int compareTo(TypedBonus bonus)
  {
    // Sort in descending order (highest bonus first so when bonuses don't stack, the first one is the one to consider)
    if(getValue() > bonus.getValue())
      return -1;
    else
      return 1;
  }
  
}
