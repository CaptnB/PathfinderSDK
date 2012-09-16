package com.pathfindersdk.creatures.characters;

import java.util.ArrayList;

import com.pathfindersdk.classes.Class;
import com.pathfindersdk.feats.Feat;
import com.pathfindersdk.skills.SkillRank;
import com.pathfindersdk.skills.SkillType;

public class Character
{
  private ArrayList<SkillRank> skillRanks = new ArrayList<SkillRank>();
  private ArrayList<Feat> feats = new ArrayList<Feat>();
  private ArrayList<Class> classes = new ArrayList<Class>();
  
  public Integer getLevel()
  {
    return classes.size();
  }
  
  public void addClass(Class newClass)
  {
    newClass.add(this);
  }
  
  public void removeLastClass()
  {
    classes.get(classes.size() - 1).remove(this);
  }
  
  public SkillRank getSkill(SkillType skillType)
  {
    for(SkillRank skillRank : skillRanks)
    {
      if(skillRank.getSkill().getType() == skillType)
        return skillRank;
    }
    
    return null;
  }
  
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
