package com.pathfindersdk.core;

import java.util.TreeMap;

public class Book
{
  private String name;
  private TreeMap<String, Skill> skills = new TreeMap<String, Skill>();
  
  public Book(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public TreeMap<String, Skill> getSkills()
  {
    return skills;
  }
  
  public void addSkill(Skill skill)
  {
    skills.put(skill.getType().toString(), skill);
  }
}
