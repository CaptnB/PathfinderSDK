package com.pathfindersdk.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookFactory;
import com.pathfindersdk.books.CoreBookFactory;
import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.BonusAdapter;
import com.pathfindersdk.general.Prerequisite;
import com.pathfindersdk.general.PrerequisiteAdapter;

/**
 * The Class TestApp.
 */
public class TestApp
{
  
  /** The gson. */
  private static Gson gson;
  
  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main (String[] args)
  {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Bonus.class, new BonusAdapter());
    builder.registerTypeAdapter(Prerequisite.class, new PrerequisiteAdapter());
    builder.setPrettyPrinting();
    gson = builder.create();
    
    buildCoreBook("core_rulebook.json");
  }

  
  /**
   * Builds the core book.
   *
   * @param path book file path
   */
  private static void buildCoreBook(String path)
  {
    BookFactory factory = new CoreBookFactory();
    Book coreBook = factory.createBook("Core Rulebook");
    
    writeJson(coreBook, "core_rulebook.json");
    
    //Book testBook = readJson("core_rulebook.json");
    //writeJson(testBook, "test.json");
  }
  
  /**
   * Writes the book using json.
   *
   * @param book the book
   * @param path the path
   */
  private static void writeJson(Book book, String path)
  {
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
    
    System.out.println(book.getName() + " has been written into [" + path + "]");
  }
  
  /**
   * Read json.
   *
   * @param path the path
   * @return the book
   */
  private static Book readJson(String path)
  {
    Book book = null;
    
    try {
   
      BufferedReader br = new BufferedReader(
        new FileReader(path));
   
      //convert the json string back to object
      book = gson.fromJson(br, Book.class);
   
      System.out.println(book.getName() + " has been read from [" + path + "]");
   
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return book;
  }

}
