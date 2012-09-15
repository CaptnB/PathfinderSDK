package com.pathfindersdk.books;

import java.util.TreeMap;

import com.pathfindersdk.feats.Feat;
import com.pathfindersdk.races.Race;

public class Book
{
  private String name;
  
  private TreeMap<String, Race> races = new TreeMap<String, Race>();
  //private TreeMap<String, Class> classes = new TreeMap<String, Class>();
  //private TreeMap<String, ClassExtension> classExtensions = new TreeMap<String, ClassExtension>();
  //private TreeMap<String, Archetype> archetypes = new TreeMap<String, Archetype>();
  //private TreeMap<String, PrestigeClass> prestigeClasses = new TreeMap<String, PrestigeClass>();
  private TreeMap<String, Feat> feats = new TreeMap<String, Feat>();
  //private TreeMap<String, Equipment> equipment = new TreeMap<String, Equipment>();
  //private TreeMap<String, Action> actions = new TreeMap<String, Action>();
  //private TreeMap<String, Spell> spells = new TreeMap<String, Spell>();
  //private TreeMap<String, Monster> monsters = new TreeMap<String, Monster>();
  
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
    races.put(race.getName(), race);
  }
  
  public void addFeat(Feat feat)
  {
    feats.put(feat.getName(), feat);
  }

}
