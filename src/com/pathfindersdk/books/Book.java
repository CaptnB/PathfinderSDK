package com.pathfindersdk.books;

import java.util.TreeSet;

import com.pathfindersdk.creatures.Feat;
import com.pathfindersdk.creatures.Skill;
import com.pathfindersdk.creatures.characters.Race;
import com.pathfindersdk.indexes.FeatIndex;
import com.pathfindersdk.indexes.RaceIndex;
import com.pathfindersdk.indexes.SkillIndex;

/**
 * The Class Book. It basically contains everything contained in a Pathfinder book. 
 */
public class Book
{
  
  /** Book name. */
  private String name;
  
  /** Included races in book. */
  private TreeSet<Race> races;
  
  /** Included skills in book. */
  private TreeSet<Skill> skills;
  
  /** Included feats in book. */
  private TreeSet<Feat> feats;
  
  /**
   * Instantiates a new book.
   *
   * @param name The book's title
   */
  public Book(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void addRace(Race race)
  {
    if(race == null)
      return;
    
    if(races == null)
      races = new TreeSet<Race>();
    
    RaceIndex.getRaces().put(race.getName(), race);
    races.add(race);
  }
  
  public void addSkill(Skill skill)
  {
    if(skill == null)
      return;
    
    if(skills == null)
      skills = new TreeSet<Skill>();
    
    SkillIndex.getSkills().put(skill.getName(), skill);
    skills.add(skill);
  }
  
  public void addFeat(Feat feat)
  {
    if(feat == null)
      return;
    
    if(feats == null)
      feats = new TreeSet<Feat>();
    
    FeatIndex.getFeats().put(feat.getName(), feat);
    feats.add(feat);
  }
  
  /**
   * Gets the race.
   *
   * @param name the name
   * @return the race
   */
  public Race getRace(String name)
  {
    for(Race race : races)
    {
      if(race.getName().compareTo(name) == 0)
        return race;
    }
    
    return null;
  }
  
  /**
   * Gets the skill.
   *
   * @param name the name
   * @return the skill
   */
  public Skill getSkill(String name)
  {
    for(Skill skill : skills)
    {
      if(skill.getName().compareTo(name) == 0)
        return skill;
    }
    
    return null;
  }
  
  /**
   * Gets the feat.
   *
   * @param name the name
   * @return the feat
   */
  public Feat getFeat(String name)
  {
    for(Feat feat : feats)
    {
      if(feat.getName().compareTo(name) == 0)
        return feat;
    }
    
    return null;
  }
  
  public void updateIndexes()
  {
    // TODO: Implement this method
  }

}
