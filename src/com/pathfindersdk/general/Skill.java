package com.pathfindersdk.general;

/**
 * The Enum Skill.
 */
public enum Skill
{
  
  /** Acrobatics skill. */
  ACROBATICS ("Acrobatics", Ability.DEX, true, true),
  
  /** Appraise skill. */
  APPRAISE ("Appraise", Ability.INT, true, false),
  
  /** Bluff skill. */
  BLUFF ("Bluff", Ability.CHA, true, false),
  
  /** Climb skill. */
  CLIMB ("Climb", Ability.STR, true, true),
  
  /** Craft skill. */
  CRAFT ("Craft", Ability.INT, true, false),
  
  /** Diplomacy skill. */
  DIPLOMACY ("Diplomacy", Ability.CHA, true, false),
  
  /** Disable Device skill. */
  DISABLE_DEVICE ("Disable Device", Ability.DEX, false, true),
  
  /** Disguise skill. */
  DISGUISE ("Disguise", Ability.CHA, true, false),
  
  /** Escape Artist skill. */
  ESCAPE_ARTIST ("Escape Artist", Ability.DEX, true, true),
  
  /** Fly skill. */
  FLY ("Fly", Ability.DEX, true, true),
  
  /** Handle Animal skill. */
  HANDLE_ANIMAL ("Handle Animal", Ability.CHA, false, false),
  
  /** Heal skill. */
  HEAL ("Heal", Ability.WIS, true, false),
  
  /** Intimidate skill. */
  INTIMIDATE ("Intimidate", Ability.CHA, true, false),
  
  /** Knowledge (arcana) skill. */
  KNOWLEDGE_ARCANA ("Knowledge (arcana)", Ability.INT, false, false),
  
  /** Knowledge (dungeonneering) skill. */
  KNOWLEDGE_DUNGEONNEERING ("Knowledge (dungeoneering)", Ability.INT, false, false),
  
  /** Knowledge (engineering) skill. */
  KNOWLEDGE_ENGINEERING ("Knowledge (engineering)", Ability.INT, false, false),
  
  /** Knowledge (geography) skill. */
  KNOWLEDGE_GEOGRAPHY ("Knowledge (geography)", Ability.INT, false, false),
  
  /** Knowledge (history) skill. */
  KNOWLEDGE_HISTORY ("Knowledge (history)", Ability.INT, false, false),
  
  /** Knowledge (local) skill. */
  KNOWLEDGE_LOCAL ("Knowledge (local)", Ability.INT, false, false),
  
  /** Knowledge (nature) skill. */
  KNOWLEDGE_NATURE ("Knowledge (nature)", Ability.INT, false, false),
  
  /** Knowledge (nobility) skill. */
  KNOWLEDGE_NOBILITY ("Knowledge (nobility)", Ability.INT, false, false),
  
  /** Knowledge (planes) skill. */
  KNOWLEDGE_PLANES ("Knowledge (planes)", Ability.INT, false, false),
  
  /** Knowledge (religion) skill. */
  KNOWLEDGE_RELIGION ("Knowledge (religion)", Ability.INT, false, false),
  
  /** Linguistics skill. */
  LINGUISTICS ("Linguistics", Ability.INT, false, false),
  
  /** Perception skill. */
  PERCEPTION ("Perception", Ability.WIS, true, false),
  
  /** Perform skill. */
  PERFORM ("Perform", Ability.CHA, true, false),
  
  /** Profession skill. */
  PROFESSION ("Profession", Ability.WIS, false, false),
  
  /** Ride skill. */
  RIDE ("Ride", Ability.DEX, true, true),
  
  /** Sense Motive skill. */
  SENSE_MOTIVE ("Sense Motive", Ability.WIS, true, false),
  
  /** Sleight of Hand skill. */
  SLEIGHT_OF_HAND ("Sleight of Hand", Ability.DEX, false, true),
  
  /** Spellcraft skill. */
  SPELLCRAFT ("Spellcraft", Ability.INT, false, false),
  
  /** Stealth skill. */
  STEALTH ("Stealth", Ability.DEX, true, true),
  
  /** Survival skill. */
  SURVIVAL ("Survival", Ability.WIS, true, false),
  
  /** Swim skill. */
  SWIM ("Swim", Ability.STR, true, true),
  
  /** Use Magic Device skill. */
  USE_MAGIC_DEVICE ("Use Magic Device", Ability.CHA, false, false);

  /** Skill name. */
  private final String name;
  
  /** Skill key ability. */
  private final Ability keyAbility;
  
  /** Skill usable untrained. */
  private final Boolean untrained;
  
  /** Skill takes into account armor check penalty. */
  private final Boolean armorCheckPenalty;
  
  /**
   * Instantiates a new skill.
   *
   * @param name skill name
   * @param keyAbility skill key ability
   * @param untrained skill usable untrained
   * @param armorCheckPenalty skill takes into account armor check penalty
   */
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
