package com.pathfindersdk.books.items;

import java.util.ArrayList;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.RacialTrait;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.stats.Speed;

/**
 * This class represents a character race.
 */
public class Race extends BookItem
{
  protected CreatureType type;
  protected SizeType size;
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
    this.size = size;
  }
  
  public CreatureType getType()
  {
    return type;
  }
  
  public SizeType getSize()
  {
    return size;
  }
  
  public void setSize(SizeType size)
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
  public void applyTo(Creature creature)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeFrom(Creature creature)
  {
    // TODO Auto-generated method stub
    
  }
  
}
