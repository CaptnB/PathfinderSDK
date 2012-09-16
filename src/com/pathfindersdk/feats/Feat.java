package com.pathfindersdk.feats;

import java.util.ArrayList;

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
  private ArrayList<Prerequisite> prereqs = new ArrayList<Prerequisite>();
  
  /** Feat's benefits. */
  private ArrayList<Bonus> benefits = new ArrayList<Bonus>();
  
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
  
  /**
   * Adds the prerequisite.
   *
   * @param prereq the prereq
   */
  public void addPrerequisite(Prerequisite prereq)
  {
    prereqs.add(prereq);    
  }
  
  /**
   * Adds the benefits.
   *
   * @param benefit the benefit
   */
  public void addBenefits(Bonus benefit)
  {
    benefits.add(benefit);    
  }
}
