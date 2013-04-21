package com.pathfindersdk.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil
{
  private static JsonUtil instance = new JsonUtil();
  private static Gson gson;
  private static GsonBuilder builder = new GsonBuilder();
  private static List<Type> registeredTypes = new ArrayList<Type>();
  
  private JsonUtil(){}
  
  public static void registerType(Type newType)
  {
    registeredTypes.add(newType);
    
    for(Type type : registeredTypes)
    {
//      builder.r
//      builder.registerTypeAdapter(type, new JsonAdapter<type>());
    }
  }
  
  public static JsonUtil getInstance()
  {
    return instance;
  }
  
  public static void write(Object obj, String fileName)
  {}
}
