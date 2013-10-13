package com.pathfindersdk.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.applicables.Feature;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookComponent;
import com.pathfindersdk.coins.Piece;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.equipment.Equipment;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.stats.Stat;

/**
 * This class reads/writes Book objects from/to a JSON file.
 */
public class JsonBook
{
  private static JsonBook instance = new JsonBook();
  private static Gson gson;
  
  private JsonBook()
  {
    GsonBuilder builder = new GsonBuilder();
    
    // Register all adapters here
    builder.registerTypeAdapter(Bonus.class, new JsonAdapter<Bonus>());
    builder.registerTypeAdapter(BookComponent.class, new JsonAdapter<BookComponent>());
    builder.registerTypeAdapter(Piece.class, new JsonAdapter<Piece>());
    builder.registerTypeAdapter(Creature.class, new JsonAdapter<Creature>());
    builder.registerTypeAdapter(Equipment.class, new JsonAdapter<Equipment>());
    
    builder.registerTypeAdapter(Feature.class, new JsonAdapter<Feature>());
    builder.registerTypeAdapter(Prerequisite.class, new JsonAdapter<Prerequisite>());

    builder.registerTypeAdapter(Stat.class, new JsonAdapter<Stat>());
    
    builder.setPrettyPrinting();
    gson = builder.create();
  }
  
  public static Book read(String fileName)
  {
    Book book = null;
    String booksPath = "books\\" + fileName;
    
    try
    {
      BufferedReader buffer = new BufferedReader(new FileReader(booksPath));
      book = gson.fromJson(buffer, Book.class);
      
      System.out.println(book.toString() + " has been read from [" + booksPath + "]");
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    return book;
  }
  
  public static void write(Book book, String fileName)
  {
    String booksPath = "books\\" + fileName;

    try 
    {
      FileWriter writer = new FileWriter(booksPath);
      writer.write(gson.toJson(book));
      writer.close();
      
      System.out.println(book.getTitle() + " has been written into [" + booksPath + "]");
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
