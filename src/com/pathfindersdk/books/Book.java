package com.pathfindersdk.books;

import java.util.TreeSet;

import com.pathfindersdk.creatures.Feat;
import com.pathfindersdk.creatures.Skill;
import com.pathfindersdk.creatures.characters.Race;
import com.pathfindersdk.indexes.FeatIndex;
import com.pathfindersdk.indexes.RaceIndex;
import com.pathfindersdk.indexes.SkillIndex;

/**
 * This class wraps everything a book may contain. It also adds elements into indexes for easy retrieval, say from another book. 
 */
public class Book
{
  private String name;
  private TreeSet<Race> races;
  private TreeSet<Skill> skills;
  private TreeSet<Feat> feats;
  
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
  
  public Race getRace(String name)
  {
    for(Race race : races)
    {
      if(race.getName().compareTo(name) == 0)
        return race;
    }
    
    return null;
  }
  
  public Skill getSkill(String name)
  {
    for(Skill skill : skills)
    {
      if(skill.getName().compareTo(name) == 0)
        return skill;
    }
    
    return null;
  }
  
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
