package com.pathfindersdk.indexes;

import java.util.Hashtable;
import java.util.Map;

/**
 * This class gathers all races from all books into one accessible singleton.
 */
import com.pathfindersdk.basics.Race;

public class RaceIndex
{
  private static RaceIndex instance = new RaceIndex();
  private static Map<String, Race> races = new Hashtable<String, Race>();
    
  public static RaceIndex getInstance()
  {
    return instance;
  }
  
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
