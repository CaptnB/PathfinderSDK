package com.pathfindersdk.basics;

public enum SaveType
{
  FORTITUDE ("Fortitude"),
  REFLEX ("Reflex"),
  WILL ("Will");
  
  private String name;
  
  private SaveType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
