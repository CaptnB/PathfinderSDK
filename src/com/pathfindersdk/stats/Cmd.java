package com.pathfindersdk.stats;

import java.util.HashSet;
import java.util.Set;

import com.pathfindersdk.creatures.BaseAttackBonus;
import com.pathfindersdk.utils.ArgChecker;

final public class Cmd extends Stat
{
  final private AbilityScore strenght;
  final private AbilityScore dexterity;
  final private Set<AbilityScore> otherAbilities = new HashSet<AbilityScore>();   // A Monk can add his Wisdom
  final private BaseAttackBonus bab;
  final private Size size;

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
    ArgChecker.checkNotNull(ability);
    
    otherAbilities.add(ability);
  }
 
  public void removeAbility(AbilityScore ability)
  {
    otherAbilities.remove(ability);
  }
  
  public int getFlatFootedScore()
  {
    return getScore() - dexterity.getModifier();
  }
 
  @Override
  public int getScore()
  {
    int otherModifiers = 0;
    for(AbilityScore ability : otherAbilities)
      otherModifiers += ability.getModifier();
    
    return super.getScore() + bab.getBabs().get(0) + strenght.getModifier() + dexterity.getModifier() + otherModifiers - size.getModifier();
  }
}
