package com.pathfindersdk.creatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.pathfindersdk.books.items.FeatItem;
import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.creatures.blocks.EquipmentBlock;
import com.pathfindersdk.creatures.blocks.SpeedBlock;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SaveType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.features.Feature;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.AbilityStat;
import com.pathfindersdk.stats.ArmorClass;
import com.pathfindersdk.stats.Cmb;
import com.pathfindersdk.stats.Cmd;
import com.pathfindersdk.stats.Size;
import com.pathfindersdk.stats.Skill;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.utils.ArgChecker;


/**
 * This base class contains stats common to every creatures (PCs, NPCs and Monsters).
 */
public abstract class Creature
{
  // Step 1 - Determine ability scores
  protected Map<AbilityType, AbilityScore> abilityScores = new HashMap<AbilityType, AbilityScore>();
  
  // Step 2 - Pick your race
  protected transient CreatureType type;
  protected transient Size size;
  protected transient SortedSet<VisionType> visions = new TreeSet<VisionType>();          // Sorted by ordinal, best vision type first
  protected transient SpeedBlock speedBlock = new SpeedBlock();
  
  // Step 3 - Pick your class
  
  // Step 4 - Pick skills and feats
  protected transient SortedMap<String, Stat> skills = new TreeMap<String, Stat>();
  protected transient SortedMap<String, FeatItem> feats = new TreeMap<String, FeatItem>();
  
  // Step 5 - Buy equipment
  
  // Step 6 - Finishing details
  protected String name;
  protected transient AlignmentType alignment;
  protected transient ArmorClass armorClass;
  
  protected transient BaseAttackBonus bab;
  protected transient AbilityStat attack;
  protected transient Cmb cmb;
  protected transient Cmd cmd;
  
  private transient EquipmentBlock equipment = new EquipmentBlock();

  
  protected transient SortedMap<SaveType, AbilityStat> savingThrows = new TreeMap<SaveType, AbilityStat>();
  protected transient AbilityStat initiative;
  
  protected transient SortedSet<LanguageType> languages = new TreeSet<LanguageType>();
  
  protected transient List<Feature> features = new ArrayList<Feature>();
  
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
    
//    Index index = Index.getInstance();
//    SortedSet<BookItem> items = index.getIndex(BookSectionType.SKILLS).getItems();
//    if(items != null)
//    {
//      for(BookItem item : items)
//      {
//        if(item instanceof SkillItem)
//        {
//          addSkill((SkillItem)item);
//        }
//      }
//    }
    
    initiative = new AbilityStat(getAbilityScore(AbilityType.DEX));
    bab = new BaseAttackBonus();
    attack = new AbilityStat(getAbilityScore(AbilityType.STR));
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
    {
      armorClass = new ArmorClass((AbilityScore)getAbilityScore(AbilityType.DEX), this.size);
      cmb = new Cmb(getAbilityScore(AbilityType.STR), getAbilityScore(AbilityType.DEX), bab, this.size);
      cmd = new Cmd(getAbilityScore(AbilityType.STR), getAbilityScore(AbilityType.DEX), bab, this.size);
    }
    else
    {
      armorClass = null;
      cmb = null;
      cmd = null;
    }
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
  
  public Stat getSpeed(SpeedType type)
  {
    return speedBlock.getSpeed(type);
  }

  public void addSpeed(SpeedType type, Stat speed)
  {
    speedBlock.addSpeed(type, speed);
  }

  public void removeSpeed(SpeedType type, Stat speed)
  {
    speedBlock.removeSpeed(type, speed);
  }

  public AbilityScore getAbilityScore(AbilityType type)
  {
    ArgChecker.checkIsNot(type, AbilityType.ANY);
    
    return abilityScores.get(type); 
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
  
  public BaseAttackBonus getBab()
  {
    return bab;
  }
  
  public AbilityStat getAttack()
  {
    return attack;
  }
  
  public Cmb getCmb()
  {
    return cmb;
  }
  
  public Cmd getCmd()
  {
    return cmd;
  }
  
  public ArmorClass getArmorClass()
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
  
  public void addFeat(FeatItem item)
  {
    feats.put(item.getName(), item);
  }
  
  public FeatItem getFeat(String featName)
  {
    return feats.get(featName);
  }
  
  public SortedSet<LanguageType> getLanguages()
  {
    return Collections.unmodifiableSortedSet(languages);
  }
  
  public void addLanguage(LanguageType language)
  {
    ArgChecker.checkNotNull(language);
    
    languages.add(language);
  }

  public EquipmentBlock getEquipment()
  {
    return equipment;
  }

  public List<Feature> getFeatures()
  {
    return Collections.unmodifiableList(features);
  }
}
