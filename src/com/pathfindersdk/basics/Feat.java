package com.pathfindersdk.basics;

import java.util.HashSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.prerequisites.Prerequisite;

/**
 * This class represents feats. 
 */
public class Feat implements Feature
{
  private String name;
  private FeatType type;
  private HashSet<Prerequisite> prerequisites = new HashSet<Prerequisite>();
  private HashSet<Bonus> benefits = new HashSet<Bonus>();
  
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
    return prerequisites;
  }
  
  public HashSet<Bonus> getBenefits()
  {
    return benefits;    
  }


  @Override
  public void apply(Character character)
  {
    // TODO Auto-generated method stub
    
  }


  @Override
  public void remove(Character character)
  {
    // TODO Auto-generated method stub
    
  }
}
