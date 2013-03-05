package com.pathfindersdk.enums;

public enum BookSectionType
{
  RACES ("Races"),
  ALTERNATE_RACIAL_TRAITS ("Alternate Racial Traits"),
  CLASSES ("Classes"),
  CLASS_EXTENSIONS ("Class Extensions"),
  PRESTIGE_CLASSES ("Prestige Classes"),
  ARCHETYPES ("Archetypes"),
  SKILLS ("Skills"),
  FEATS ("Feats"),
  EQUIPMENT ("Equipment"),
  SPELLS ("Spells"),
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
