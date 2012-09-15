package com.pathfindersdk.core;

public enum SkillType
{
  ACROBATICS ("Acrobatics"),
  APPRAISE ("Appraise"),
  BLUFF ("Bluff"),
  CLIMB ("Climb"),
  CRAFT ("Craft"),
  DIPLOMACY ("Diplomacy"),
  DISABLE_DEVICE ("Disable Device"),
  DISGUISE ("Disguise"),
  ESCAPE_ARTIST ("Escape Artist"),
  FLY ("Fly"),
  HANDLE_ANIMAL ("Handle Animal"),
  HEAL ("Heal"),
  INTIMIDATE ("Intimidate"),
  KNOWLEDGE_ARCANA ("Knowledge (arcana)"),
  KNOWLEDGE_DUNGEONNEERING ("Knowledge (dungeoneering)"),
  KNOWLEDGE_ENGINEERING ("Knowledge (engineering)"),
  KNOWLEDGE_GEOGRAPHY ("Knowledge (geography)"),
  KNOWLEDGE_HISTORY ("Knowledge (history)"),
  KNOWLEDGE_LOCAL ("Knowledge (local)"),
  KNOWLEDGE_NATURE ("Knowledge (nature)"),
  KNOWLEDGE_NOBILITY ("Knowledge (nobility)"),
  KNOWLEDGE_PLANES ("Knowledge (planes)"),
  KNOWLEDGE_RELIGION ("Knowledge (religion)"),
  LINGUISTICS ("Linguistics"),
  PERCEPTION ("Perception"),
  PERFORM ("Perform"),
  PROFESSION ("Profession"),
  RIDE ("Ride"),
  SENSE_MOTIVE ("Sense Motive"),
  SLEIGHT_OF_HAND ("Sleight of Hand"),
  SPELLCRAFT ("Spellcraft"),
  STEALTH ("Stealth"),
  SURVIVAL ("Survival"),
  SWIM ("Swim"),
  USE_MAGIC_DEVICE ("Use Magic Device");
  
  private final String name;
  
  private SkillType(String name)
  {
    this.name = name;
  }
  
  @Override public String toString()
  {
    return name;
  }
}
