package com.pathfindersdk.test;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookFactory;
import com.pathfindersdk.books.CoreBookFactory;

public class TestApp
{
  public static void main (String[] args)
  {
    buildCoreBook("core_rulebook.json");
  }
  
  private static void buildCoreBook(String path)
  {
    BookFactory factory = new CoreBookFactory();
    Book coreBook = factory.createBook("Core Rulebook");
    
    printJson(coreBook, "core_rulebook.json");
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
    
    System.out.println(book.getName() + " has been written into [" + path + "]");
  }

}
