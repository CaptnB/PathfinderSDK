package com.pathfindersdk.books.items;

import java.util.Collections;
import java.util.List;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.features.ClassLevel;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.stats.Dice;


/**
 * Immutable class to wrap a playable class book entry.
 */
final public class ClassItem extends BookItem
{
  final private List<Prerequisite<Creature>> prerequisites;
  final private Dice hitDice;
  final private List<String> classSkills;
  final private int skillRanks;
  final private List<ClassLevel> levels;
  
  public ClassItem(String name, List<Prerequisite<Creature>> prerequisites, Dice hitDice, List<String> classSkills, int skillRanks, List<ClassLevel> levels)
  {
    super(name);
    
    if(prerequisites == null)
      throw new IllegalArgumentException("prerequisites can't bu null");
    
    if(hitDice == null)
      throw new IllegalArgumentException("hitDice can't bu null");
    
    if(classSkills == null)
      throw new IllegalArgumentException("classSkills can't bu null");
    
    if(levels == null)
      throw new IllegalArgumentException("levels can't bu null");
    
    this.prerequisites = prerequisites;
    this.hitDice = hitDice;
    this.classSkills = classSkills;
    this.skillRanks = skillRanks;
    this.levels = levels;
  }

  public List<Prerequisite<Creature>> getPrerequisites()
  {
    return Collections.unmodifiableList(prerequisites);
  }
  
  public Dice getHitDice()
  {
    return hitDice;
  }
  
  public List<String> getClassSkills()
  {
    return Collections.unmodifiableList(classSkills);
  }
  
  public int getSkillRanks()
  {
    return skillRanks;
  }
  
  public List<ClassLevel> getLevels()
  {
    return Collections.unmodifiableList(levels);
  }

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.CLASSES).addItemWithoutIndexing(this);
  }

  
}
