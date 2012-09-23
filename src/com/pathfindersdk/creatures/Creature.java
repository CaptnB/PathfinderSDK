package com.pathfindersdk.creatures;

import java.util.TreeMap;

import com.pathfindersdk.basics.Ability;
import com.pathfindersdk.basics.Alignment;
import com.pathfindersdk.basics.Class;
import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Feat;
import com.pathfindersdk.basics.Size;
import com.pathfindersdk.basics.SpeedType;
import com.pathfindersdk.stats.AbilityStat;
import com.pathfindersdk.stats.SkillStat;


/**
 * This base class contains stats common to every creatures (PCs, NPCs and Monsters).
 */
public abstract class Creature
{
  private String name;
  private Alignment alignment;
  private TreeMap<Ability, AbilityStat> abilities = new TreeMap<Ability, AbilityStat>();
  private TreeMap<SpeedType, Double> speeds;
  private TreeMap<String, SkillStat> skills;
  private TreeMap<String, Feat> feats;
  private TreeMap<Integer, Class> classes;
  
  public Creature(String name)
  {
    this.name = name;
    
    abilities.put(Ability.STR, new AbilityStat(10));
    abilities.put(Ability.DEX, new AbilityStat(10));
    abilities.put(Ability.CON, new AbilityStat(10));
    abilities.put(Ability.INT, new AbilityStat(10));
    abilities.put(Ability.WIS, new AbilityStat(10));
    abilities.put(Ability.CHA, new AbilityStat(10));
    
    //SkillStat acrobatic = new SkillStat();
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public Alignment getAlignment()
  {
    return alignment;
  }
  
  public void setAlignment(Alignment alignment)
  {
    this.alignment = alignment;
  }
  
  public AbilityStat getAbility(Ability ability)
  {
    return abilities.get(ability);
  }
  
  public Double getSpeed(SpeedType speed)
  {
    return speeds.get(speed);
  }
  
  public void addSpeed(Double speed, SpeedType type)
  {
    if(speeds == null)
      speeds = new TreeMap<SpeedType, Double>();
    
    speeds.put(type, speed);
  }
  
  public void removeSpeed(SpeedType type)
  {
    if(speeds != null)
    {
      speeds.remove(type);
      
      if(speeds.isEmpty())
        speeds = null;
    }
  }
  
  public void addSkill(SkillStat skill)
  {
    if(skill == null)
      return;
    
    if(skills == null)
      skills = new TreeMap<String, SkillStat>();
    
    skills.put(skill.getName(), skill);
  }
  
  public void removeSkill(SkillStat skill)
  {
    if(skills != null)
    {
      skills.remove(skill);
      
      if(skills.isEmpty())
        skills = null;
    }
  }
  
  public SkillStat getSkill(String name)
  {
    return skills.get(name);
  }
  
  public void addFeat(Feat feat)
  {
    if(feat == null)
      return;
    
    if(feats == null)
      feats = new TreeMap<String, Feat>();
    
    feats.put(feat.getName(), feat);
  }
  
  public void removeFeat(Feat feat)
  {
    if(feats != null)
    {
      feats.remove(feat);
      
      if(feats.isEmpty())
        feats = null;
    }
  }
  
  public Feat getFeat(String name)
  {
    return feats.get(name);
  }
  
  public void addClass(Class aClass)
  {
    if(classes == null)
      classes = new TreeMap<Integer, Class>();
    
    classes.put(classes.size(), aClass);
  }
  
  public void removeClass(Class aClass)
  {
    if(classes != null)
    {
      classes.remove(aClass);
      
      if(classes.isEmpty())
        classes = null;
    }
  }
  
  public Class getClass(int level)
  {
    return classes.get(level);
  }
  
  public Integer getLevel()
  {
    return classes.size();
  }

  public abstract Size getSize();
  public abstract CreatureType getCreatureType();
}
