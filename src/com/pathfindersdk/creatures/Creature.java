package com.pathfindersdk.creatures;

import java.util.HashSet;

import com.pathfindersdk.classes.Class;
import com.pathfindersdk.feats.Feat;
import com.pathfindersdk.skills.SkillRank;

/**
 * The Class Character.
 */
public abstract class Creature
{
  /** The ability scores. */
  private HashSet<AbilityScore> abilityScores = new HashSet<AbilityScore>();
  
  /** The skill ranks. */
  private HashSet<SkillRank> skillRanks = new HashSet<SkillRank>();
  
  /** The feats. */
  private HashSet<Feat> feats = new HashSet<Feat>();
  
  /** The classes. */
  private HashSet<Class> classes = new HashSet<Class>();
  
  public Integer getLevel()
  {
    return classes.size();
  }
  
  public Creature()
  {
    abilityScores.add(new AbilityScore(Ability.STR, 10));
    abilityScores.add(new AbilityScore(Ability.DEX, 10));
    abilityScores.add(new AbilityScore(Ability.CON, 10));
    abilityScores.add(new AbilityScore(Ability.INT, 10));
    abilityScores.add(new AbilityScore(Ability.WIS, 10));
    abilityScores.add(new AbilityScore(Ability.CHA, 10));
  }
  
  public HashSet<AbilityScore> getAbilityScores()
  {
    return abilityScores;
  }
  
  public HashSet<SkillRank> getSkillRanks()
  {
    return skillRanks;
  }
  
  public HashSet<Feat> getFeats()
  {
    return feats;
  }
  
  public HashSet<Class> getClasses()
  {
    return classes;
  }
  
  public AbilityScore getAbilityScore(Ability ability)
  {
    for(AbilityScore abilityScore : abilityScores)
    {
      if(abilityScore.getAbility() == ability)
        return abilityScore;
    }
    
    return null;
  }
  
  /**
   * Gets the skill.
   *
   * @param skillType the skill type
   * @return the skill
   */
  public SkillRank getSkill(String skillName)
  {
    for(SkillRank skillRank : skillRanks)
    {
      if(skillRank.getSkillType().getName().compareTo(skillName) == 0)
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
