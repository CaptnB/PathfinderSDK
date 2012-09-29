package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.stats.AbilityType;


/**
 * This class represents a general skill description (see SkillStat for character specific skills with ranks and class skill).
 */
public class SkillItem extends BookItem
{
  protected AbilityType keyAbility;
  protected Boolean untrained;
  protected Boolean armorCheckPenalty;

  public SkillItem(String name, AbilityType keyAbility, Boolean untrained, Boolean armorCheckPenalty)
  {
    super(name);
    this.keyAbility = keyAbility;
    this.untrained = untrained;
    this.armorCheckPenalty = armorCheckPenalty;
  }
  
  public AbilityType getKeyAbility()
  {
    return keyAbility;
  }
  
  public Boolean isUnTrained()
  {
    return untrained;
  }
  
  public Boolean isArmorCheckPenalty()
  {
    return armorCheckPenalty;
  }

  @Override
  public void applyTo(Creature creature)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeFrom(Creature creature)
  {
    // TODO Auto-generated method stub
    
  }

}
