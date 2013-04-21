package com.pathfindersdk.stats;

import com.pathfindersdk.creatures.BaseAttackBonus;
import com.pathfindersdk.creatures.HitPoints;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.utils.ArgChecker;

final public class Cmb extends Stat implements Rollable
{
  private AbilityScore mainAbility;     // Usually strenght, Agile Maneuvers feat changes this for dexterity
  final private AbilityScore dexterity; // For tiny creatures or smaller, use dexterity
  final private BaseAttackBonus bab;
  final private Size size;
  private HitPoints hitDice;              // Defensive Combat Training feat uses total hit dice instead of BAB, otherwise useless

  public Cmb(AbilityScore strenght, AbilityScore dexterity, BaseAttackBonus bab, Size size)
  {
    super(0);
    
    setMainAbility(strenght);
    
    ArgChecker.checkNotNull(dexterity);
    ArgChecker.checkNotNull(bab);
    ArgChecker.checkNotNull(size);

    this.dexterity = dexterity;
    this.bab = bab;
    this.size = size;
    setHitDice(null);
  }
  
  public void setMainAbility(AbilityScore mainAbility)
  {
    ArgChecker.checkNotNull(mainAbility);
    
    this.mainAbility = mainAbility;
  }
  
  public void setHitDice(HitPoints hitDice)
  {
    // Can be null
    this.hitDice = hitDice;
  }
  
  @Override
  public int getScore()
  {
    int score = super.getScore();
    
    // Use number of hit dice instead of BAB?
    if(hitDice != null)
      score += hitDice.size();
    else
      score += bab.getBabs().get(0);
    
    // If tiny or smaller, use dex
    if(size.getSize().ordinal() <= SizeType.TINY.ordinal())
      score += dexterity.getModifier();
    else
      score += mainAbility.getModifier();
    
    score -= size.getModifier();
    
    return score; 
  }

  @Override
  public int roll()
  {
    return (new Dice(1, 20)).roll() + getScore();
  }

}
