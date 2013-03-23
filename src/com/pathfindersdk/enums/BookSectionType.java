package com.pathfindersdk.enums;

public enum BookSectionType
{
  RACES ("Races"),
  ALTERNATE_RACIAL_TRAITS ("Alternate Racial Traits"),
  CLASSES ("Classes"),
  CLASS_EXTENSIONS ("Class Extensions"),
  ARCHETYPES ("Archetypes"),
  PRESTIGE_CLASSES ("Prestige Classes"),
  SKILLS ("Skills"),
  FEATS ("Feats"),
  SPELLS ("Spells"),
  EQUIPMENT ("Equipment"),
  MONSTERS ("Monsters");
  
  private final String name;
  
  private BookSectionType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}