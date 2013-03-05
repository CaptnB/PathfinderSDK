package com.pathfindersdk.enums;

/**
 * This enum lists all creature types.
 */
public enum CreatureMainType
{
  ABERRATION ("Aberration"),
  ANIMAL ("Animal"),
  CONSTRUCT ("Construct"),
  DRAGON ("Dragon"),
  FEY ("Feay"),
  HUMANOID ("Humanoid"),
  MAGICAL_BEAST ("Magical Beast"),
  MONSTROUS_HUMANOID ("Monstrous Humanoid"),
  OOZE ("Ooze"),
  OUTSIDER ("Outsider"),
  PLANT ("Plant"),
  UNDEAD ("Undead"),
  VERMIN ("Vermin");
  
  private final String name;
  
  private CreatureMainType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }

}
