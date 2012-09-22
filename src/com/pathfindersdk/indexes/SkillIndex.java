package com.pathfindersdk.indexes;

import java.util.Hashtable;
import java.util.Map;

import com.pathfindersdk.creatures.Skill;

public class SkillIndex
{
  private static SkillIndex instance = new SkillIndex();
  
  private static Map<String, Skill> skills = new Hashtable<String, Skill>();
  
  private SkillIndex() {}
  
  public static Skill getSkill(String name)
  {
    return skills.get(name);
  }
  
  public static Map<String, Skill> getSkills()
  {
    return skills;
  }
}
