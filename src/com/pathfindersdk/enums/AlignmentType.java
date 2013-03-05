package com.pathfindersdk.enums;

/**
 * This enum lists all 9 alignments.
 */
public enum AlignmentType
{
  LAWFUL_GOOD ("Lawful Good"),
  LAWFUL_NEUTRAL ("Lawful Neutral"),
  LAWFUL_EVIL ("Lawful Evil"),
  NEUTRAL_GOOD ("Neutral Good"),
  NEUTRAL ("Neutral"),
  NEUTRAL_EVIL ("Neutral Evil"),
  CHAOTIC_GOOD ("Chaotic Good"),
  CHAOTIC_NEUTRAL ("Chaotic Neutral"),
  CHAOTIC_EVIL ("Chaotic Evil");
  
  private final String name;
  
  private AlignmentType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
