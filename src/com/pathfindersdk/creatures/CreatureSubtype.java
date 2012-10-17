package com.pathfindersdk.creatures;

/**
 * This enum lists all creature subtypes.
 */
public enum CreatureSubtype
{
  AIR ("air"),
  AQUATIC ("aquatic"),
  CHAOTIC ("chaotic"),
  COLD ("cold"),
  DWARF ("dwarf"),
  EARTH ("earth"),
  ELEMENTAL ("elemental"),
  ELF ("elf"),
  EVIL ("evil"),
  FIRE ("fire"),
  GIANT ("giant"),
  GNOLL ("gnoll"),
  GNOME ("gnome"),
  GOBLINOID ("goblinoid"),
  GOOD ("good"),
  HALFLING ("halfling"),
  HUMAN ("human"),
  INCORPOREAL ("incorporeal"),
  LAWFUL ("lawful"),
  NATIVE ("native"),
  ORC ("orc"),
  REPTILIAN ("reptilian"),
  SHAPECHANGER ("shapechanger"),
  SWARM ("swarm"),
  WATER ("water");
  
  private final String name;
  
  private CreatureSubtype(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
  
}
