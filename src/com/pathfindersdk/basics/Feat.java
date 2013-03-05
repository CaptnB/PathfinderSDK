package com.pathfindersdk.basics;

import java.util.HashSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.enums.FeatType;
import com.pathfindersdk.prerequisites.Prerequisite;

/**
 * This class represents feats. 
 */
public class Feat //implements Feature
{
  protected FeatType type;
  protected HashSet<Prerequisite> prerequisites = new HashSet<Prerequisite>();
  protected HashSet<Bonus> benefits = new HashSet<Bonus>();
  
  public Feat(String name, FeatType type)
  {
    this.type = type;
  }
  
  public FeatType getFeatType()
  {
    return type;
  }
  
  public HashSet<Prerequisite> getPrerequisites()
  {
    return prerequisites;
  }
  
  public HashSet<Bonus> getBenefits()
  {
    return benefits;    
  }

}
