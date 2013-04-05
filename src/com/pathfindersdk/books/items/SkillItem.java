package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.AbilityType;


/**
 * This class represents a general skill description (see SkillStat for character specific skills with ranks and class skill).
 */
public class SkillItem extends BookItem
{
  protected Boolean untrained;
  protected Boolean armorCheckPenalty;
  protected AbilityType keyAbility;

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
  public SkillItem deepCopy()
  {
    // TODO Auto-generated method stub
    return null;
  }

}
