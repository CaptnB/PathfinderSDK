package com.pathfindersdk.creatures;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.enums.CreatureMainType;
import com.pathfindersdk.enums.CreatureSubtype;

public class CreatureType
{
  protected CreatureMainType type;
  protected SortedSet<CreatureSubtype> subtypes;
  
  public CreatureType(CreatureType type)
  {
    this.type = type.getType();
    for(CreatureSubtype subtype : type.getSubtypes())
      addSubtype(subtype);
  }
  
  public CreatureType(CreatureMainType type)
  {
    this.type = type;
  }
  
  public CreatureMainType getType()
  {
    return type;
  }

  public void setType(CreatureMainType type)
  {
    this.type = type;
  }

  public SortedSet<CreatureSubtype> getSubtypes()
  {
    return Collections.unmodifiableSortedSet(subtypes);
  }

  public void addSubtype(CreatureSubtype subtype)
  {
    if(subtype != null)
    {
      if(subtypes == null)
        subtypes = new TreeSet<CreatureSubtype>();
      
      subtypes.add(subtype);
    }
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
