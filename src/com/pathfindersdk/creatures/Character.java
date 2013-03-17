package com.pathfindersdk.creatures;



/**
 * This class adds character specific stats on top of creature ones.
 */
public class Character extends Creature
{
  protected Description description;
  protected Race race;

  public Description getDescription()
  {
    return description;
  }

  public void setDescription(Description description)
  {
    if(description != null)
    {
      // Clean previous description
      if(this.description != null)
        this.description.removeFrom(this);
      
      // Apply new one
      if(description != null)
        description.applyTo(this);

      this.description = description;
    }
    else
      throw new IllegalArgumentException("Description can't be null");
  }

  public Race getRace()
  {
    return race;
  }

  public void setRace(Race race)
  {
    if(race != null)
    {
      // Clean current race
      if(this.race != null)
        this.race.removeFrom(this);
      
      // Apply new one
      if(race != null)
        race.applyTo(this);
      
      this.race = race;
    }
    else
      throw new IllegalArgumentException("Race can't be null");
  }
  
  @Override
  public String toString()
  {
    String out = "";
    
    out += name + "\n";
    
    return out;
  }

}
