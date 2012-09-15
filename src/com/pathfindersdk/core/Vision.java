package com.pathfindersdk.core;

public enum Vision
{
  NORMAL ("Normal"),
  LOW_LIGHT ("Low-Light"),
  DARKVISION ("Darkvision");
  
  private final String name;
  Vision(String name)
  {
    this.name = name;
  }
  
  @Override public String toString()
  {
    return name;
  }
}
