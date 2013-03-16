package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BookSectionType;


/**
 * This class represents a general skill description (see SkillStat for character specific skills with ranks and class skill).
 */
public class SkillItem extends BookItem
{
  protected Boolean untrained;
  protected Boolean armorCheckPenalty;

  public SkillItem(String name, AbilityType keyAbility, Boolean untrained, Boolean armorCheckPenalty)
  {
    super(name);
    this.untrained = untrained;
    this.armorCheckPenalty = armorCheckPenalty;
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
  protected void index()
  {
    Index.getInstance().getIndex(BookSectionType.SKILLS).addItem(this);
  }

}
