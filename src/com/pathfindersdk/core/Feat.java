package com.pathfindersdk.core;

import java.util.ArrayList;

public class Feat
{
  private String name;
  private String description;
  private FeatType type;
  private ArrayList<FeatPrerequisite> prerequisites = new ArrayList<FeatPrerequisite>();
}
