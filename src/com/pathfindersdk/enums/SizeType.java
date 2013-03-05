package com.pathfindersdk.enums;

/**
 * This enum lists all creature sizes and related space, reach and size bonus.
 */
public enum SizeType
{
  FINE            ("Fine", 8, 0.5, 0.0), 
  DIMINUTIVE      ("Diminutive", 4, 1.0, 0.0), 
  TINY            ("Tiny", 2, 2.5, 0.0), 
  SMALL           ("Small", 1, 5.0, 5.0), 
  MEDIUM          ("Medium", 0, 5.0, 5.0), 
  LARGE_TALL      ("Large (tall)", -1, 10.0, 10.0), 
  LARGE_LONG      ("Large (long)", -1, 10.0, 5.0), 
  HUGE_TALL       ("Huge (tall)", -2, 15.0, 15.0), 
  HUGE_LONG       ("Huge (long)", -2, 15.0, 10.0), 
  GARGANTUAN_TALL ("Gargantuan (tall)", -4, 20.0, 20.0), 
  GARGANTUAN_LONG ("Gargantuan (long)", -4, 20.0, 15.0), 
  COLOSSAL_TALL   ("Colossal (tall)", -8, 30.0, 30.0), 
  COLOSSAL_LONG   ("Colossal (long)", -8, 30.0, 20.0);

  private final String name;

  private final Integer modifier;
  private final Double space;
  private final Double reach;

  private SizeType(String name, int modifier, double space, double reach)
  {
    this.name = name;
    this.modifier = modifier;
    this.space = space;
    this.reach = reach;
  }

  public Integer getSizeBonus()
  {
    return modifier;
  }

  public Integer getCmbBonus()
  {
    return -modifier;
  }

  public Double getSpace()
  {
    return space;
  }

  public Double getReach()
  {
    return reach;
  }
  
  public SizeType offset(int offset, boolean biped)
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
          if(biped)
            size = LARGE_TALL;
          else
            size = LARGE_LONG;
          break;
          
        case LARGE_TALL:
          size = HUGE_TALL;
          break;
          
        case LARGE_LONG: 
          size = HUGE_LONG;
          break;
          
        case HUGE_TALL: 
          size = GARGANTUAN_TALL;
          break;
          
        case HUGE_LONG: 
          size = GARGANTUAN_LONG;
          break;
          
        case GARGANTUAN_TALL: 
          size = COLOSSAL_TALL;
          break;
          
        case GARGANTUAN_LONG: 
          size = COLOSSAL_LONG;
          break;
        
        // Max size reached
        case COLOSSAL_TALL: 
        case COLOSSAL_LONG:
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
        case COLOSSAL_TALL:
          size = GARGANTUAN_TALL;
          break;
          
        case COLOSSAL_LONG:
          size = GARGANTUAN_LONG;
          break;
          
        case GARGANTUAN_TALL: 
          size = HUGE_TALL;
          break;
          
        case GARGANTUAN_LONG: 
          size = HUGE_LONG;
          break;

        case HUGE_TALL: 
          size = LARGE_TALL;
          break;
          
        case HUGE_LONG: 
          size = LARGE_LONG;
          break;
          
        case LARGE_TALL:
        case LARGE_LONG: 
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
