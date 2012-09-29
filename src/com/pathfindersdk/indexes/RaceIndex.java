package com.pathfindersdk.indexes;

import java.util.Hashtable;
import java.util.Map;

/**
 * This class gathers all races from all books into one accessible singleton.
 */
import com.pathfindersdk.books.items.RaceItem;

public final class RaceIndex
{
  private static RaceIndex instance = new RaceIndex();
  private static Map<String, RaceItem> races = new Hashtable<String, RaceItem>();
    
  public static RaceIndex getInstance()
  {
    return instance;
  }
  
  private RaceIndex() {}
  
  public static RaceItem getRace(String name)
  {
    return races.get(name);
  }
  
  public static Map<String, RaceItem> getRaces()
  {
    return races;
  }
}
