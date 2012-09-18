package com.pathfindersdk.books;

import java.util.HashSet;
import java.util.TreeSet;

import com.pathfindersdk.creatures.characters.Race;
import com.pathfindersdk.feats.Feat;
import com.pathfindersdk.skills.Skill;

/**
 * The Class Book. It basically contains everything contained in a Pathfinder book. 
 */
public class Book
{
  
  /** Book name. */
  private String name;
  
  /** Included races in book. */
  private TreeSet<Race> races = new TreeSet<Race>();
  //private TreeMap<String, Class> classes = new TreeMap<String, Class>();
  //private TreeMap<String, ClassExtension> classExtensions = new TreeMap<String, ClassExtension>();
  //private TreeMap<String, Archetype> archetypes = new TreeMap<String, Archetype>();
  //private TreeMap<String, PrestigeClass> prestigeClasses = new TreeMap<String, PrestigeClass>();
  
  /** Included skills in book. */
  private HashSet<Skill> skills = new HashSet<Skill>();
  
  /** Included feats in book. */
  private HashSet<Feat> feats = new HashSet<Feat>();
  //private TreeMap<String, Equipment> equipment = new TreeMap<String, Equipment>();
  //private TreeMap<String, Action> actions = new TreeMap<String, Action>();
  //private TreeMap<String, Spell> spells = new TreeMap<String, Spell>();
  //private TreeMap<String, Monster> monsters = new TreeMap<String, Monster>();
  
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
  
  public TreeSet<Race> getRaces()
  {
    return races;
  }
  
  public HashSet<Skill> getSkills()
  {
    return skills;
  }
  
  public HashSet<Feat> getFeats()
  {
    return feats;
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
