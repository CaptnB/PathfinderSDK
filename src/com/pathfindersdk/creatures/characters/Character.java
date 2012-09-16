package com.pathfindersdk.creatures.characters;

import java.util.ArrayList;

import com.pathfindersdk.classes.Class;
import com.pathfindersdk.feats.Feat;
import com.pathfindersdk.skills.SkillRank;
import com.pathfindersdk.skills.SkillType;

/**
 * The Class Character.
 */
public class Character
{
  
  /** The skill ranks. */
  private ArrayList<SkillRank> skillRanks = new ArrayList<SkillRank>();
  
  /** The feats. */
  private ArrayList<Feat> feats = new ArrayList<Feat>();
  
  /** The classes. */
  private ArrayList<Class> classes = new ArrayList<Class>();
  
  public Integer getLevel()
  {
    return classes.size();
  }
  
  /**
   * Adds the class.
   *
   * @param newClass the new class
   */
  public void addClass(Class newClass)
  {
    newClass.add(this);
  }
  
  /**
   * Removes the last class.
   */
  public void removeLastClass()
  {
    classes.get(classes.size() - 1).remove(this);
  }
  
  /**
   * Gets the skill.
   *
   * @param skillType the skill type
   * @return the skill
   */
  public SkillRank getSkill(SkillType skillType)
  {
    for(SkillRank skillRank : skillRanks)
    {
      if(skillRank.getSkill().getType() == skillType)
        return skillRank;
    }
    
    return null;
  }
  
  /**
   * Gets the feat.
   *
   * @param featName the feat name
   * @return the feat
   */
  public Feat getFeat(String featName)
  {
    for(Feat feat : feats)
    {
      if(feat.getName().compareTo(featName) == 0)
        return feat;
    }
    
    return null;
  }
}
