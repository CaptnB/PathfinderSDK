package com.pathfindersdk.basics;

import java.util.TreeSet;

public class CreatureType
{
  protected CreatureMainType type;
  protected TreeSet<CreatureSubtype> subtypes;
  
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

  @Override
  public String toString()
  {
    if(subtypes == null)
      return type.toString();
    else
    {
      String name = type.toString() + " (";
      for(CreatureSubtype subtype : subtypes)
      {
        name += subtype.toString();
        if(subtype != subtypes.last())
          name += ", ";
      }
      return name + ")";
    }
  }
}
