package com.pathfindersdk.basics;

import java.util.TreeSet;

public class CreatureType
{
  private CreatureMainType type;
  private TreeSet<CreatureSubtype> subtypes;
  
  public CreatureType(CreatureMainType type)
  {
    this.type = type;
  }
  
  public void addSubtype(CreatureSubtype subtype)
  {
    if(subtypes == null)
      subtypes = new TreeSet<CreatureSubtype>();
    
    subtypes.add(subtype);
  }
  
  public void removeSubtype(CreatureSubtype subtype)
  {
    if(subtypes != null)
    {
      subtypes.remove(subtype);
      
      if(subtypes.isEmpty())
        subtypes = null;
    }
  }

  public String getName()
  {
    if(subtypes == null)
      return type.getName();
    else
    {
      String name = type.getName() + " (";
      for(CreatureSubtype subtype : subtypes)
      {
        name += subtype.getName();
        if(subtype != subtypes.last())
          name += ", ";
      }
      return name + ")";
    }
  }
}
