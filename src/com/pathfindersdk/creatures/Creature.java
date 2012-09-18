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
  /** The name */
  private String name;
  
  /** The alignment. */
  private Alignment alignment;
  
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
  
  /**
   * Instantiates a new creature.
   */
  public Creature(String name, Alignment alignment)
  {
    this.name = name;
    this.alignment = alignment;
    
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
  
  /**
   * Gets the ability score.
   *
   * @param ability the ability
   * @return the ability score
   */
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
   * @param skillName the skill name
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
  
  public abstract Size getSize();
}
