package com.pathfindersdk.test;

import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookFactory;
import com.pathfindersdk.books.BookJson;
import com.pathfindersdk.books.CoreRulebookFactory;


/**
 * The Class TestApp.
 */
public class TestApp
{

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main (String[] args)
  {
    BookJson json = new BookJson();

    BookFactory factory = new CoreRulebookFactory();
    Book coreBook = factory.createBook("Core Rulebook");
    json.write(coreBook, "core_rulebook.json");
    
    /*factory = new AdvancedPlayersGuideFactory();
    Book apgBook = factory.createBook("Advanced Player's Guide");
    json.write(apgBook, "advanced_players_guide.json");*/
    
    /*factory = new BestiaryFactory();
    Book bestiaryBook = factory.createBook("Bestiary");
    json.write(bestiaryBook, "bestiary.json");*/
    
    /*factory = new Bestiary2Factory();
    Book bestiary2Book = factory.createBook("Bestiary 2");
    json.write(bestiary2Book, "bestiary_2.json");*/
    
    /*factory = new Bestiary3Factory();
    Book bestiary3Book = factory.createBook("Bestiary 3");
    json.write(bestiary3Book, "bestiary_3.json");*/
    
    /*factory = new AdvancedRaceGuideFactory();
    Book argBook = factory.createBook("Advanced Race Guide");
    json.write(argBook, "advanced_race_guide.json");*/
    
    /*factory = new UltimateCombatFactory();
    Book ucBook = factory.createBook("Ultimate Combat");
    json.write(ucBook, "ultimate_combat.json");*/
    
    /*factory = new UltimateMagicFactory();
    Book umBook = factory.createBook("Ultimate Magic");
    json.write(umBook, "ultimate_magic.json");*/
  }

}
