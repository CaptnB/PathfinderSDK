package com.pathfindersdk.books;

import com.pathfindersdk.creatures.Ability;
import com.pathfindersdk.creatures.AbilityScore;
import com.pathfindersdk.races.Language;
import com.pathfindersdk.races.Race;
import com.pathfindersdk.races.Size;
import com.pathfindersdk.races.Vision;
import com.pathfindersdk.skills.Skill;
import com.pathfindersdk.skills.SkillType;

/**
 * A factory for creating the Core Rulebook.
 */
public class CoreBookFactory extends BookFactory
{

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addRaces(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addRaces(Book book)
  {
    Race dwarf = new Race("Dwarf", Size.MEDIUM, Vision.DARKVISION);
    dwarf.addAbilityModifier(new AbilityScore(2, Ability.CON));
    dwarf.addAbilityModifier(new AbilityScore(2, Ability.WIS));
    dwarf.addAbilityModifier(new AbilityScore(-2, Ability.CHA));
    dwarf.addBaseLanguage(Language.COMMON);
    dwarf.addBaseLanguage(Language.DWARVEN);
    dwarf.addOptionalLanguage(Language.GIANT);
    dwarf.addOptionalLanguage(Language.GNOME);
    dwarf.addOptionalLanguage(Language.GOBLIN);
    dwarf.addOptionalLanguage(Language.ORC);
    dwarf.addOptionalLanguage(Language.TERRAN);
    dwarf.addOptionalLanguage(Language.UNDERCOMMON);
    book.addRace(dwarf);
    
    Race elf = new Race("Elf", Size.MEDIUM, Vision.LOW_LIGHT);
    elf.addAbilityModifier(new AbilityScore(2, Ability.DEX));
    elf.addAbilityModifier(new AbilityScore(2, Ability.INT));
    elf.addAbilityModifier(new AbilityScore(-2, Ability.CON));
    elf.addBaseLanguage(Language.COMMON);
    elf.addBaseLanguage(Language.ELVEN);
    elf.addOptionalLanguage(Language.CELESTIAL);
    elf.addOptionalLanguage(Language.DRACONIC);
    elf.addOptionalLanguage(Language.GNOLL);
    elf.addOptionalLanguage(Language.GNOME);
    elf.addOptionalLanguage(Language.GOBLIN);
    elf.addOptionalLanguage(Language.ORC);
    elf.addOptionalLanguage(Language.SYLVAN);
    book.addRace(elf);
    
    Race gnome = new Race("Gnome", Size.SMALL, Vision.LOW_LIGHT);
    gnome.addAbilityModifier(new AbilityScore(2, Ability.CON));
    gnome.addAbilityModifier(new AbilityScore(2, Ability.CHA));
    gnome.addAbilityModifier(new AbilityScore(-2, Ability.STR));
    gnome.addBaseLanguage(Language.COMMON);
    gnome.addBaseLanguage(Language.GNOME);
    gnome.addBaseLanguage(Language.SYLVAN);
    gnome.addOptionalLanguage(Language.DRACONIC);
    gnome.addOptionalLanguage(Language.DWARVEN);
    gnome.addOptionalLanguage(Language.ELVEN);
    gnome.addOptionalLanguage(Language.GIANT);
    gnome.addOptionalLanguage(Language.GOBLIN);
    gnome.addOptionalLanguage(Language.ORC);
    book.addRace(gnome);
    
    Race halfElf = new Race("Half-Elf", Size.MEDIUM, Vision.LOW_LIGHT);
    halfElf.addAbilityModifier(new AbilityScore(2, Ability.ANY));
    halfElf.addBaseLanguage(Language.COMMON);
    halfElf.addBaseLanguage(Language.ELVEN);
    halfElf.addOptionalLanguage(Language.ABYSSAL);
    halfElf.addOptionalLanguage(Language.AKLO);
    halfElf.addOptionalLanguage(Language.AQUAN);
    halfElf.addOptionalLanguage(Language.AURAN);
    halfElf.addOptionalLanguage(Language.CELESTIAL);
    halfElf.addOptionalLanguage(Language.DRACONIC);
    halfElf.addOptionalLanguage(Language.DWARVEN);
    halfElf.addOptionalLanguage(Language.GIANT);
    halfElf.addOptionalLanguage(Language.GNOLL);
    halfElf.addOptionalLanguage(Language.GNOME);
    halfElf.addOptionalLanguage(Language.GOBLIN);
    halfElf.addOptionalLanguage(Language.HALFLING);
    halfElf.addOptionalLanguage(Language.IGNAN);
    halfElf.addOptionalLanguage(Language.INFERNAL);
    halfElf.addOptionalLanguage(Language.ORC);
    halfElf.addOptionalLanguage(Language.SYLVAN);
    halfElf.addOptionalLanguage(Language.TERRAN);
    halfElf.addOptionalLanguage(Language.UNDERCOMMON);
    book.addRace(halfElf);
    
    Race halfOrc = new Race("Half-Orc", Size.MEDIUM, Vision.DARKVISION);
    halfOrc.addAbilityModifier(new AbilityScore(2, Ability.ANY));
    halfOrc.addBaseLanguage(Language.COMMON);
    halfOrc.addBaseLanguage(Language.ORC);
    halfOrc.addOptionalLanguage(Language.ABYSSAL);
    halfOrc.addOptionalLanguage(Language.DRACONIC);
    halfOrc.addOptionalLanguage(Language.GIANT);
    halfOrc.addOptionalLanguage(Language.GNOLL);
    halfOrc.addOptionalLanguage(Language.GOBLIN);
    book.addRace(halfOrc);
    
    Race halfling = new Race("Halfling", Size.SMALL, Vision.NORMAL);
    halfling.addAbilityModifier(new AbilityScore(2, Ability.DEX));
    halfling.addAbilityModifier(new AbilityScore(2, Ability.CHA));
    halfling.addAbilityModifier(new AbilityScore(-2, Ability.STR));
    halfling.addBaseLanguage(Language.COMMON);
    halfling.addBaseLanguage(Language.HALFLING);
    halfling.addOptionalLanguage(Language.DWARVEN);
    halfling.addOptionalLanguage(Language.ELVEN);
    halfling.addOptionalLanguage(Language.GNOME);
    halfling.addOptionalLanguage(Language.GOBLIN);
    book.addRace(halfling);
    
    Race human = new Race("Human", Size.MEDIUM, Vision.NORMAL);
    human.addAbilityModifier(new AbilityScore(2, Ability.ANY));
    human.addBaseLanguage(Language.COMMON);
    human.addOptionalLanguage(Language.ABYSSAL);
    human.addOptionalLanguage(Language.AKLO);
    human.addOptionalLanguage(Language.AQUAN);
    human.addOptionalLanguage(Language.AURAN);
    human.addOptionalLanguage(Language.CELESTIAL);
    human.addOptionalLanguage(Language.DRACONIC);
    human.addOptionalLanguage(Language.DWARVEN);
    human.addOptionalLanguage(Language.ELVEN);
    human.addOptionalLanguage(Language.GIANT);
    human.addOptionalLanguage(Language.GNOLL);
    human.addOptionalLanguage(Language.GNOME);
    human.addOptionalLanguage(Language.GOBLIN);
    human.addOptionalLanguage(Language.HALFLING);
    human.addOptionalLanguage(Language.IGNAN);
    human.addOptionalLanguage(Language.INFERNAL);
    human.addOptionalLanguage(Language.ORC);
    human.addOptionalLanguage(Language.SYLVAN);
    human.addOptionalLanguage(Language.TERRAN);
    human.addOptionalLanguage(Language.UNDERCOMMON);
    book.addRace(human);
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addClasses(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addClasses(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addClassExtensions(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addClassExtensions(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addArchetypes(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addArchetypes(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addPrestigeClasses(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addPrestigeClasses(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addFeats(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addFeats(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addEquipment(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addEquipment(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addActions(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addActions(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addSpells(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addSpells(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addMonsters(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addMonsters(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addSkills(Book book)
  {
    book.addSkill(new Skill(SkillType.ACROBATICS,               Ability.DEX, true, true));
    book.addSkill(new Skill(SkillType.APPRAISE,                 Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.BLUFF,                    Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.CLIMB,                    Ability.STR, true, true));
    book.addSkill(new Skill(SkillType.CRAFT_ALCHEMY,            Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_ARMOR,              Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_BASKETS,            Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_BOOKS,              Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_BOWS,               Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_CALLIGRAPHY,        Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_CARPENTRY,          Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_CLOTH,              Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_CLOTHING,           Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_GLASS,              Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_JEWELRY,            Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_LEATHER,            Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_LOCKS,              Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_PAINTINGS,          Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_POTTERY,            Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_SCULPTURES,         Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_SHIPS,              Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_SHOES,              Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_STONEMASONRY,       Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_TRAPS,              Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.CRAFT_WEAPONS,            Ability.INT, true, false));
    book.addSkill(new Skill(SkillType.DIPLOMACY,                Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.DISABLE_DEVICE,           Ability.DEX, false, true));
    book.addSkill(new Skill(SkillType.DISGUISE,                 Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.ESCAPE_ARTIST,            Ability.DEX, true, true));
    book.addSkill(new Skill(SkillType.FLY,                      Ability.DEX, true, true));
    book.addSkill(new Skill(SkillType.HANDLE_ANIMAL,            Ability.CHA, false, false));
    book.addSkill(new Skill(SkillType.HEAL,                     Ability.WIS, true, false));
    book.addSkill(new Skill(SkillType.INTIMIDATE,               Ability.CHA, true, true));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_ARCANA,         Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_DUNGEONNEERING, Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_ENGINEERING,    Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_GEOGRAPHY,      Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_HISTORY,        Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_LOCAL,          Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_NATURE,         Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_NOBILITY,       Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_PLANES,         Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.KNOWLEDGE_RELIGION,       Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.LINGUISTICS,              Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.PERCEPTION,               Ability.WIS, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_ACT,              Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_COMEDY,           Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_DANCE,            Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_KEYBOARD,         Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_ORATORY,          Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_PERCUSSION,       Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_SING,             Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_STRING,           Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PERFORM_WIND,             Ability.CHA, true, false));
    book.addSkill(new Skill(SkillType.PROFESSION_ARCHITECT,     Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_BAKER,         Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_BARRISTER,     Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_BREWER,        Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_BUTCHER,       Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_CLERK,         Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_COOK,          Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_COURTESAN,     Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_DRIVER,        Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_ENGINEER,      Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_FARMER,        Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_FISHERMAN,     Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_GAMBLER,       Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_HERBALIST,     Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_INNKEEPER,     Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_LIBRARIAN,     Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_MERCHANT,      Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_MIDWIFE,       Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_MILLER,        Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_MINER,         Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_PORTER,        Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_SAILOR,        Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_SCRIBE,        Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_SHEPHERD,      Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_SOLDIER,       Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_STABLE_MASTER, Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_TANNER,        Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_TRAPPER,       Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.PROFESSION_WOODCUTTER,    Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.RIDE,                     Ability.DEX, true, true));
    book.addSkill(new Skill(SkillType.SENSE_MOTIVE,             Ability.WIS, true, false));
    book.addSkill(new Skill(SkillType.SLEIGHT_OF_HAND,          Ability.DEX, false, true));
    book.addSkill(new Skill(SkillType.SPELLCRAFT,               Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.STEALTH,                  Ability.DEX, true, true));
    book.addSkill(new Skill(SkillType.SURVIVAL,                 Ability.WIS, true, false));
    book.addSkill(new Skill(SkillType.SWIM,                     Ability.STR, true, true));
    book.addSkill(new Skill(SkillType.USE_MAGIC_DEVICE,         Ability.CHA, false, false));
  }

}
