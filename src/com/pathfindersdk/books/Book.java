package com.pathfindersdk.books;

import java.util.TreeMap;

import com.pathfindersdk.feats.Feat;
import com.pathfindersdk.races.Race;

/**
 * The Class Book. It basically contains everything contained in a Pathfinder book. 
 */
public class Book
{
  
  /** Book name. */
  private String name;
  
  /** Included races in book. */
  private TreeMap<String, Race> races = new TreeMap<String, Race>();
  //private TreeMap<String, Class> classes = new TreeMap<String, Class>();
  //private TreeMap<String, ClassExtension> classExtensions = new TreeMap<String, ClassExtension>();
  //private TreeMap<String, Archetype> archetypes = new TreeMap<String, Archetype>();
  //private TreeMap<String, PrestigeClass> prestigeClasses = new TreeMap<String, PrestigeClass>();
  
  /** Included feats in book. */
  private TreeMap<String, Feat> feats = new TreeMap<String, Feat>();
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
  
  /**
   * Adds a race to the book.
   *
   * @param race Race to be added
   */
  public void addRace(Race race)
  {
    races.put(race.getName(), race);
  }
  
  /**
   * Adds a feat to the book.
   *
   * @param feat Feat to ba added
   */
  public void addFeat(Feat feat)
  {
    feats.put(feat.getName(), feat);
  }

}
