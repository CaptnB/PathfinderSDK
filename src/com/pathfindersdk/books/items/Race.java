package com.pathfindersdk.books.items;

import java.util.ArrayList;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.RacialTrait;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Speed;
import com.pathfindersdk.creatures.Character;

/**
 * This class represents a character race.
 */
public class Race extends BookItem implements Feature<Character>
{
  protected CreatureType type;
  protected Size size;
  protected ArrayList<VisionType> visions;
  protected ArrayList<LanguageType> baseLanguages;
  protected ArrayList<LanguageType> optionalLanguages;
  protected ArrayList<Bonus> bonuses;
  protected ArrayList<Speed> speeds;
  protected ArrayList<RacialTrait> traits;
  
  public Race(String name, CreatureType type, SizeType size)
  {
    super(name);
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
      visions = new ArrayList<VisionType>();
    
    visions.add(vision);
  }
  
  public void addSpeed(Speed speed)
  {
    if(speeds == null)
      speeds = new ArrayList<Speed>();
    
    speeds.add(speed);
  }
  
  public void addBaseLanguage(LanguageType language)
  {
    if(baseLanguages == null)
      baseLanguages = new ArrayList<LanguageType>();
    
    baseLanguages.add(language);
  }
  
  public void addOptionalLanguage(LanguageType language)
  {
    if(optionalLanguages == null)
      optionalLanguages = new ArrayList<LanguageType>();
    
    optionalLanguages.add(language);
  }
  
  public void addBonus(Bonus bonus)
  {
    if(bonuses == null)
      bonuses = new ArrayList<Bonus>();
    
    bonuses.add(bonus);
  }
  
  public void addTrait(RacialTrait trait)
  {
    if(traits == null)
      traits = new ArrayList<RacialTrait>();
    
    traits.add(trait);
  }

  @Override
  public void applyTo(Character character)
  {
    character.setRace(this);
  }

  @Override
  public void removeFrom(Character character)
  {
    character.setRace(null);
  }
  
}
