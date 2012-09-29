package com.pathfindersdk.indexes;

import java.util.Hashtable;
import java.util.Map;

import com.pathfindersdk.books.items.SkillItem;

/**
 * This class gathers all skills from all books into one accessible singleton.
 */
public final class SkillIndex
{
  protected static SkillIndex instance = new SkillIndex();
  protected static Map<String, SkillItem> skills = new Hashtable<String, SkillItem>();
  
  public static SkillIndex getInstance()
  {
    return instance;
  }  
  
  private SkillIndex() {}
  
  public static SkillItem getSkill(String name)
  {
    return skills.get(name);
  }
  
  public static Map<String, SkillItem> getSkills()
  {
    return skills;
  }
}
