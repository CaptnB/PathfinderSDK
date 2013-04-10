package com.pathfindersdk.utils;

final public class ArgChecker
{
  
  static public void checkNotNull(Object obj)
  {
    if(obj == null)
      throw new IllegalArgumentException("Argument can't be null!");
  }
  
  static public void checkNotEmpty(String string)
  {
    if("".equals(string))
      throw new IllegalArgumentException("String can't be empty!");
  }
  
  static public void checkInRange(int number, int min, int max)
  {
    if(number < min || number > max)
      throw new IllegalArgumentException(number + " is outside of range [" + min + ", " + max + "]!");
  }
  
  static public void checkIsPositive(int number)
  {
    if(number < 0)
      throw new IllegalArgumentException("Number must be positive!");
  }
  
  static public void checkInRange(double number, double min, double max)
  {
    if(number < min || number > max)
      throw new IllegalArgumentException(number + " is outside of range [" + min + ", " + max + "]!");
  }
  
  static public void checkIsPositive(double number)
  {
    if(number < 0.0)
      throw new IllegalArgumentException("Number must be positive!");
  }
  
  static public void checkIsNot(Object obj, Object isnot)
  {
    if(obj.equals(isnot))
      throw new IllegalArgumentException(isnot.toString() + " is not allowed!");
  }
  
  private ArgChecker(){};
}
