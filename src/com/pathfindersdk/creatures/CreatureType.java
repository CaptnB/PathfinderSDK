package com.pathfindersdk.creatures;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.enums.CreatureMainType;
import com.pathfindersdk.enums.CreatureSubtype;
import com.pathfindersdk.utils.ArgChecker;

public class CreatureType
{
  protected CreatureMainType type;
  protected SortedSet<CreatureSubtype> subtypes;
  
  public CreatureType(CreatureMainType mainType, CreatureSubtype ... subtypes)
  {
    setType(mainType);
    
    if(subtypes != null)
    {
      for(CreatureSubtype subtype : subtypes)
      {
        addSubtype(subtype);
      }
    }
  }
  
  // Copy constructor
  public CreatureType(CreatureType type)
  {
    setType(type.getType());
    for(CreatureSubtype subtype : type.getSubtypes())
      addSubtype(subtype);
  }

  public CreatureMainType getType()
  {
    return type;
  }

  public void setType(CreatureMainType type)
  {
    ArgChecker.checkNotNull(type);

    this.type = type;
  }

  public SortedSet<CreatureSubtype> getSubtypes()
  {
    if(subtypes != null)
      return Collections.unmodifiableSortedSet(subtypes);
    else
      return null;
  }

  public void addSubtype(CreatureSubtype subtype)
  {
    ArgChecker.checkNotNull(subtype);
      
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
