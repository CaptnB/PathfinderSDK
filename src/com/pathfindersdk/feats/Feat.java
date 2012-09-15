package com.pathfindersdk.feats;

import java.util.ArrayList;

import com.pathfindersdk.general.Bonus;

/**
 * The Class Feat. 
 */
public class Feat
{
  
  /** Feats's name. */
  private String name;
  
  /** Feat's type. */
  private FeatType type;
  
  /** Feat's prerequisites. */
  private ArrayList<FeatPrerequisite> prerequisites = new ArrayList<FeatPrerequisite>();
  
  /** Feat's benefits. */
  private ArrayList<Bonus> benefits = new ArrayList<Bonus>();
  
  
  
  public String getName()
  {
    return name;
  }
  
  public FeatType getFeatType()
  {
    return type;
  }
  
  
}
