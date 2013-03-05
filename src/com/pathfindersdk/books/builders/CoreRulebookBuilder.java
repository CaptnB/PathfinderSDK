package com.pathfindersdk.books.builders;

import com.pathfindersdk.basics.ClassItem;
import com.pathfindersdk.basics.ClassLevel;
import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Dice;
import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookSection;
import com.pathfindersdk.books.items.Race;
import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.enums.CreatureMainType;
import com.pathfindersdk.enums.CreatureSubtype;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.stats.Speed;
/**
* This class builds the Core Rulebook content and returns the book.
*/
public class CoreRulebookBuilder extends BookBuilder
{

  @Override
  protected void addRaces(Book book)
  {
    BookSection races = new BookSection(BookSectionType.RACES);
    
    Race race;
    CreatureType type;
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.DWARF);
    race = new Race("Dwarf", type, SizeType.MEDIUM);
    race.addVision(VisionType.DARKVISION);
    race.addSpeed(new Speed(20, SpeedType.BASE));
    race.addSpeed(new Speed(20, SpeedType.ARMOR));
    race.addBaseLanguage(LanguageType.COMMON);
    race.addBaseLanguage(LanguageType.DWARVEN);
    race.addOptionalLanguage(LanguageType.GIANT);
    race.addOptionalLanguage(LanguageType.GNOME);
    race.addOptionalLanguage(LanguageType.GOBLIN);
    race.addOptionalLanguage(LanguageType.ORC);
    race.addOptionalLanguage(LanguageType.TERRAN);
    race.addOptionalLanguage(LanguageType.UNDERCOMMON);
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.ELF);
    race = new Race("Elf", type, SizeType.MEDIUM);
    race.addVision(VisionType.LOW_LIGHT);
    race.addSpeed(new Speed(30, SpeedType.BASE));
    race.addSpeed(new Speed(20, SpeedType.ARMOR));
    race.addBaseLanguage(LanguageType.COMMON);
    race.addBaseLanguage(LanguageType.ELVEN);
    race.addOptionalLanguage(LanguageType.CELESTIAL);
    race.addOptionalLanguage(LanguageType.DRACONIC);
    race.addOptionalLanguage(LanguageType.GNOLL);
    race.addOptionalLanguage(LanguageType.GNOME);
    race.addOptionalLanguage(LanguageType.GOBLIN);
    race.addOptionalLanguage(LanguageType.ORC);
    race.addOptionalLanguage(LanguageType.SYLVAN);
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.GNOME);
    race = new Race("Gnome", type, SizeType.SMALL);
    race.addVision(VisionType.LOW_LIGHT);
    race.addSpeed(new Speed(20, SpeedType.BASE));
    race.addSpeed(new Speed(15, SpeedType.ARMOR));
    race.addBaseLanguage(LanguageType.COMMON);
    race.addBaseLanguage(LanguageType.GNOME);
    race.addBaseLanguage(LanguageType.SYLVAN);
    race.addOptionalLanguage(LanguageType.DRACONIC);
    race.addOptionalLanguage(LanguageType.DWARVEN);
    race.addOptionalLanguage(LanguageType.ELVEN);
    race.addOptionalLanguage(LanguageType.GIANT);
    race.addOptionalLanguage(LanguageType.GOBLIN);
    race.addOptionalLanguage(LanguageType.ORC);
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.ELF);
    type.addSubtype(CreatureSubtype.HUMAN);
    race = new Race("Half-Elf", type, SizeType.MEDIUM);
    race.addVision(VisionType.LOW_LIGHT);
    race.addSpeed(new Speed(30, SpeedType.BASE));
    race.addSpeed(new Speed(20, SpeedType.ARMOR));
    race.addBaseLanguage(LanguageType.COMMON);
    race.addBaseLanguage(LanguageType.ELVEN);
    race.addOptionalLanguage(LanguageType.ABYSSAL);
    race.addOptionalLanguage(LanguageType.AKLO);
    race.addOptionalLanguage(LanguageType.AQUAN);
    race.addOptionalLanguage(LanguageType.AURAN);
    race.addOptionalLanguage(LanguageType.CELESTIAL);
    race.addOptionalLanguage(LanguageType.DRACONIC);
    race.addOptionalLanguage(LanguageType.DWARVEN);
    race.addOptionalLanguage(LanguageType.GIANT);
    race.addOptionalLanguage(LanguageType.GNOLL);
    race.addOptionalLanguage(LanguageType.GNOME);
    race.addOptionalLanguage(LanguageType.GOBLIN);
    race.addOptionalLanguage(LanguageType.HALFLING);
    race.addOptionalLanguage(LanguageType.IGNAN);
    race.addOptionalLanguage(LanguageType.INFERNAL);
    race.addOptionalLanguage(LanguageType.ORC);
    race.addOptionalLanguage(LanguageType.SYLVAN);
    race.addOptionalLanguage(LanguageType.TERRAN);
    race.addOptionalLanguage(LanguageType.UNDERCOMMON);
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    type.addSubtype(CreatureSubtype.ORC);
    race = new Race("Half-Orc", type, SizeType.MEDIUM);
    race.addVision(VisionType.DARKVISION);
    race.addSpeed(new Speed(30, SpeedType.BASE));
    race.addSpeed(new Speed(20, SpeedType.ARMOR));
    race.addBaseLanguage(LanguageType.COMMON);
    race.addBaseLanguage(LanguageType.ORC);
    race.addOptionalLanguage(LanguageType.ABYSSAL);
    race.addOptionalLanguage(LanguageType.DRACONIC);
    race.addOptionalLanguage(LanguageType.GIANT);
    race.addOptionalLanguage(LanguageType.GNOLL);
    race.addOptionalLanguage(LanguageType.GOBLIN);
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HALFLING);
    race = new Race("Halfling", type, SizeType.SMALL);
    race.addVision(VisionType.NORMAL);
    race.addSpeed(new Speed(20, SpeedType.BASE));
    race.addSpeed(new Speed(15, SpeedType.ARMOR));
    race.addBaseLanguage(LanguageType.COMMON);
    race.addBaseLanguage(LanguageType.HALFLING);
    race.addOptionalLanguage(LanguageType.DWARVEN);
    race.addOptionalLanguage(LanguageType.ELVEN);
    race.addOptionalLanguage(LanguageType.GNOME);
    race.addOptionalLanguage(LanguageType.GOBLIN);
    races.addItem(race);
    
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    race = new Race("Human", type, SizeType.MEDIUM);
    race.addVision(VisionType.NORMAL);
    race.addSpeed(new Speed(30, SpeedType.BASE));
    race.addSpeed(new Speed(20, SpeedType.ARMOR));
    race.addBaseLanguage(LanguageType.COMMON);
    race.addOptionalLanguage(LanguageType.ABYSSAL);
    race.addOptionalLanguage(LanguageType.AKLO);
    race.addOptionalLanguage(LanguageType.AQUAN);
    race.addOptionalLanguage(LanguageType.AURAN);
    race.addOptionalLanguage(LanguageType.CELESTIAL);
    race.addOptionalLanguage(LanguageType.DRACONIC);
    race.addOptionalLanguage(LanguageType.DWARVEN);
    race.addOptionalLanguage(LanguageType.ELVEN);
    race.addOptionalLanguage(LanguageType.GIANT);
    race.addOptionalLanguage(LanguageType.GNOLL);
    race.addOptionalLanguage(LanguageType.GNOME);
    race.addOptionalLanguage(LanguageType.GOBLIN);
    race.addOptionalLanguage(LanguageType.HALFLING);
    race.addOptionalLanguage(LanguageType.IGNAN);
    race.addOptionalLanguage(LanguageType.INFERNAL);
    race.addOptionalLanguage(LanguageType.ORC);
    race.addOptionalLanguage(LanguageType.SYLVAN);
    race.addOptionalLanguage(LanguageType.TERRAN);
    race.addOptionalLanguage(LanguageType.UNDERCOMMON);
    races.addItem(race);

    book.addSection(races);
  }

  @Override
  protected void addAlternateRacialTraits(Book book)
  {
    // Core Rulebook doesn't contain any alternate racial traits
  }

  @Override
  protected void addClasses(Book book)
  {
    BookSection classes = new BookSection(BookSectionType.CLASSES);
    
    ClassItem classItem;
    ClassLevel level;
    
    classItem = new ClassItem("Barbarian", new Dice(1, 12), 4);
    level = new ClassLevel(1, 2, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Bard", new Dice(1, 8), 6);
    level = new ClassLevel(0, 0, 2, 2);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Cleric", new Dice(1, 8), 2);
    level = new ClassLevel(0, 2, 0, 2);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Druid", new Dice(1, 8), 4);
    level = new ClassLevel(0, 2, 0, 2);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Fighter", new Dice(1, 10), 2);
    level = new ClassLevel(1, 2, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 0);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Monk", new Dice(1, 8), 4);
    level = new ClassLevel(0, 2, 2, 2);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Paladin", new Dice(1, 10), 2);
    level = new ClassLevel(1, 2, 0, 2);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Ranger", new Dice(1, 10), 6);
    level = new ClassLevel(1, 2, 2, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 0);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Rogue", new Dice(1, 8), 8);
    level = new ClassLevel(0, 0, 2, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 1, 0);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Sorcerer", new Dice(1, 8), 2);
    level = new ClassLevel(0, 0, 0, 2);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    classes.addItem(classItem);
    
    classItem = new ClassItem("Wizard", new Dice(1, 6), 2);
    level = new ClassLevel(0, 0, 0, 2);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 1, 1, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 1, 1, 1);
    classItem.addClassLevel(level);
    level = new ClassLevel(0, 0, 0, 0);
    classItem.addClassLevel(level);
    level = new ClassLevel(1, 0, 0, 1);
    classItem.addClassLevel(level);
    classes.addItem(classItem);

    book.addSection(classes);
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
