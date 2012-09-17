package com.pathfindersdk.feats;

import java.util.HashSet;

import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.Prerequisite;

/**
 * The Class Feat. 
 */
public class Feat
{
  
  /** Feats's name. */
  private String name;
  
  /** Feat's type. */
  private FeatType type;
  
  // With lists of Prerequisite and Bonus abstract types, I can write into JSON but
  // cannot resolve the type of each object when reading from it. That's 
  
  /** Feat's prerequisites. */
  private HashSet<Prerequisite> prereqs = new HashSet<Prerequisite>();
  
  /** Feat's benefits. */
  private HashSet<Bonus> benefits = new HashSet<Bonus>();
  
  /**
   * Instantiates a new feat.
   *
   * @param name the name
   * @param type the type
   */
  public Feat(String name, FeatType type)
  {
    this.name = name;
    this.type = type;
  }
  
  
  public String getName()
  {
    return name;
  }
  
  public FeatType getFeatType()
  {
    return type;
  }
  
  public HashSet<Prerequisite> getPrerequisites()
  {
    return prereqs;
  }
  
  public HashSet<Bonus> getBenefits()
  {
    return benefits;    
  }
}
