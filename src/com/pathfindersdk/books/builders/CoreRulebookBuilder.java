package com.pathfindersdk.books.builders;

import com.pathfindersdk.basics.CreatureMainType;
import com.pathfindersdk.basics.CreatureSubtype;
import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Language;
import com.pathfindersdk.basics.RacialTrait;
import com.pathfindersdk.basics.SaveType;
import com.pathfindersdk.basics.Size;
import com.pathfindersdk.basics.SpeedType;
import com.pathfindersdk.basics.Vision;
import com.pathfindersdk.bonus.AbilityBonusStrategy;
import com.pathfindersdk.bonus.ArmorBonusStrategy;
import com.pathfindersdk.bonus.AttackBonusStrategy;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.BonusType;
import com.pathfindersdk.bonus.CmdBonusStrategy;
import com.pathfindersdk.bonus.SaveBonusStrategy;
import com.pathfindersdk.bonus.SkillBonusStrategy;
import com.pathfindersdk.bonus.SkillRankBonusStrategy;
import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookSection;
import com.pathfindersdk.books.BookSectionType;
import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.stats.AbilityType;
import com.pathfindersdk.stats.SpeedStat;
/**
* This class builds the Core Rulebook content and returns the book.
*/
public class CoreRulebookBuilder extends BookBuilder
{

  @Override
  protected void addRaces(Book book)
  {
    BookSection races = new BookSection(BookSectionType.RACES);
    
    RaceItem race;
    CreatureType type;
    RacialTrait trait;
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.DWARF);
    race = new RaceItem("Dwarf", type, Size.MEDIUM);
    race.addVision(Vision.DARKVISION);
    race.addSpeed(new SpeedStat(20, SpeedType.BASE));
    race.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.CON)));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.WIS)));
    race.addBonus(new Bonus(-2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.CHA)));
    race.addBaseLanguage(Language.COMMON);
    race.addBaseLanguage(Language.DWARVEN);
    race.addOptionalLanguage(Language.GIANT);
    race.addOptionalLanguage(Language.GNOME);
    race.addOptionalLanguage(Language.GOBLIN);
    race.addOptionalLanguage(Language.ORC);
    race.addOptionalLanguage(Language.TERRAN);
    race.addOptionalLanguage(Language.UNDERCOMMON);
    trait = new RacialTrait("Slow and Steady");
    // TODO: Find a way to make armor speed constant
    race.addTrait(trait);
    trait = new RacialTrait("Defensive Training");
    trait.addBonus(new Bonus(4, BonusType.DODGE, new ArmorBonusStrategy(), "against Giant subtype."));
    race.addTrait(trait);
    trait = new RacialTrait("Greed");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Appraise"), "on nonmagical goods that contain precious metals or gemstones."));
    race.addTrait(trait);
    trait = new RacialTrait("Hatred");
    trait.addBonus(new Bonus(1, BonusType.UNTYPED, new AttackBonusStrategy(), "against humanoid creatures of the orc and goblinoid subtypes."));
    race.addTrait(trait);
    trait = new RacialTrait("Hardy");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.FORTITUDE), "against poison, spells ans spell-like abilities."));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.REFLEX), "against poison, spells ans spell-like abilities."));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.WILL), "against poison, spells ans spell-like abilities."));
    race.addTrait(trait);
    trait = new RacialTrait("Stability");
    trait.addBonus(new Bonus(4, BonusType.RACIAL, new CmdBonusStrategy("Bull Rush")));
    trait.addBonus(new Bonus(4, BonusType.RACIAL, new CmdBonusStrategy("Trip")));
    race.addTrait(trait);
    trait = new RacialTrait("Stonecunning");
    trait.addBonus(new Bonus(2, BonusType.UNTYPED, new SkillBonusStrategy("Perception"), "to notice traps and hidden doors in stone walls or floors."));
    race.addTrait(trait);
    // TODO: Weapon familiarity
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.ELF);
    race = new RaceItem("Elf", type, Size.MEDIUM);
    race.addVision(Vision.LOW_LIGHT);
    race.addSpeed(new SpeedStat(30, SpeedType.BASE));
    race.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.DEX)));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.INT)));
    race.addBonus(new Bonus(-2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.CON)));
    race.addBaseLanguage(Language.COMMON);
    race.addBaseLanguage(Language.ELVEN);
    race.addOptionalLanguage(Language.CELESTIAL);
    race.addOptionalLanguage(Language.DRACONIC);
    race.addOptionalLanguage(Language.GNOLL);
    race.addOptionalLanguage(Language.GNOME);
    race.addOptionalLanguage(Language.GOBLIN);
    race.addOptionalLanguage(Language.ORC);
    race.addOptionalLanguage(Language.SYLVAN);
    trait = new RacialTrait("Elven Immunities");
    // TODO: add immunity to sleep
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.FORTITUDE), "against enchantment spells and effects."));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.REFLEX), "against enchantment spells and effects."));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.WILL), "against enchantment spells and effects."));
    race.addTrait(trait);
    trait = new RacialTrait("Elven Magic");
    // TODO: add bonus to Caster Level vs Spell Resistance
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Spellcraft"), "to identify the properties of magic items."));
    race.addTrait(trait);
    trait = new RacialTrait("Keen Senses");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Perception")));
    race.addTrait(trait);
    // TODO: Weapon familiarity
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.GNOME);
    race = new RaceItem("Gnome", type, Size.SMALL);
    race.addVision(Vision.LOW_LIGHT);
    race.addSpeed(new SpeedStat(20, SpeedType.BASE));
    race.addSpeed(new SpeedStat(15, SpeedType.ARMOR));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.CON)));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.CHA)));
    race.addBonus(new Bonus(-2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.STR)));
    race.addBaseLanguage(Language.COMMON);
    race.addBaseLanguage(Language.GNOME);
    race.addBaseLanguage(Language.SYLVAN);
    race.addOptionalLanguage(Language.DRACONIC);
    race.addOptionalLanguage(Language.DWARVEN);
    race.addOptionalLanguage(Language.ELVEN);
    race.addOptionalLanguage(Language.GIANT);
    race.addOptionalLanguage(Language.GOBLIN);
    race.addOptionalLanguage(Language.ORC);
    trait = new RacialTrait("Defensive Training");
    trait.addBonus(new Bonus(4, BonusType.DODGE, new ArmorBonusStrategy(), "against Giant subtype."));
    race.addTrait(trait);
    trait = new RacialTrait("Gnome Magic");
    // TODO: +1 Save DC to Illusion spells
    // TODO: spell-like abilities with charisma 11 prerequisite
    race.addTrait(trait);
    trait = new RacialTrait("Hatred");
    trait.addBonus(new Bonus(1, BonusType.UNTYPED, new AttackBonusStrategy(), "against humanoid creatures of the reptilian and goblinoid subtypes."));
    race.addTrait(trait);
    trait = new RacialTrait("Illusion Resistance");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.FORTITUDE), "against illusion spells and effects."));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.REFLEX), "against illusion spells and effects."));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.WILL), "against illusion spells and effects."));
    race.addTrait(trait);
    trait = new RacialTrait("Keen Senses");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Perception")));
    race.addTrait(trait);
    trait = new RacialTrait("Obsessive");
    // TODO: +2 to a Craft or a Profession skill <- needs user input to select skill and also subskill
    race.addTrait(trait);
    // TODO: Weapon familiarity
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.ELF);
    type.addSubtype(CreatureSubtype.HUMAN);
    race = new RaceItem("Half-Elf", type, Size.MEDIUM);
    race.addVision(Vision.LOW_LIGHT);
    race.addSpeed(new SpeedStat(30, SpeedType.BASE));
    race.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.ANY)));
    race.addBaseLanguage(Language.COMMON);
    race.addBaseLanguage(Language.ELVEN);
    race.addOptionalLanguage(Language.ABYSSAL);
    race.addOptionalLanguage(Language.AKLO);
    race.addOptionalLanguage(Language.AQUAN);
    race.addOptionalLanguage(Language.AURAN);
    race.addOptionalLanguage(Language.CELESTIAL);
    race.addOptionalLanguage(Language.DRACONIC);
    race.addOptionalLanguage(Language.DWARVEN);
    race.addOptionalLanguage(Language.GIANT);
    race.addOptionalLanguage(Language.GNOLL);
    race.addOptionalLanguage(Language.GNOME);
    race.addOptionalLanguage(Language.GOBLIN);
    race.addOptionalLanguage(Language.HALFLING);
    race.addOptionalLanguage(Language.IGNAN);
    race.addOptionalLanguage(Language.INFERNAL);
    race.addOptionalLanguage(Language.ORC);
    race.addOptionalLanguage(Language.SYLVAN);
    race.addOptionalLanguage(Language.TERRAN);
    race.addOptionalLanguage(Language.UNDERCOMMON);
    trait = new RacialTrait("Adaptability");
    // TODO: add Skill Focus (?) feat
    race.addTrait(trait);
    trait = new RacialTrait("Elven Immunities");
    // TODO: add immunity to sleep
    race.addTrait(trait);
    trait = new RacialTrait("Keen Senses");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Perception")));
    race.addTrait(trait);
    trait = new RacialTrait("Multitalented");
    // TODO: add a 2nd favored class
    race.addTrait(trait);
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    type.addSubtype(CreatureSubtype.ORC);
    race = new RaceItem("Half-Orc", type, Size.MEDIUM);
    race.addVision(Vision.DARKVISION);
    race.addSpeed(new SpeedStat(30, SpeedType.BASE));
    race.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.ANY)));
    race.addBaseLanguage(Language.COMMON);
    race.addBaseLanguage(Language.ORC);
    race.addOptionalLanguage(Language.ABYSSAL);
    race.addOptionalLanguage(Language.DRACONIC);
    race.addOptionalLanguage(Language.GIANT);
    race.addOptionalLanguage(Language.GNOLL);
    race.addOptionalLanguage(Language.GOBLIN);
    trait = new RacialTrait("Intimidating");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Intimidate")));
    race.addTrait(trait);
    trait = new RacialTrait("Orc Ferocity");
    // TODO: add special ability when below 0 HP
    race.addTrait(trait);
    // TODO: Weapon familiarity
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HALFLING);
    race = new RaceItem("Halfling", type, Size.SMALL);
    race.addVision(Vision.NORMAL);
    race.addSpeed(new SpeedStat(20, SpeedType.BASE));
    race.addSpeed(new SpeedStat(15, SpeedType.ARMOR));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.DEX)));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.CHA)));
    race.addBonus(new Bonus(-2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.STR)));
    race.addBaseLanguage(Language.COMMON);
    race.addBaseLanguage(Language.HALFLING);
    race.addOptionalLanguage(Language.DWARVEN);
    race.addOptionalLanguage(Language.ELVEN);
    race.addOptionalLanguage(Language.GNOME);
    race.addOptionalLanguage(Language.GOBLIN);
    trait = new RacialTrait("Fearless");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.FORTITUDE), "against fear. Stacks with Halfling Luck."));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.REFLEX), "against fear. Stacks with Halfling Luck."));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SaveBonusStrategy(SaveType.WILL), "against fear. Stacks with Halfling Luck."));
    race.addTrait(trait);
    trait = new RacialTrait("Halfling Luck");
    trait.addBonus(new Bonus(1, BonusType.RACIAL, new SaveBonusStrategy(SaveType.FORTITUDE)));
    trait.addBonus(new Bonus(1, BonusType.RACIAL, new SaveBonusStrategy(SaveType.REFLEX)));
    trait.addBonus(new Bonus(1, BonusType.RACIAL, new SaveBonusStrategy(SaveType.WILL)));
    race.addTrait(trait);
    trait = new RacialTrait("Keen Senses");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Perception")));
    race.addTrait(trait);
    trait = new RacialTrait("Sure-Footed");
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Acrobatics")));
    trait.addBonus(new Bonus(2, BonusType.RACIAL, new SkillBonusStrategy("Climb")));
    race.addTrait(trait);
    // TODO: Weapon familiarity
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    race = new RaceItem("Human", type, Size.MEDIUM);
    race.addVision(Vision.NORMAL);
    race.addSpeed(new SpeedStat(30, SpeedType.BASE));
    race.addSpeed(new SpeedStat(20, SpeedType.ARMOR));
    race.addBonus(new Bonus(2, BonusType.RACIAL, new AbilityBonusStrategy(AbilityType.ANY)));
    race.addBaseLanguage(Language.COMMON);
    race.addOptionalLanguage(Language.ABYSSAL);
    race.addOptionalLanguage(Language.AKLO);
    race.addOptionalLanguage(Language.AQUAN);
    race.addOptionalLanguage(Language.AURAN);
    race.addOptionalLanguage(Language.CELESTIAL);
    race.addOptionalLanguage(Language.DRACONIC);
    race.addOptionalLanguage(Language.DWARVEN);
    race.addOptionalLanguage(Language.ELVEN);
    race.addOptionalLanguage(Language.GIANT);
    race.addOptionalLanguage(Language.GNOLL);
    race.addOptionalLanguage(Language.GNOME);
    race.addOptionalLanguage(Language.GOBLIN);
    race.addOptionalLanguage(Language.HALFLING);
    race.addOptionalLanguage(Language.IGNAN);
    race.addOptionalLanguage(Language.INFERNAL);
    race.addOptionalLanguage(Language.ORC);
    race.addOptionalLanguage(Language.SYLVAN);
    race.addOptionalLanguage(Language.TERRAN);
    race.addOptionalLanguage(Language.UNDERCOMMON);
    trait = new RacialTrait("Bonus Feat");
    // TODO: Add bonus feat
    race.addTrait(trait);
    trait = new RacialTrait("Skilled");
    trait.addBonus(new Bonus(1, BonusType.UNTYPED, new SkillRankBonusStrategy()));
    race.addTrait(trait);
    races.addItem(race);

    book.addSection(races);
  }

  @Override
  protected void addAlternateRacialTraits(Book book)
  {
    // TODO Auto-generated method stub
    
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
    BookSection skills = new BookSection(BookSectionType.SKILLS);
    
    skills.addItem(new SkillItem("Acrobatics", AbilityType.DEX, true, true));
    skills.addItem(new SkillItem("Appraise", AbilityType.INT, true, false));
    skills.addItem(new SkillItem("Bluff", AbilityType.CHA, true, false));
    skills.addItem(new SkillItem("Climb", AbilityType.STR, true, true));
    skills.addItem(new SkillItem("Craft", AbilityType.INT, true, false));
    skills.addItem(new SkillItem("Diplomacy", AbilityType.CHA, true, false));
    skills.addItem(new SkillItem("Disable Device", AbilityType.DEX, false, true));
    skills.addItem(new SkillItem("Disguise", AbilityType.CHA, true, false));
    skills.addItem(new SkillItem("Escape Artist", AbilityType.DEX, true, true));
    skills.addItem(new SkillItem("Fly", AbilityType.DEX, true, true));
    skills.addItem(new SkillItem("Handle Animal", AbilityType.CHA, false, false));
    skills.addItem(new SkillItem("Heal", AbilityType.WIS, true, false));
    skills.addItem(new SkillItem("Intimidate", AbilityType.CHA, true, true));
    skills.addItem(new SkillItem("Knowledge (arcana)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (dungeonneering)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (engineering)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (geography)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (history)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (local)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (nature)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (nobility)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (planes)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Knowledge (religion)", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Linguistics", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Perception", AbilityType.WIS, true, false));
    skills.addItem(new SkillItem("Perform", AbilityType.CHA, true, false));
    skills.addItem(new SkillItem("Profession", AbilityType.WIS, false, false));
    skills.addItem(new SkillItem("Ride", AbilityType.DEX, true, true));
    skills.addItem(new SkillItem("Sense Motive", AbilityType.WIS, true, false));
    skills.addItem(new SkillItem("Sleight of Hand", AbilityType.DEX, false, true));
    skills.addItem(new SkillItem("Spellcraft", AbilityType.INT, false, false));
    skills.addItem(new SkillItem("Stealth", AbilityType.DEX, true, true));
    skills.addItem(new SkillItem("Survival", AbilityType.WIS, true, false));
    skills.addItem(new SkillItem("Swim", AbilityType.STR, true, true));
    skills.addItem(new SkillItem("Use Magic Device", AbilityType.CHA, false, false));

    book.addSection(skills);
  }

}
