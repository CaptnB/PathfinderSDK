package com.pathfindersdk.features;

import java.util.HashSet;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.FeatType;
import com.pathfindersdk.prerequisites.Prerequisite;

/**
 * This class represents feats. 
 */
public class Feat extends Feature<Creature>
{
  protected FeatType type;
  protected HashSet<Prerequisite> prerequisites = new HashSet<Prerequisite>();
  //protected HashSet<Bonus> benefits = new HashSet<Bonus>();
  
  public Feat(String name, FeatType type)
  {
    super(name);
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
  
  /*public HashSet<Bonus> getBenefits()
  {
    return benefits;    
  }*/

  /*@Override
  public void applyTo(Creature target)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeFrom(Creature target)
  {
    // TODO Auto-generated method stub
    
  }*/

}
