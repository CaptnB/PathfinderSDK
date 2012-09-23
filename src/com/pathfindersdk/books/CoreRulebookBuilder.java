package com.pathfindersdk.books;

import com.pathfindersdk.basics.Ability;
import com.pathfindersdk.basics.CreatureMainType;
import com.pathfindersdk.basics.CreatureSubtype;
import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Language;
import com.pathfindersdk.basics.Race;
import com.pathfindersdk.basics.RacialTrait;
import com.pathfindersdk.basics.Size;
import com.pathfindersdk.basics.Skill;
import com.pathfindersdk.basics.SpeedType;
import com.pathfindersdk.basics.Vision;
import com.pathfindersdk.bonus.AbilityBonus;
import com.pathfindersdk.bonus.BonusType;
import com.pathfindersdk.stats.SpeedStat;
/**
* This class builds the Core Rulebook content and returns the book.
*/
public class CoreRulebookBuilder extends BookBuilder
{

  @Override
  protected void addRaces(Book book)
  {
    CreatureType type;
    RacialTrait trait;
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.DWARF);
    Race dwarf = new Race("Dwarf", type, Size.MEDIUM);
    dwarf.addVision(Vision.DARKVISION);
    dwarf.addSpeed(new SpeedStat(20, SpeedType.BASE));
    dwarf.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    dwarf.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.CON));
    dwarf.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.WIS));
    dwarf.addAbilityBonus(new AbilityBonus(-2, BonusType.RACIAL, Ability.CHA));
    dwarf.addBaseLanguage(Language.COMMON);
    dwarf.addBaseLanguage(Language.DWARVEN);
    dwarf.addOptionalLanguage(Language.GIANT);
    dwarf.addOptionalLanguage(Language.GNOME);
    dwarf.addOptionalLanguage(Language.GOBLIN);
    dwarf.addOptionalLanguage(Language.ORC);
    dwarf.addOptionalLanguage(Language.TERRAN);
    dwarf.addOptionalLanguage(Language.UNDERCOMMON);
    trait = new RacialTrait("Slow and Steady");
    dwarf.addTrait(trait);
    trait = new RacialTrait("Defensive Training");
    dwarf.addTrait(trait);
    trait = new RacialTrait("Greed");
    dwarf.addTrait(trait);
    trait = new RacialTrait("Hatred");
    dwarf.addTrait(trait);
    trait = new RacialTrait("Hardy");
    dwarf.addTrait(trait);
    trait = new RacialTrait("Stability");
    dwarf.addTrait(trait);
    trait = new RacialTrait("Stonecunning");
    dwarf.addTrait(trait);
    // Weapon familiarity
    book.addRace(dwarf);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    Race elf = new Race("Elf", type, Size.MEDIUM);
    elf.addVision(Vision.LOW_LIGHT);
    elf.addSpeed(new SpeedStat(30, SpeedType.BASE));
    elf.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    elf.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.DEX));
    elf.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.INT));
    elf.addAbilityBonus(new AbilityBonus(-2, BonusType.RACIAL, Ability.CON));
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
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    Race gnome = new Race("Gnome", type, Size.SMALL);
    gnome.addVision(Vision.LOW_LIGHT);
    gnome.addSpeed(new SpeedStat(20, SpeedType.BASE));
    gnome.addSpeed(new SpeedStat(15, SpeedType.ARMOR));
    gnome.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.CON));
    gnome.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.CHA));
    gnome.addAbilityBonus(new AbilityBonus(-2, BonusType.RACIAL, Ability.STR));
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
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    Race halfElf = new Race("Half-Elf", type, Size.MEDIUM);
    halfElf.addVision(Vision.LOW_LIGHT);
    halfElf.addSpeed(new SpeedStat(30, SpeedType.BASE));
    halfElf.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    halfElf.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.ANY));
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
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    Race halfOrc = new Race("Half-Orc", type, Size.MEDIUM);
    halfOrc.addVision(Vision.DARKVISION);
    halfOrc.addSpeed(new SpeedStat(30, SpeedType.BASE));
    halfOrc.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    halfOrc.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.ANY));
    halfOrc.addBaseLanguage(Language.COMMON);
    halfOrc.addBaseLanguage(Language.ORC);
    halfOrc.addOptionalLanguage(Language.ABYSSAL);
    halfOrc.addOptionalLanguage(Language.DRACONIC);
    halfOrc.addOptionalLanguage(Language.GIANT);
    halfOrc.addOptionalLanguage(Language.GNOLL);
    halfOrc.addOptionalLanguage(Language.GOBLIN);
    book.addRace(halfOrc);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    Race halfling = new Race("Halfling", type, Size.SMALL);
    halfling.addVision(Vision.NORMAL);
    halfling.addSpeed(new SpeedStat(20, SpeedType.BASE));
    halfling.addSpeed(new SpeedStat(15, SpeedType.ARMOR));
    halfling.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.DEX));
    halfling.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.CHA));
    halfling.addAbilityBonus(new AbilityBonus(-2, BonusType.RACIAL, Ability.STR));
    halfling.addBaseLanguage(Language.COMMON);
    halfling.addBaseLanguage(Language.HALFLING);
    halfling.addOptionalLanguage(Language.DWARVEN);
    halfling.addOptionalLanguage(Language.ELVEN);
    halfling.addOptionalLanguage(Language.GNOME);
    halfling.addOptionalLanguage(Language.GOBLIN);
    book.addRace(halfling);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    Race human = new Race("Human", type, Size.MEDIUM);
    human.addVision(Vision.NORMAL);
    human.addSpeed(new SpeedStat(30, SpeedType.BASE));
    human.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    human.addAbilityBonus(new AbilityBonus(2, BonusType.RACIAL, Ability.ANY));
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

  @Override
  protected void addClasses(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addClassExtensions(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addArchetypes(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addPrestigeClasses(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addFeats(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addEquipment(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addActions(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addSpells(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addMonsters(Book book)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addSkills(Book book)
  {
    book.addSkill(new Skill("Acrobatics", Ability.DEX, true, true));
    book.addSkill(new Skill("Appraise", Ability.INT, true, false));
    book.addSkill(new Skill("Bluff", Ability.CHA, true, false));
    book.addSkill(new Skill("Climb", Ability.STR, true, true));
    book.addSkill(new Skill("Craft", Ability.INT, true, false));
    book.addSkill(new Skill("Diplomacy", Ability.CHA, true, false));
    book.addSkill(new Skill("Disable Device", Ability.DEX, false, true));
    book.addSkill(new Skill("Disguise", Ability.CHA, true, false));
    book.addSkill(new Skill("Escape Artist", Ability.DEX, true, true));
    book.addSkill(new Skill("Fly", Ability.DEX, true, true));
    book.addSkill(new Skill("Handle Animal", Ability.CHA, false, false));
    book.addSkill(new Skill("Heal", Ability.WIS, true, false));
    book.addSkill(new Skill("Intimidate", Ability.CHA, true, true));
    book.addSkill(new Skill("Knowledge (arcana)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (dungeonneering)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (engineering)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (geography)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (history)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (local)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (nature)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (nobility)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (planes)", Ability.INT, false, false));
    book.addSkill(new Skill("Knowledge (religion)", Ability.INT, false, false));
    book.addSkill(new Skill("Linguistics", Ability.INT, false, false));
    book.addSkill(new Skill("Perception", Ability.WIS, true, false));
    book.addSkill(new Skill("Perform", Ability.CHA, true, false));
    book.addSkill(new Skill("Profession", Ability.WIS, false, false));
    book.addSkill(new Skill("Ride", Ability.DEX, true, true));
    book.addSkill(new Skill("Sense Motive", Ability.WIS, true, false));
    book.addSkill(new Skill("Sleight of Hand", Ability.DEX, false, true));
    book.addSkill(new Skill("Spellcraft", Ability.INT, false, false));
    book.addSkill(new Skill("Stealth", Ability.DEX, true, true));
    book.addSkill(new Skill("Survival", Ability.WIS, true, false));
    book.addSkill(new Skill("Swim", Ability.STR, true, true));
    book.addSkill(new Skill("Use Magic Device", Ability.CHA, false, false));
  }

  @Override
  protected void addSkillExpansions(Book book)
  {
    // TODO Auto-generated method stub

    /*Skill craft = book.getSkill("Craft");
    if(craft != null)
    {
      craft.getExpansions().add("alchemy");
      craft.getExpansions().add("armor");
      craft.getExpansions().add("baskets");
      craft.getExpansions().add("books");
      craft.getExpansions().add("bows");
      craft.getExpansions().add("calligraphy");
      craft.getExpansions().add("carpentry");
      craft.getExpansions().add("cloth");
      craft.getExpansions().add("clothing");
      craft.getExpansions().add("glass");
      craft.getExpansions().add("jewelry");
      craft.getExpansions().add("leather");
      craft.getExpansions().add("locks");
      craft.getExpansions().add("paintings");
      craft.getExpansions().add("pottery");
      craft.getExpansions().add("sculptures");
      craft.getExpansions().add("ships");
      craft.getExpansions().add("shoes");
      craft.getExpansions().add("stonemasonry");
      craft.getExpansions().add("traps");
      craft.getExpansions().add("weapons");
    }
    
    Skill perform = book.getSkill("Perform");
    if(perform != null)
    {
      perform.getExpansions().add("act");
      perform.getExpansions().add("comedy");
      perform.getExpansions().add("dance");
      perform.getExpansions().add("keyboard");
      perform.getExpansions().add("oratory");
      perform.getExpansions().add("percussion instruments");
      perform.getExpansions().add("string instruments");
      perform.getExpansions().add("wind instruments");
      perform.getExpansions().add("sing");
    }

    Skill profession = book.getSkill("Profession");
    if(profession != null)
    {
      profession.getExpansions().add("architect");
      profession.getExpansions().add("baker");
      profession.getExpansions().add("barrister");
      profession.getExpansions().add("brewer");
      profession.getExpansions().add("butcher");
      profession.getExpansions().add("clerk");
      profession.getExpansions().add("cook");
      profession.getExpansions().add("courtesan");
      profession.getExpansions().add("driver");
      profession.getExpansions().add("engineer");
      profession.getExpansions().add("farmer");
      profession.getExpansions().add("fisherman");
      profession.getExpansions().add("gambler");
      profession.getExpansions().add("gardener");
      profession.getExpansions().add("herbalist");
      profession.getExpansions().add("innkeeper");
      profession.getExpansions().add("librarian");
      profession.getExpansions().add("merchant");
      profession.getExpansions().add("midwife");
      profession.getExpansions().add("miller");
      profession.getExpansions().add("miner");
      profession.getExpansions().add("porter");
      profession.getExpansions().add("sailor");
      profession.getExpansions().add("scribe");
      profession.getExpansions().add("shepherd");
      profession.getExpansions().add("stable master");
      profession.getExpansions().add("soldier");
      profession.getExpansions().add("tanner");
      profession.getExpansions().add("trapper");
      profession.getExpansions().add("woodcutter");
    }*/
  }

}
