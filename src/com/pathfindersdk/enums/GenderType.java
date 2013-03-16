package com.pathfindersdk.enums;

public enum GenderType
{
  MALE ("Male"),
  FEMALE ("Female");
  
  private final String name;
  
  private GenderType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
