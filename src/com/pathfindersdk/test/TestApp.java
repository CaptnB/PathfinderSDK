package com.pathfindersdk.test;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookFactory;
import com.pathfindersdk.books.CoreBookFactory;

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
  }
  
  /**
   * Writes the book using json.
   *
   * @param book the book
   * @param path the path
   */
  private static void writeJson(Book book, String path)
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
    
    System.out.println(book.getName() + " has been written into [" + path + "]");
  }

}
