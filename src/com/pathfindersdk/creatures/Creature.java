package com.pathfindersdk.creatures;

import java.util.Hashtable;
import java.util.TreeMap;

import com.pathfindersdk.basics.Alignment;
import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.basics.Feat;
import com.pathfindersdk.basics.Size;
import com.pathfindersdk.basics.SpeedType;
import com.pathfindersdk.stats.AbilityType;
import com.pathfindersdk.stats.SkillStat;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.stats.StatGroup;
import com.pathfindersdk.stats.StatGroupType;


/**
 * This base class contains stats common to every creatures (PCs, NPCs and Monsters).
 */
public abstract class Creature
{
  protected String name;
  protected Alignment alignment;
  protected Hashtable<StatGroupType, StatGroup> statGroups = new Hashtable<StatGroupType, StatGroup>(); 

  protected TreeMap<AbilityType, Stat> stats;
  protected TreeMap<SpeedType, Double> speeds;
  protected TreeMap<String, SkillStat> skills;
  protected TreeMap<String, Feat> feats;
  protected TreeMap<Integer, Class> classes;
  
  public Creature(String name)
  {
    this.name = name;
    
    /*StatGroup group = new AbilityGroup();
    group.addStat(new AbilityStat(10));
    statGroups.put(StatGroupType.ABILITY_SCORES, group);
    stats = new TreeMap<AbilityType, Stat>();
    stats.put(AbilityType.STR, );
    stats.put(AbilityType.DEX, new AbilityStat(10));
    stats.put(AbilityType.CON, new AbilityStat(10));
    stats.put(AbilityType.INT, new AbilityStat(10));
    stats.put(AbilityType.WIS, new AbilityStat(10));
    stats.put(AbilityType.CHA, new AbilityStat(10));*/
    
    //SkillStat acrobatic = new SkillStat();
  }
  
  @Override
  public String toString()
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
  
  public Stat getStat(AbilityType statType)
  {
    return stats.get(statType);
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
    
    skills.put(skill.toString(), skill);
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
    
    feats.put(feat.toString(), feat);
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
