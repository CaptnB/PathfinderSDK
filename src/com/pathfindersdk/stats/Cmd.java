package com.pathfindersdk.stats;

import java.util.HashSet;
import java.util.Set;

import com.pathfindersdk.creatures.BaseAttackBonus;
import com.pathfindersdk.utils.ArgChecker;

final public class Cmd extends Stat
{
  private AbilityScore strenght;
  private AbilityScore dexterity;
  private Set<AbilityScore> otherAbilities = new HashSet<AbilityScore>();   // A Monk can add his Wisdom
  private BaseAttackBonus bab;
  private Size size;

  public Cmd(AbilityScore strenght, AbilityScore dexterity, BaseAttackBonus bab, Size size)
  {
    super(10);
    
    ArgChecker.checkNotNull(strenght);
    ArgChecker.checkNotNull(dexterity);
    ArgChecker.checkNotNull(bab);
    ArgChecker.checkNotNull(size);

    this.strenght = strenght;
    this.dexterity = dexterity;
    this.bab = bab;
    this.size = size;
  }

  public void addAbility(AbilityScore ability)
  {
    otherAbilities.add(ability);
  }
 
  public void removeAbility(AbilityScore ability)
  {
    otherAbilities.remove(ability);
  }
  
  public int getFlatFooted()
  {
    return getScore() - dexterity.getModifier();
  }
 
  @Override
  public int getScore()
  {
    int score = super.getScore();
    
    score += bab.getBabs().get(0);
    score += strenght.getModifier();
    score += dexterity.getModifier();
    
    for(AbilityScore ability : otherAbilities)
      score += ability.getModifier();
    
    score -= size.getModifier();
    
    return score;
  }
}
