package com.pathfindersdk.enums;

/**
 * This enum lists all creature sizes and related space, reach and size bonus.
 */
public enum SizeType
{
  FINE       ("Fine"), 
  DIMINUTIVE ("Diminutive"), 
  TINY       ("Tiny"), 
  SMALL      ("Small"), 
  MEDIUM     ("Medium"), 
  LARGE      ("Large"), 
  HUGE       ("Huge"), 
  GARGANTUAN ("Gargantuan"), 
  COLOSSAL   ("Colossal");

  private final String name;

  private SizeType(String name)
  {
    this.name = name;
  }

  
  public SizeType offset(int offset)
  {
    SizeType size = this;
    
    if(offset > 0)
    {
      for(int i = 0; i < offset; i++)
      {
        switch(size)
        {
        case FINE:
          size = DIMINUTIVE;
          break;
          
        case DIMINUTIVE:
          size = TINY;
          break;
          
        case TINY:
          size = SMALL;
          break;
          
        case SMALL:
          size = MEDIUM;
          break;
          
        case MEDIUM:
          size = LARGE;
          break;
          
        case LARGE:
          size = HUGE;
          break;
          
        case HUGE: 
          size = GARGANTUAN;
          break;
          
        case GARGANTUAN: 
          size = COLOSSAL;
          break;
          
        // Max size reached
        case COLOSSAL: 
        default:
          break;
          
        }
      }
    }
    else if(offset < 0)
    {
      for(int i = 0; i < -offset; i++)
      {
        switch(size)
        {
        case COLOSSAL:
          size = GARGANTUAN;
          break;
          
        case GARGANTUAN: 
          size = HUGE;
          break;
          
        case HUGE: 
          size = LARGE;
          break;
          
        case LARGE:
          size = MEDIUM;
          break;
          
        case MEDIUM:
          size = SMALL;
          break;
          
        case SMALL:
          size = TINY;
          break;
          
        case TINY:
          size = DIMINUTIVE;
          break;
          
        case DIMINUTIVE:
          size = FINE;
          break;
                    
        // Min size reached
        case FINE:
        default:
          break;
          
        }
      }
    }
    
    return size;
  }

  @Override
  public String toString()
  {
    return name;
  }
}
