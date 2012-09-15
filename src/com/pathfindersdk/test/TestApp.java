package com.pathfindersdk.test;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.core.Ability;
import com.pathfindersdk.core.Book;
import com.pathfindersdk.core.Skill;
import com.pathfindersdk.core.SkillType;

public class TestApp
{
  public static void main (String[] args)
  {
    buildCoreBook("core_rulebook.json");
  }
  
  private static void buildCoreBook(String path)
  {
    Book book = new Book("Core Rulebook");
    
    addCoreSkills(book);
    addCoreFeats(book);
    
    printJson(book, path);
  }
  
  private static void printJson(Book book, String path)
  {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    try 
    {
      FileWriter writer = new FileWriter(path);
      writer.write(gson.toJson(book));
      writer.close();
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  private static void addCoreSkills(Book book)
  {
    book.addSkill(new Skill(SkillType.ACROBATICS,               Ability.DEX, true,  true));
    book.addSkill(new Skill(SkillType.APPRAISE,                 Ability.INT, true,  false));
    book.addSkill(new Skill(SkillType.BLUFF,                    Ability.CHA, true,  false));
    book.addSkill(new Skill(SkillType.CLIMB,                    Ability.STR, true,  true));
    book.addSkill(new Skill(SkillType.CRAFT,                    Ability.INT, true,  false));
    book.addSkill(new Skill(SkillType.DIPLOMACY,                Ability.CHA, true,  false));
    book.addSkill(new Skill(SkillType.DISABLE_DEVICE,           Ability.DEX, false, true));
    book.addSkill(new Skill(SkillType.DISGUISE,                 Ability.CHA, true,  false));
    book.addSkill(new Skill(SkillType.ESCAPE_ARTIST,            Ability.DEX, true,  true));
    book.addSkill(new Skill(SkillType.FLY,                      Ability.DEX, true,  true));
    book.addSkill(new Skill(SkillType.HANDLE_ANIMAL,            Ability.CHA, false, false));
    book.addSkill(new Skill(SkillType.HEAL,                     Ability.WIS, true,  false));
    book.addSkill(new Skill(SkillType.INTIMIDATE,               Ability.CHA, true,  false));
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
    book.addSkill(new Skill(SkillType.PERCEPTION,               Ability.WIS, true,  false));
    book.addSkill(new Skill(SkillType.PERFORM,                  Ability.CHA, true,  false));
    book.addSkill(new Skill(SkillType.PROFESSION,               Ability.WIS, false, false));
    book.addSkill(new Skill(SkillType.RIDE,                     Ability.DEX, true,  true));
    book.addSkill(new Skill(SkillType.SENSE_MOTIVE,             Ability.WIS, true,  false));
    book.addSkill(new Skill(SkillType.SLEIGHT_OF_HAND,          Ability.DEX, false, true));
    book.addSkill(new Skill(SkillType.SPELLCRAFT,               Ability.INT, false, false));
    book.addSkill(new Skill(SkillType.STEALTH,                  Ability.DEX, true,  true));
    book.addSkill(new Skill(SkillType.SURVIVAL,                 Ability.WIS, true,  false));
    book.addSkill(new Skill(SkillType.SWIM,                     Ability.STR, true,  true));
    book.addSkill(new Skill(SkillType.USE_MAGIC_DEVICE,         Ability.CHA, false, false));
  }
  
  private static void addCoreFeats(Book book)
  {
    //book.addFeat();
  }
}
