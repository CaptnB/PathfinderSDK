package com.pathfindersdk.books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.general.Bonus;
import com.pathfindersdk.general.BonusAdapter;
import com.pathfindersdk.general.Prerequisite;
import com.pathfindersdk.general.PrerequisiteAdapter;

public class BookJson
{
  private Gson gson;
  
  public BookJson()
  {
    GsonBuilder builder = new GsonBuilder();
    
    // Register adapters (for polymorphism)
    builder.registerTypeAdapter(Bonus.class, new BonusAdapter());
    builder.registerTypeAdapter(Prerequisite.class, new PrerequisiteAdapter());
    
    // Set output as pretty print
    builder.setPrettyPrinting();
    
    // Instantiate Gson
    gson = builder.create();
  }
  
  public Book read(String path)
  {
    Book book = null;
    
    try
    {
      BufferedReader buffer = new BufferedReader(new FileReader(path));
      book = gson.fromJson(buffer, Book.class);
      book.updateIndexes();
      
      System.out.println(book.getName() + " has been read from [" + path + "]");
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    return book;
  }
  
  public void write(Book book, String path)
  {
    try 
    {
      FileWriter writer = new FileWriter(path);
      writer.write(gson.toJson(book));
      writer.close();
      
      System.out.println(book.getName() + " has been written into [" + path + "]");
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
