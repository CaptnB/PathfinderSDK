package com.pathfindersdk.indexes;

import java.util.Hashtable;
import java.util.Map;

import com.pathfindersdk.creatures.Feat;

public class FeatIndex
{
  private static FeatIndex instance = new FeatIndex();
  
  private static Map<String, Feat> feats = new Hashtable<String, Feat>();
  
  private FeatIndex() {}
  
  public static Feat getFeat(String name)
  {
    return feats.get(name);
  }
  
  public static Map<String, Feat> getFeats()
  {
    return feats;
  }
}
