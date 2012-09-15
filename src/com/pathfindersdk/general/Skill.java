package com.pathfindersdk.general;


public enum Skill
{
  ACROBATICS ("Acrobatics", Ability.DEX, true, true),
  APPRAISE ("Appraise", Ability.INT, true, false),
  BLUFF ("Bluff", Ability.CHA, true, false),
  CLIMB ("Climb", Ability.STR, true, true),
  CRAFT ("Craft", Ability.INT, true, false),
  DIPLOMACY ("Diplomacy", Ability.CHA, true, false),
  DISABLE_DEVICE ("Disable Device", Ability.DEX, false, true),
  DISGUISE ("Disguise", Ability.CHA, true, false),
  ESCAPE_ARTIST ("Escape Artist", Ability.DEX, true, true),
  FLY ("Fly", Ability.DEX, true, true),
  HANDLE_ANIMAL ("Handle Animal", Ability.CHA, false, false),
  HEAL ("Heal", Ability.WIS, true, false),
  INTIMIDATE ("Intimidate", Ability.CHA, true, false),
  KNOWLEDGE_ARCANA ("Knowledge (arcana)", Ability.INT, false, false),
  KNOWLEDGE_DUNGEONNEERING ("Knowledge (dungeoneering)", Ability.INT, false, false),
  KNOWLEDGE_ENGINEERING ("Knowledge (engineering)", Ability.INT, false, false),
  KNOWLEDGE_GEOGRAPHY ("Knowledge (geography)", Ability.INT, false, false),
  KNOWLEDGE_HISTORY ("Knowledge (history)", Ability.INT, false, false),
  KNOWLEDGE_LOCAL ("Knowledge (local)", Ability.INT, false, false),
  KNOWLEDGE_NATURE ("Knowledge (nature)", Ability.INT, false, false),
  KNOWLEDGE_NOBILITY ("Knowledge (nobility)", Ability.INT, false, false),
  KNOWLEDGE_PLANES ("Knowledge (planes)", Ability.INT, false, false),
  KNOWLEDGE_RELIGION ("Knowledge (religion)", Ability.INT, false, false),
  LINGUISTICS ("Linguistics", Ability.INT, false, false),
  PERCEPTION ("Perception", Ability.WIS, true, false),
  PERFORM ("Perform", Ability.CHA, true, false),
  PROFESSION ("Profession", Ability.WIS, false, false),
  RIDE ("Ride", Ability.DEX, true, true),
  SENSE_MOTIVE ("Sense Motive", Ability.WIS, true, false),
  SLEIGHT_OF_HAND ("Sleight of Hand", Ability.DEX, false, true),
  SPELLCRAFT ("Spellcraft", Ability.INT, false, false),
  STEALTH ("Stealth", Ability.DEX, true, true),
  SURVIVAL ("Survival", Ability.WIS, true, false),
  SWIM ("Swim", Ability.STR, true, true),
  USE_MAGIC_DEVICE ("Use Magic Device", Ability.CHA, false, false);

  private final String name;
  private final Ability keyAbility;
  private final Boolean untrained;
  private final Boolean armorCheckPenalty;
  
  private Skill(String name, Ability keyAbility, Boolean untrained, Boolean armorCheckPenalty)
  {
    this.name = name;
    this.keyAbility = keyAbility;
    this.untrained = untrained;
    this.armorCheckPenalty = armorCheckPenalty;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Ability getKeyAbility()
  {
    return keyAbility;
  }
  
  public Boolean isUnTrained()
  {
    return untrained;
  }
  
  public Boolean isArmorCheckPenalty()
  {
    return armorCheckPenalty;
  }
}
