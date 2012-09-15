package com.pathfindersdk.core;

import java.util.ArrayList;

public class Feat
{
  private String name;
  private FeatType type;
  private ArrayList<FeatPrerequisite> prerequisites = new ArrayList<FeatPrerequisite>();
  //private ArrayList<Bonus> benefits = new ArrayList<Bonus>();
  
  public String getName()
  {
    return name;
  }
  
  public FeatType getFeatType()
  {
    return type;
  }
  
  
}
