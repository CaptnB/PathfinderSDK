package com.pathfindersdk.books.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;


/**
 * Immutable class that wraps a skill description book entry.
 */
final public class SkillItem extends BookItem
{
  final private boolean untrained;
  final private boolean armorCheckPenalty;
  final private AbilityType keyAbility;
  final private List<String> extensions; // Only used for skills like Craft, Perform and Profession that require a specialization (Craft (alchemy))

  public SkillItem(String name, AbilityType keyAbility, boolean untrained, boolean armorCheckPenalty)
  {
    // Pass an empty list of extensions
    this(name, keyAbility, untrained, armorCheckPenalty, new ArrayList<String>());
  }
  
  public SkillItem(String name, AbilityType keyAbility, boolean untrained, boolean armorCheckPenalty, List<String> extensions)
  {
    super(name, BookSectionType.SKILLS);
    
    ArgChecker.checkNotNull(keyAbility);
    
    this.keyAbility = keyAbility;
    this.untrained = untrained;
    this.armorCheckPenalty = armorCheckPenalty;
    this.extensions = extensions;
  }
  
  public AbilityType getKeyAbility()
  {
    return keyAbility;
  }
  
  public boolean isUnTrained()
  {
    return untrained;
  }
  
  public boolean isArmorCheckPenalty()
  {
    return armorCheckPenalty;
  }
  
  public List<String> getExtensions()
  {
    return Collections.unmodifiableList(extensions);
  }

  public boolean isExtensible()
  {
    return extensions.size() > 0;
  }
  
}
