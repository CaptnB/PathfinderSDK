package com.pathfindersdk.stats;

import java.util.ArrayList;
import java.util.List;

import com.pathfindersdk.creatures.BaseAttackBonus;

final public class Cmd extends Stat
{
  private List<AbilityScore> abilities = new ArrayList<AbilityScore>();   // A list because Monk can add Wisdon too
  private BaseAttackBonus bab;
  private Size size;

  public Cmd(AbilityScore strenght, AbilityScore dexterity, BaseAttackBonus bab, Size size)
  {
    super(10);
    
    if(strenght == null)
      throw new IllegalArgumentException("strenght can't be null!");
    
    if(dexterity == null)
      throw new IllegalArgumentException("dexterity can't be null!");
    
    if(bab == null)
      throw new IllegalArgumentException("bab can't be null!");
    
    if(size == null)
      throw new IllegalArgumentException("size can't be null!");

    abilities.add(strenght);
    abilities.add(dexterity);
    this.bab = bab;
    this.size = size;
  }

  // TODO : add/remove ability
  
  @Override
  public int getScore()
  {
    int score = super.getScore();
    
    score += bab.getBabs().get(0);
    
    for(AbilityScore ability : abilities)
      score += ability.getModifier();
    
    score -= size.getModifier();
    
    return score;
  }
}
