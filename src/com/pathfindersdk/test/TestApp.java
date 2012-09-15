package com.pathfindersdk.test;

import com.pathfindersdk.core.Ability;
import com.pathfindersdk.core.Book;
import com.pathfindersdk.core.Skill;
import com.pathfindersdk.core.SkillType;

public class TestApp
{
  public static void main (String[] args)
  {
    Book coreBook = buildCoreBook();
    
    System.out.println(coreBook.getName());
    System.out.println(coreBook.getSkills().get("Acrobatics").getDescription());
  }
  
  private static Book buildCoreBook()
  {
    Book book = new Book("Core Rulebook");
    
    book.addSkill(new Skill(SkillType.ACROBATICS, "This is a test.", Ability.DEX, true, false));
    
    return book;
  }
}
