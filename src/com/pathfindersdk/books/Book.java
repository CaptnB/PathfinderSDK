package com.pathfindersdk.books;

import java.util.HashSet;

import com.pathfindersdk.feats.Feat;
import com.pathfindersdk.races.Race;
import com.pathfindersdk.skills.Skill;

/**
 * The Class Book. It basically contains everything contained in a Pathfinder book. 
 */
public class Book
{
  
  /** Book name. */
  private String name;
  
  /** Included races in book. */
  private HashSet<Race> races = new HashSet<Race>();
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
  
  public HashSet<Race> getRaces()
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

}
