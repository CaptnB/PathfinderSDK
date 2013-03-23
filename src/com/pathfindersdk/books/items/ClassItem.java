package com.pathfindersdk.books.items;

import java.util.ArrayList;
import java.util.List;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.features.ClassLevel;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.stats.Dice;


/**
 * This class contains a class progression level by level.
 */
public class ClassItem extends BookItem
{
  protected List<Prerequisite> prerequisites;
  protected Dice hitDice;
  protected List<String> classSkills;
  protected Integer skillRanks;
  protected List<ClassLevel> levels;
  
  public ClassItem(String name, Dice hitDice, int skillRanks)
  {
    super(name);
    this.hitDice = hitDice;
    this.skillRanks = skillRanks;
  }
  
  public void addPrerequisite(Prerequisite prereq)
  {
    if(prereq != null)
    {
      if(prerequisites == null)
        prerequisites = new ArrayList<Prerequisite>();
      
      prerequisites.add(prereq);
    }
  }
  
  public void removePrerequisite(Prerequisite prereq)
  {
    if(prerequisites != null)
    {
      prerequisites.remove(prereq);
      
      if(prerequisites.isEmpty())
        prerequisites = null;
    }
  }
  
  public void addClassSkill(String skillName)
  {
    if(skillName != null)
    {
      if(classSkills == null)
        classSkills = new ArrayList<String>();
      
      classSkills.add(skillName);
    }
  }
  
  public void removeClassSkill(String skillName)
  {
    if(classSkills != null)
    {
      classSkills.remove(skillName);
      
      if(classSkills.isEmpty())
        classSkills = null;
    }
  }
  
  public void addClassLevel(ClassLevel level)
  {
    if(level != null)
    {
      if(levels == null)
        levels = new ArrayList<ClassLevel>();
      
      levels.add(level);
    }
  }
  
  public void removeClassLevel(ClassLevel level)
  {
    if(levels != null)
    {
      levels.remove(level);
      
      if(levels.isEmpty())
        levels = null;
    }
  }

  @Override
  protected void index()
  {
    Index.getInstance().getIndex(BookSectionType.CLASSES).addItem(this);
  }
}
