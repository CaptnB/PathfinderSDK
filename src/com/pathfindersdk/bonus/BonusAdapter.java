package com.pathfindersdk.bonus;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * The Class BonusAdapter.
 */
public class BonusAdapter implements JsonSerializer<Bonus>,
    JsonDeserializer<Bonus>
{

  /* (non-Javadoc)
   * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
   */
  @Override
  public JsonElement serialize(Bonus bonus, Type type,
      JsonSerializationContext context)
  {
    JsonObject retValue = new JsonObject();
    String className = bonus.getClass().getCanonicalName();
    retValue.addProperty("CLASSNAME", className);
    JsonElement elem = context.serialize(bonus); 
    retValue.add("INSTANCE", elem);
    return retValue;
  }

  /* (non-Javadoc)
   * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
   */
  @Override
  public Bonus deserialize(JsonElement element, Type type,
      JsonDeserializationContext context) throws JsonParseException
  {
    JsonObject jsonObject =  element.getAsJsonObject();
    JsonPrimitive prim = (JsonPrimitive) jsonObject.get("CLASSNAME");
    String className = prim.getAsString();

    Class<?> klass = null;
    try {
        klass = Class.forName(className);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new JsonParseException(e.getMessage());
    }
    return context.deserialize(jsonObject.get("INSTANCE"), klass);
  }

}
