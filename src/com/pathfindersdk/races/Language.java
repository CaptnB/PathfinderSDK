package com.pathfindersdk.races;

/**
 * The Enum Language.
 */
public enum Language
{
  
  /** Abyssal language. */
  ABYSSAL ("Abyssal"),
  
  /** Aklo language. */
  AKLO ("Aklo"),
  
  /** Aquan language. */
  AQUAN ("Aquan"),
  
  /** Auran language. */
  AURAN ("Auran"),
  
  /** Celestial language. */
  CELESTIAL ("Celestial"),
  
  /** Common language. */
  COMMON ("Common"),
  
  /** Draconic language. */
  DRACONIC ("Draconic"),
  
  /** Druidic language. */
  DRUIDIC ("Druidic"),
  
  /** Dwarven language. */
  DWARVEN ("Dwarven"),
  
  /** Elven language. */
  ELVEN ("Elven"),
  
  /** Giant language. */
  GIANT ("Giant"),
  
  /** Gnome language. */
  GNOME ("Gnome"),
  
  /** Goblin language. */
  GOBLIN ("Goblin"),
  
  /** Gnoll language. */
  GNOLL ("Gnoll"),
  
  /** Halfling language. */
  HALFLING ("Halfling"),
  
  /** Ignan language. */
  IGNAN ("Ignan"),
  
  /** Infernal language. */
  INFERNAL ("Infernal"),
  
  /** Orc language. */
  ORC ("Orc"),
  
  /** Sylvan language. */
  SYLVAN ("Sylvan"),
  
  /** Terran language. */
  TERRAN ("Terran"),
  
  /** Undercommon language. */
  UNDERCOMMON ("Undercommon");
  
  /** Language name. */
  private final String name;
  
  /**
   * Instantiates a new language.
   *
   * @param name language name
   */
  private Language(String name)
  {
    this.name = name;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override public String toString()
  {
    return name;
  }
}
