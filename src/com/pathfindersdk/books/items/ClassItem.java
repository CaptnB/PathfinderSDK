package com.pathfindersdk.books.items;

import java.util.Collections;
import java.util.List;

import com.pathfindersdk.applicables.ClassLevel;
import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.stats.Dice;
import com.pathfindersdk.utils.ArgChecker;


/**
 * Immutable class to wrap a playable class book entry.
 */
final public class ClassItem extends BookItem
{
  final private List<Prerequisite> prerequisites;
  final private Dice hitDice;
  final private List<String> classSkills;
  final private int skillRanks;
  final private List<ClassLevel> levels;
  
  public ClassItem(String name, List<Prerequisite> prerequisites, Dice hitDice, List<String> classSkills, int skillRanks, List<ClassLevel> levels)
  {
    super(name, BookSectionType.CLASSES);
    
    ArgChecker.checkNotNull(prerequisites);
    ArgChecker.checkNotNull(hitDice);
    ArgChecker.checkNotNull(classSkills);
    ArgChecker.checkNotNull(levels);
    
    this.prerequisites = prerequisites;
    this.hitDice = hitDice;
    this.classSkills = classSkills;
    this.skillRanks = skillRanks;
    this.levels = levels;
  }

  public List<Prerequisite> getPrerequisites()
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
  
}
