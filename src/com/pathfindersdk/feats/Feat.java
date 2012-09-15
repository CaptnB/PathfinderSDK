package com.pathfindersdk.feats;

import java.util.ArrayList;

import com.pathfindersdk.general.Bonus;

public class Feat
{
  private String name;
  private FeatType type;
  private ArrayList<FeatPrerequisite> prerequisites = new ArrayList<FeatPrerequisite>();
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
