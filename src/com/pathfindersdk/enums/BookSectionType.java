package com.pathfindersdk.enums;

public enum BookSectionType
{
  RACES                   ("Races"),
  ALTERNATE_RACIAL_TRAITS ("Alternate Racial Traits"),
  
  CLASSES                 ("Classes"),
  CLASS_EXTENSIONS        ("Class Extensions"),
  ARCHETYPES              ("Archetypes"),
  PRESTIGE_CLASSES        ("Prestige Classes"),
  
  SKILLS                  ("Skills"),
  
  FEATS                   ("Feats"),
  
  WEAPONS                 ("Weapons"),
  ARMORS                  ("Armors"),
  SHIELDS                 ("Shields"),
  EQUIPMENT               ("Equipment"),
  
  SPELLS                  ("Spells"),
  
  MAGIC_ITEMS             ("Magic Items"),
  MAGIC_WEAPONS           ("Magic Weapons"),
  MAGIC_ARMORS            ("Magic Armors"),
  MAGIC_SHIELDS           ("Magic Shields"),
  POTIONS                 ("Potions"),
  RINGS                   ("Rings"),
  RODS                    ("Rods"),
  SCROLLS                 ("Scrolls"),
  STAVES                  ("Staves"),
  WANDS                   ("Wands"),
  WONDROUS_ITEMS          ("Wondrous Items"),
  INTELLIGENT_ITEMS       ("Intelligent Items"),
  CURSED_ITEMS            ("Cursed Items"),
  ARTIFACTS               ("Artifacts"),
  
  MONSTERS                ("Monsters"),
  MONSTER_TEMPLATES       ("Monster Templates");
  
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