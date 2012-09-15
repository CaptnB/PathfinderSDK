package com.pathfindersdk.creatures.characters;

import java.util.ArrayList;

import com.pathfindersdk.classes.Class;
import com.pathfindersdk.skills.Skill;
import com.pathfindersdk.skills.SkillType;

public class Character
{
  private ArrayList<Skill> skills = new ArrayList<Skill>();
  private ArrayList<Class> classes = new ArrayList<Class>();
  
  public Integer getLevel()
  {
    return classes.size();
  }
  
  public void addClass(Class newClass)
  {
    newClass.add(this);
  }
  
  public void removeLastClass()
  {
    classes.get(classes.size() - 1).remove(this);
  }
  
  public Skill getSkill(SkillType skillType)
  {
    for(Skill skill : skills)
    {
      if(skill.getType() == skillType)
        return skill;
    }
    
    return null;
  }
}
