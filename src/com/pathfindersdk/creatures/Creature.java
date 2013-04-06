package com.pathfindersdk.creatures;

import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.enums.SaveType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.AbilityStat;
import com.pathfindersdk.stats.ArmorClass;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Skill;
import com.pathfindersdk.stats.Stat;


/**
 * This base class contains stats common to every creatures (PCs, NPCs and Monsters).
 */
public abstract class Creature
{
  // Step 1 - Determine ability scores
  protected SortedMap<AbilityType, AbilityScore> abilityScores = new TreeMap<AbilityType, AbilityScore>();
  
  // Step 2 - Pick your race
  protected transient CreatureType type;
  protected transient Size size;
  protected transient SortedSet<VisionType> visions = new TreeSet<VisionType>();
  protected transient SortedMap<SpeedType, Stat> speeds = new TreeMap<SpeedType, Stat>();
  
  // Step 3 - Pick your class
  
  // Step 4 - Pick skills and feats
  protected transient SortedMap<String, Stat> skills = new TreeMap<String, Stat>();
  
  // Step 5 - Buy equipment
  
  // Step 6 - Finishing details
  protected String name;
  protected transient AlignmentType alignment;
  protected transient Stat armorClass;
  
  protected transient AbilityStat attack;
  protected transient AbilityStat cmb;
  protected transient AbilityStat cmd;

  
  protected transient SortedMap<SaveType, AbilityStat> savingThrows = new TreeMap<SaveType, AbilityStat>();
  protected transient AbilityStat initiative;
  
  public Creature()
  {
    abilityScores.put(AbilityType.STR, new AbilityScore());
    abilityScores.put(AbilityType.DEX, new AbilityScore());
    abilityScores.put(AbilityType.CON, new AbilityScore());
    abilityScores.put(AbilityType.INT, new AbilityScore());
    abilityScores.put(AbilityType.WIS, new AbilityScore());
    abilityScores.put(AbilityType.CHA, new AbilityScore());

    savingThrows.put(SaveType.FORT, new AbilityStat(getAbilityScore(AbilityType.CON)));
    savingThrows.put(SaveType.REF,  new AbilityStat(getAbilityScore(AbilityType.DEX)));
    savingThrows.put(SaveType.WILL, new AbilityStat(getAbilityScore(AbilityType.WIS)));
    
    Index index = Index.getInstance();
    SortedSet<BookItem> items = index.getIndex(BookSectionType.SKILLS).getItems();
    if(items != null)
    {
      for(BookItem item : items)
      {
        if(item instanceof SkillItem)
        {
          addSkill((SkillItem)item);
        }
      }
    }
    
    initiative = new AbilityStat(getAbilityScore(AbilityType.DEX));
    
    // TODO : revisit this...
    attack = new AbilityStat(getAbilityScore(AbilityType.STR));
    cmb = new AbilityStat(getAbilityScore(AbilityType.STR));
    cmd = new AbilityStat(getAbilityScore(AbilityType.STR));
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public AlignmentType getAlignment()
  {
    return alignment;
  }
  
  public void setAlignment(AlignmentType alignment)
  {
    this.alignment = alignment;
  }
  
  public CreatureType getType()
  {
    return type;
  }
  
  protected void setType(CreatureType type)
  {
    this.type = type;
  }
  
  public Size getSize()
  {
    return size;
  }
  
  public void setSize(Size size)
  {
    this.size = size;
    
    // Up to this point, AC could not be computed without the creature's size
    if(size != null)
      armorClass = new ArmorClass((AbilityScore)getAbilityScore(AbilityType.DEX), size);
    else
      armorClass = null;
  }
  
  public SortedSet<VisionType> getVisions()
  {
    if(visions != null)
      return Collections.unmodifiableSortedSet(visions);
    else return null;
  }
  
  public VisionType getVision()
  {
    return getVisions().first();
  }
  
  public void addVision(VisionType vision)
  {
    visions.add(vision);
  }

  public SortedMap<SpeedType, Stat> getSpeeds()
  {
    if(speeds != null)
      return Collections.unmodifiableSortedMap(speeds);
    else
      return null;
  }
  
  public Stat getSpeed(SpeedType type)
  {
    return speeds.get(type);
  }

  public void addSpeed(SpeedType type, Stat speed)
  {
    if(type != null && speed != null)
    {
      speeds.put(type, speed);
    }
  }

  public void removeSpeed(SpeedType type)
  {
    speeds.remove(type);
  }

  public AbilityScore getAbilityScore(AbilityType type)
  {
    AbilityScore score = abilityScores.get(type);
    if(score == null)
      System.out.println("Ability Score is null!");
    
    return score; 
  }
  
  public Stat getStrenght()
  {
    return getAbilityScore(AbilityType.STR);
  }
  
  public Stat getDexterity()
  {
    return getAbilityScore(AbilityType.DEX);
  }
  
  public Stat getConstitution()
  {
    return getAbilityScore(AbilityType.CON);
  }
  
  public Stat getIntelligence()
  {
    return getAbilityScore(AbilityType.INT);
  }
  
  public Stat getWisdom()
  {
    return getAbilityScore(AbilityType.WIS);
  }
  
  public Stat getCharisma()
  {
    return getAbilityScore(AbilityType.CHA);
  }
  
  public AbilityStat getSavingThrow(SaveType type)
  {
    AbilityStat savingThrow = savingThrows.get(type);
    if(savingThrow == null)
      System.out.println("SavingThrow is null!");
    
    return savingThrow;
  }
  
  public AbilityStat getFortitude()
  {
    return getSavingThrow(SaveType.FORT);
  }
  
  public AbilityStat getReflex()
  {
    return getSavingThrow(SaveType.REF);
  }
  
  public AbilityStat getWill()
  {
    return getSavingThrow(SaveType.WILL);
  }
  
  public AbilityStat getInitiative()
  {
    return initiative;
  }
  
  public AbilityStat getAttack()
  {
    return attack;
  }
  
  public AbilityStat getCmb()
  {
    return cmb;
  }
  
  public AbilityStat getCmd()
  {
    return cmd;
  }
  
  public Stat getArmorClass()
  {
    return armorClass;
  }
  
  public void addSkill(SkillItem item)
  {
    skills.put(item.getName(), new Skill(item, getAbilityScore(item.getKeyAbility())));
  }
  
  public Stat getSkill(String skillName)
  {
    return skills.get(skillName);
  }
}
