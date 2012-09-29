package com.pathfindersdk.basics;

/**
 * This enum lists all available vision types.
 */
public enum Vision
{
  NORMAL ("Normal"),
  LOW_LIGHT ("Low-Light"),
  DARKVISION ("Darkvision");
  
  private final String name;
  
  private Vision(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
