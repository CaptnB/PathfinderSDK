package com.pathfindersdk.books.items;

import java.util.ArrayList;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Language;
import com.pathfindersdk.basics.RacialTrait;
import com.pathfindersdk.basics.Size;
import com.pathfindersdk.basics.Vision;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.stats.SpeedStat;

/**
 * This class represents a character race.
 */
public class RaceItem extends BookItem
{
  protected CreatureType type;
  protected Size size;
  protected ArrayList<Vision> visions;
  protected ArrayList<Language> baseLanguages;
  protected ArrayList<Language> optionalLanguages;
  protected ArrayList<Bonus> bonuses;
  protected ArrayList<SpeedStat> speeds;
  protected ArrayList<RacialTrait> traits;
  
  public RaceItem(String name, CreatureType type, Size size)
  {
    super(name);
    this.type = type;
    this.size = size;
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
  
  public void addVision(Vision vision)
  {
    if(visions == null)
      visions = new ArrayList<Vision>();
    
    visions.add(vision);
  }
  
  public void addSpeed(SpeedStat speed)
  {
    if(speeds == null)
      speeds = new ArrayList<SpeedStat>();
    
    speeds.add(speed);
  }
  
  public void addBaseLanguage(Language language)
  {
    if(baseLanguages == null)
      baseLanguages = new ArrayList<Language>();
    
    baseLanguages.add(language);
  }
  
  public void addOptionalLanguage(Language language)
  {
    if(optionalLanguages == null)
      optionalLanguages = new ArrayList<Language>();
    
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
