package com.pathfindersdk.indexes;

import java.util.Hashtable;
import java.util.Map;

import com.pathfindersdk.creatures.characters.Race;

public class RaceIndex
{
  private static RaceIndex instance = new RaceIndex();
  
  private static Map<String, Race> races = new Hashtable<String, Race>();
  
  private RaceIndex() {}
  
  public static Race getRace(String name)
  {
    return races.get(name);
  }
  
  public static Map<String, Race> getRaces()
  {
    return races;
  }
}
