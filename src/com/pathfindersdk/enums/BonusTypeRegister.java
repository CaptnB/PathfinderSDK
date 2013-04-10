package com.pathfindersdk.enums;

import java.util.HashSet;
import java.util.Set;

import com.pathfindersdk.utils.ArgChecker;

/**
 * This singleton is used to register new types of bonus and limits the use of those registered. 
 * Enum are not extensible so with every book adding new types of bonus, new code would need to be written. 
 * A simple String would do the trick but it opens the door to typos (+2 morale and +2 Morale = +4 because different types do stack).
 * This class offers the best of both worlds, it behaves like an extensible enum without allowing any random String.
 * The drawback is the ugliness of the code => BonusTypeRegister.getInstance().get("Morale")
 */
final public class BonusTypeRegister
{
  // This class is purely a wrapper for a String.
  public final class BonusType implements Comparable<BonusType>
  {
    private final String type;
    
    // Can't instantiate BonusType objects outside BonusTypeRegister
    private BonusType(String type)
    {
      this.type = type;
    }
    
    private String getType()
    {
      return type;
    }

    @Override
    public int compareTo(BonusType o)
    {
      return type.compareTo(o.getType());
    }
    
    @Override
    public String toString()
    {
      if(type.equals("Untyped"))
        return "";
      else
        return type;
    }
  }

  private final static BonusTypeRegister instance = new BonusTypeRegister();
  private final Set<BonusType> bonusTypes = new HashSet<BonusType>();
  
  private BonusTypeRegister()
  {
    // Each book can register more bonus types but make sure the basics are covered by default.
    register("Armor");
    register("Deflection");
    register("Dodge");
    register("Enhancement");
    register("Insight");
    register("Luck");
    register("Morale");
    register("Natural Armor");
    register("Profane");
    register("Racial");
    register("Sacred");
    register("Shield");
    register("Size");
    register("Untyped");
  }

  public static BonusTypeRegister getInstance()
  {
    return instance;
  }
  
  public void register(String newType)
  {
    ArgChecker.checkNotNull(newType);
    ArgChecker.checkNotEmpty(newType);
    
    // Do not register the same type twice
    for(BonusType bonusType : bonusTypes)
    {
      if(newType.equals(bonusType.getType()))
        throw new IllegalArgumentException("Bonus type [" + newType + "] is already registered!");
    }
    
    bonusTypes.add(new BonusType(newType));
  }
  
  public BonusType get(String type)
  {
    ArgChecker.checkNotNull(type);
    ArgChecker.checkNotEmpty(type);
    
    for(BonusType bonusType : bonusTypes)
    {
      if(bonusType.getType().equals(type))
        return bonusType;
    }
    
    throw new IllegalArgumentException(type + " is not a registered bonus type");
  }
  
}
