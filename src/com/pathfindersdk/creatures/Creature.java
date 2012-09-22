package com.pathfindersdk.creatures;

import java.util.TreeMap;

import com.pathfindersdk.bonus.AbilityStat;
import com.pathfindersdk.bonus.SkillStat;


/**
 * The Class Character.
 */
public abstract class Creature
{
  private String name;
  private Alignment alignment;
  private TreeMap<Ability, AbilityStat> abilities = new TreeMap<Ability, AbilityStat>();;
  
  private TreeMap<String, SkillStat> skills;
  private TreeMap<String, Feat> feats;
  private TreeMap<Integer, Class> classes;
  
  public Integer getLevel()
  {
    return classes.size();
  }
  
  public Creature(String name, Alignment alignment)
  {
    this.name = name;
    this.alignment = alignment;
    
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
  
  public Alignment getAlignment()
  {
    return alignment;
  }
  
  public AbilityStat getAbility(Ability ability)
  {
    return abilities.get(ability);
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
  
  public abstract Size getSize();
}
