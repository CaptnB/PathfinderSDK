package com.pathfindersdk.creatures;

import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.BonusType;

/**
 * The Class AbilityBonus.
 */
public class AbilityBonus extends Bonus
{
  
  /** The ability. */
  private Ability ability;
  
  /**
   * Instantiates a new ability bonus.
   *
   * @param bonus the bonus
   * @param type the type
   * @param ability the ability
   * @param circumstantial the circumstantial
   */
  public AbilityBonus(Integer bonus, BonusType type, Ability ability)
  {
    super(bonus, type);
    this.ability = ability;
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.general.Bonus#apply(com.pathfindersdk.creatures.Creature)
   */
  @Override
  public void apply(Creature creature)
  {
    AbilityScore abilityScore = creature.getAbilityScore(ability);
    if(abilityScore != null)
      abilityScore.getBonuses().add(this);
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.general.Bonus#remove(com.pathfindersdk.creatures.Creature)
   */
  @Override
  public void remove(Creature creature)
  {
    // TODO Auto-generated method stub
    
  }

}
