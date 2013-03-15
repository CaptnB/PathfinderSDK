package com.pathfindersdk.creatures;

import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Stat;

/**
 * This class represents a character race.
 */
public class Race implements Feature<Character>
{
  protected CreatureType type;
  protected Size size;
  protected TreeSet<VisionType> visions;
  protected TreeSet<LanguageType> baseLanguages;
  protected TreeSet<LanguageType> optionalLanguages;
  protected TreeSet<Bonus> bonuses;
  protected Hashtable<SpeedType, Stat> speeds;
  protected TreeSet<RacialTrait> traits;
  
  public Race(String name, CreatureType type, SizeType size)
  {
    //super(name);
    this.type = type;
    this.size = new Size(size);
  }
  
  public CreatureType getType()
  {
    return type;
  }
  
  public Size getSize()
  {
    return size;
  }
  
  public void setSize(Size size)
  {
    this.size = size;
  }
  
  public void addVision(VisionType vision)
  {
    if(visions == null)
      visions = new TreeSet<VisionType>();
    
    visions.add(vision);
  }

  public Stat getSpeed(SpeedType type)
  {
    if(speeds != null)
      return speeds.get(type);
    else
      return null;
  }
  
  public void addSpeed(SpeedType type, Stat speed)
  {
    if(speed != null)
    {
      if(speeds == null)
        speeds = new Hashtable<SpeedType, Stat>();
      
      speeds.put(type, speed);
    }
  }
  
  public void removeSpeed(SpeedType type, Stat speed)
  {
    if(speeds != null)
    {
      speeds.remove(type);
      
      if(speeds.isEmpty())
        speeds = null;
    }
  }
  
  public void addBaseLanguage(LanguageType language)
  {
    if(baseLanguages == null)
      baseLanguages = new TreeSet<LanguageType>();
    
    baseLanguages.add(language);
  }
  
  public void addOptionalLanguage(LanguageType language)
  {
    if(optionalLanguages == null)
      optionalLanguages = new TreeSet<LanguageType>();
    
    optionalLanguages.add(language);
  }
  
  public void addBonus(Bonus bonus)
  {
    if(bonuses == null)
      bonuses = new TreeSet<Bonus>();
    
    bonuses.add(bonus);
  }
  
  public void addTrait(RacialTrait trait)
  {
    if(traits == null)
      traits = new TreeSet<RacialTrait>();
    
    traits.add(trait);
  }

  @Override
  public void applyTo(Character character)
  {
    for(Bonus bonus : bonuses)
      bonus.applyTo(character);
  }

  @Override
  public void removeFrom(Character character)
  {
    for(Bonus bonus : bonuses)
      bonus.removeFrom(character);
  }
  
  @Override
  public String toString()
  {
    String out = "";
    
    //out += "Race : " + (getName() != null ? getName() : "NULL") + "\n";
    out += "Creature type : " + (getType() != null ? getType().toString() : "NULL") + "\n";
    out += "Size : " + (getSize() != null ? getSize().toString() : "NULL") + "\n";
    if(visions != null)
    {
      if(!visions.isEmpty())
      {
        out += "Visions : ";
        for(VisionType vision : visions)
        {
          out += vision.toString();
          if(vision != visions.last())
            out += ", ";
        }
        out += "\n";
      }
      else
        out += "Visions : EMPTY\n";
    }
    else
      out += "Visions : NULL\n";

    if(baseLanguages != null)
    {
      if(!baseLanguages.isEmpty())
      {
        out += "Base languages : ";
        for(LanguageType language : baseLanguages)
        {
          out += language.toString();
          if(language != baseLanguages.last())
            out += ", ";
        }
        out += "\n";
      }
      else
        out += "Base languages : EMPTY\n";
    }
    else
      out += "Base languages : NULL\n";

    if(optionalLanguages != null)
    {
      if(!optionalLanguages.isEmpty())
      {
        out += "Optional languages : ";
        for(LanguageType language : optionalLanguages)
        {
          out += language.toString();
          if(language != optionalLanguages.last())
            out += ", ";
        }
        out += "\n";
      }
      else
        out += "Optional languages : EMPTY\n";
    }
    else
      out += "Optional languages : NULL\n";
    
    if(speeds != null)
    {
      if(!speeds.isEmpty())
      {
        out += "Speeds :\n";
        Set<SpeedType> keys = speeds.keySet();
        for(SpeedType type : keys)
          out += "  " + speeds.get(type).toString() + "\n";
      }
      else
        out += "Speeds : EMPTY\n";
    }
    else
      out += "Speeds : NULL\n";
    
    if(bonuses != null)
    {
      if(!bonuses.isEmpty())
      {
        out += "Bonuses : ";
        for(Bonus bonus : bonuses)
        {
          out += bonus.toString();
          if(bonus != bonuses.last())
            out += ", ";
        }
        out += "\n";
      }
      else
        out += "Bonuses : EMPTY\n";
    }
    else
      out += "Bonuses : NULL\n";
    
    if(traits != null)
    {
      if(!traits.isEmpty())
      {
        out += "Traits : ";
        for(RacialTrait trait : traits)
        {
          out += trait.toString();
          if(trait != traits.last())
            out += ", ";
        }
        out += "\n";
      }
      else
        out += "Traits : EMPTY\n";
    }
    else
      out += "Traits : NULL\n";

    return out;
  }
}
