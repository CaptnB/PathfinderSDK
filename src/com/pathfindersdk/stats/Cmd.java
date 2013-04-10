package com.pathfindersdk.stats;

import java.util.HashSet;
import java.util.Set;

import com.pathfindersdk.creatures.BaseAttackBonus;
import com.pathfindersdk.utils.ArgChecker;

final public class Cmd extends Stat
{
  private Set<AbilityScore> abilities = new HashSet<AbilityScore>();   // A set because Monk can add Wisdom
  private BaseAttackBonus bab;
  private Size size;

  public Cmd(AbilityScore strenght, AbilityScore dexterity, BaseAttackBonus bab, Size size)
  {
    super(10);
    
    ArgChecker.checkNotNull(strenght);
    ArgChecker.checkNotNull(dexterity);
    ArgChecker.checkNotNull(bab);
    ArgChecker.checkNotNull(size);

    abilities.add(strenght);
    abilities.add(dexterity);
    this.bab = bab;
    this.size = size;
  }

  public void addAbility(AbilityScore ability)
  {
    abilities.add(ability);
  }
 
  public void removeAbility(AbilityScore ability)
  {
    abilities.remove(ability);
  }
 
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
