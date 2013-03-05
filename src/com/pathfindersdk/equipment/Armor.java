package com.pathfindersdk.equipment;

import java.util.ArrayList;

import com.pathfindersdk.enums.ArmorType;
import com.pathfindersdk.enums.BodySlotType;

public class Armor extends BodyEquipment
{
  protected ArmorType type;
  protected Integer ac;
  protected Integer maxDex;
  protected Integer checkPenalty;
  protected Float spellFailure;
  protected ArrayList<Enhancement> enhancements;

  public Armor(String name, ArmorType type, int ac, int maxDex, int checkPenalty, float spellFailure, int cost, int weight)
  {
    super(name, cost, weight, BodySlotType.ARMOR);
    this.type = type;
    this.ac = ac;
    this.maxDex = maxDex;
    this.checkPenalty = checkPenalty;
    this.spellFailure = spellFailure;
  }
  
  public void addEnhancement(Enhancement enhancement)
  {
    if(enhancement != null)
    {
      if(enhancements == null)
        enhancements = new ArrayList<Enhancement>();
      
      enhancement.applyTo(this);
      enhancements.add(enhancement);
    }
  }
  
  public void removeEnhancement(Enhancement enhancement)
  {
    if(enhancements != null)
    {
      if(enhancements.contains(enhancement))
      {
        enhancement.removeFrom(this);
        enhancements.remove(enhancement);
      }
      
      if(enhancements.isEmpty())
        enhancements = null;
    }
  }
  
}
