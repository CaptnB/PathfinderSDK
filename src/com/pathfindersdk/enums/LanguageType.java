package com.pathfindersdk.enums;

/**
 * This enum lists all available Languages.
 */
public enum LanguageType
{
  ABYSSAL ("Abyssal"),
  AKLO ("Aklo"),
  AQUAN ("Aquan"),
  AURAN ("Auran"),
  CELESTIAL ("Celestial"),
  COMMON ("Common"),
  DRACONIC ("Draconic"),
  DRUIDIC ("Druidic"),
  DWARVEN ("Dwarven"),
  ELVEN ("Elven"),
  GIANT ("Giant"),
  GNOME ("Gnome"),
  GOBLIN ("Goblin"),
  GNOLL ("Gnoll"),
  HALFLING ("Halfling"),
  IGNAN ("Ignan"),
  INFERNAL ("Infernal"),
  ORC ("Orc"),
  SYLVAN ("Sylvan"),
  TERRAN ("Terran"),
  UNDERCOMMON ("Undercommon");
  
  private final String name;
  
  private LanguageType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
