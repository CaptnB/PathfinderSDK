package com.pathfindersdk.books;

import com.pathfindersdk.creatures.Ability;
import com.pathfindersdk.creatures.AbilityBonus;
import com.pathfindersdk.creatures.AbilityPrerequisite;
import com.pathfindersdk.feats.Feat;
import com.pathfindersdk.feats.FeatPrerequisite;
import com.pathfindersdk.feats.FeatType;
import com.pathfindersdk.general.BonusType;
import com.pathfindersdk.races.Language;
import com.pathfindersdk.races.Race;
import com.pathfindersdk.races.Size;
import com.pathfindersdk.races.Vision;
import com.pathfindersdk.skills.Skill;
import com.pathfindersdk.skills.SkillBonus;

/**
 * A factory for creating the Core Rulebook.
 */
public class CoreBookFactory extends BookFactory
{

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addRaces(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addRaces(Book book)
  {
    Race dwarf = new Race("Dwarf", Size.MEDIUM, Vision.DARKVISION);
    dwarf.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.CON, false));
    dwarf.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.WIS, false));
    dwarf.getAbilityModifiers().add(new AbilityBonus(-2, BonusType.UNTYPED, Ability.CHA, false));
    dwarf.getBaseLanguages().add(Language.COMMON);
    dwarf.getBaseLanguages().add(Language.DWARVEN);
    dwarf.getOptionalLanguages().add(Language.GIANT);
    dwarf.getOptionalLanguages().add(Language.GNOME);
    dwarf.getOptionalLanguages().add(Language.GOBLIN);
    dwarf.getOptionalLanguages().add(Language.ORC);
    dwarf.getOptionalLanguages().add(Language.TERRAN);
    dwarf.getOptionalLanguages().add(Language.UNDERCOMMON);
    book.getRaces().add(dwarf);
    
    Race elf = new Race("Elf", Size.MEDIUM, Vision.LOW_LIGHT);
    elf.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.DEX, false));
    elf.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.INT, false));
    elf.getAbilityModifiers().add(new AbilityBonus(-2, BonusType.UNTYPED, Ability.CON, false));
    elf.getBaseLanguages().add(Language.COMMON);
    elf.getBaseLanguages().add(Language.ELVEN);
    elf.getOptionalLanguages().add(Language.CELESTIAL);
    elf.getOptionalLanguages().add(Language.DRACONIC);
    elf.getOptionalLanguages().add(Language.GNOLL);
    elf.getOptionalLanguages().add(Language.GNOME);
    elf.getOptionalLanguages().add(Language.GOBLIN);
    elf.getOptionalLanguages().add(Language.ORC);
    elf.getOptionalLanguages().add(Language.SYLVAN);
    book.getRaces().add(elf);
    
    Race gnome = new Race("Gnome", Size.SMALL, Vision.LOW_LIGHT);
    gnome.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.CON, false));
    gnome.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.CHA, false));
    gnome.getAbilityModifiers().add(new AbilityBonus(-2, BonusType.UNTYPED, Ability.STR, false));
    gnome.getBaseLanguages().add(Language.COMMON);
    gnome.getBaseLanguages().add(Language.GNOME);
    gnome.getBaseLanguages().add(Language.SYLVAN);
    gnome.getOptionalLanguages().add(Language.DRACONIC);
    gnome.getOptionalLanguages().add(Language.DWARVEN);
    gnome.getOptionalLanguages().add(Language.ELVEN);
    gnome.getOptionalLanguages().add(Language.GIANT);
    gnome.getOptionalLanguages().add(Language.GOBLIN);
    gnome.getOptionalLanguages().add(Language.ORC);
    book.getRaces().add(gnome);
    
    Race halfElf = new Race("Half-Elf", Size.MEDIUM, Vision.LOW_LIGHT);
    halfElf.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.ANY, false));
    halfElf.getBaseLanguages().add(Language.COMMON);
    halfElf.getBaseLanguages().add(Language.ELVEN);
    halfElf.getOptionalLanguages().add(Language.ABYSSAL);
    halfElf.getOptionalLanguages().add(Language.AKLO);
    halfElf.getOptionalLanguages().add(Language.AQUAN);
    halfElf.getOptionalLanguages().add(Language.AURAN);
    halfElf.getOptionalLanguages().add(Language.CELESTIAL);
    halfElf.getOptionalLanguages().add(Language.DRACONIC);
    halfElf.getOptionalLanguages().add(Language.DWARVEN);
    halfElf.getOptionalLanguages().add(Language.GIANT);
    halfElf.getOptionalLanguages().add(Language.GNOLL);
    halfElf.getOptionalLanguages().add(Language.GNOME);
    halfElf.getOptionalLanguages().add(Language.GOBLIN);
    halfElf.getOptionalLanguages().add(Language.HALFLING);
    halfElf.getOptionalLanguages().add(Language.IGNAN);
    halfElf.getOptionalLanguages().add(Language.INFERNAL);
    halfElf.getOptionalLanguages().add(Language.ORC);
    halfElf.getOptionalLanguages().add(Language.SYLVAN);
    halfElf.getOptionalLanguages().add(Language.TERRAN);
    halfElf.getOptionalLanguages().add(Language.UNDERCOMMON);
    book.getRaces().add(halfElf);
    
    Race halfOrc = new Race("Half-Orc", Size.MEDIUM, Vision.DARKVISION);
    halfOrc.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.ANY, false));
    halfOrc.getBaseLanguages().add(Language.COMMON);
    halfOrc.getBaseLanguages().add(Language.ORC);
    halfOrc.getOptionalLanguages().add(Language.ABYSSAL);
    halfOrc.getOptionalLanguages().add(Language.DRACONIC);
    halfOrc.getOptionalLanguages().add(Language.GIANT);
    halfOrc.getOptionalLanguages().add(Language.GNOLL);
    halfOrc.getOptionalLanguages().add(Language.GOBLIN);
    book.getRaces().add(halfOrc);
    
    Race halfling = new Race("Halfling", Size.SMALL, Vision.NORMAL);
    halfling.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.DEX, false));
    halfling.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.CHA, false));
    halfling.getAbilityModifiers().add(new AbilityBonus(-2, BonusType.UNTYPED, Ability.STR, false));
    halfling.getBaseLanguages().add(Language.COMMON);
    halfling.getBaseLanguages().add(Language.HALFLING);
    halfling.getOptionalLanguages().add(Language.DWARVEN);
    halfling.getOptionalLanguages().add(Language.ELVEN);
    halfling.getOptionalLanguages().add(Language.GNOME);
    halfling.getOptionalLanguages().add(Language.GOBLIN);
    book.getRaces().add(halfling);
    
    Race human = new Race("Human", Size.MEDIUM, Vision.NORMAL);
    human.getAbilityModifiers().add(new AbilityBonus(2, BonusType.UNTYPED, Ability.ANY, false));
    human.getBaseLanguages().add(Language.COMMON);
    human.getOptionalLanguages().add(Language.ABYSSAL);
    human.getOptionalLanguages().add(Language.AKLO);
    human.getOptionalLanguages().add(Language.AQUAN);
    human.getOptionalLanguages().add(Language.AURAN);
    human.getOptionalLanguages().add(Language.CELESTIAL);
    human.getOptionalLanguages().add(Language.DRACONIC);
    human.getOptionalLanguages().add(Language.DWARVEN);
    human.getOptionalLanguages().add(Language.ELVEN);
    human.getOptionalLanguages().add(Language.GIANT);
    human.getOptionalLanguages().add(Language.GNOLL);
    human.getOptionalLanguages().add(Language.GNOME);
    human.getOptionalLanguages().add(Language.GOBLIN);
    human.getOptionalLanguages().add(Language.HALFLING);
    human.getOptionalLanguages().add(Language.IGNAN);
    human.getOptionalLanguages().add(Language.INFERNAL);
    human.getOptionalLanguages().add(Language.ORC);
    human.getOptionalLanguages().add(Language.SYLVAN);
    human.getOptionalLanguages().add(Language.TERRAN);
    human.getOptionalLanguages().add(Language.UNDERCOMMON);
    book.getRaces().add(human);
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addClasses(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addClasses(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addClassExtensions(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addClassExtensions(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addArchetypes(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addArchetypes(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addPrestigeClasses(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addPrestigeClasses(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addFeats(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addFeats(Book book)
  {
    Feat acrobatic = new Feat("Acrobatic", FeatType.UNTYPED);
    acrobatic.getBenefits().add(new SkillBonus(2, BonusType.UNTYPED, "Acrobatics", false));
    acrobatic.getBenefits().add(new SkillBonus(2, BonusType.UNTYPED, "Fly", false));
    book.getFeats().add(acrobatic);

    Feat acrobaticSteps = new Feat("Acrobatic Steps", FeatType.UNTYPED);
    acrobaticSteps.getPrerequisites().add(new AbilityPrerequisite(Ability.DEX, 15));
    acrobaticSteps.getPrerequisites().add(new FeatPrerequisite("Nimble Moves"));
    book.getFeats().add(acrobaticSteps);
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addEquipment(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addEquipment(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addActions(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addActions(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addSpells(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addSpells(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addMonsters(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addMonsters(Book book)
  {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addSkills(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addSkills(Book book)
  {
    book.getSkills().add(new Skill("Acrobatics", Ability.DEX, true, true));
    book.getSkills().add(new Skill("Appraise", Ability.INT, true, false));
    book.getSkills().add(new Skill("Bluff", Ability.CHA, true, false));
    book.getSkills().add(new Skill("Climb", Ability.STR, true, true));
    book.getSkills().add(new Skill("Craft", Ability.INT, true, false));
    book.getSkills().add(new Skill("Diplomacy", Ability.CHA, true, false));
    book.getSkills().add(new Skill("Disable Device", Ability.DEX, false, true));
    book.getSkills().add(new Skill("Disguise", Ability.CHA, true, false));
    book.getSkills().add(new Skill("Escape Artist", Ability.DEX, true, true));
    book.getSkills().add(new Skill("Fly", Ability.DEX, true, true));
    book.getSkills().add(new Skill("Handle Animal", Ability.CHA, false, false));
    book.getSkills().add(new Skill("Heal", Ability.WIS, true, false));
    book.getSkills().add(new Skill("Intimidate", Ability.CHA, true, true));
    book.getSkills().add(new Skill("Knowledge (arcana)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (dungeonneering)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (engineering)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (geography)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (history)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (local)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (nature)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (nobility)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (planes)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Knowledge (religion)", Ability.INT, false, false));
    book.getSkills().add(new Skill("Linguistics", Ability.INT, false, false));
    book.getSkills().add(new Skill("Perception", Ability.WIS, true, false));
    book.getSkills().add(new Skill("Perform", Ability.CHA, true, false));
    book.getSkills().add(new Skill("Profession", Ability.WIS, false, false));
    book.getSkills().add(new Skill("Ride", Ability.DEX, true, true));
    book.getSkills().add(new Skill("Sense Motive", Ability.WIS, true, false));
    book.getSkills().add(new Skill("Sleight of Hand", Ability.DEX, false, true));
    book.getSkills().add(new Skill("Spellcraft", Ability.INT, false, false));
    book.getSkills().add(new Skill("Stealth", Ability.DEX, true, true));
    book.getSkills().add(new Skill("Survival", Ability.WIS, true, false));
    book.getSkills().add(new Skill("Swim", Ability.STR, true, true));
    book.getSkills().add(new Skill("Use Magic Device", Ability.CHA, false, false));
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.books.BookFactory#addSkillExpansions(com.pathfindersdk.books.Book)
   */
  @Override
  protected void addSkillExpansions(Book book)
  {
    Skill craft = book.getSkill("Craft");
    if(craft != null)
    {
      craft.getExpansions().add("alchemy");
      craft.getExpansions().add("armor");
      craft.getExpansions().add("baskets");
      craft.getExpansions().add("books");
      craft.getExpansions().add("bows");
      craft.getExpansions().add("calligraphy");
      craft.getExpansions().add("carpentry");
      craft.getExpansions().add("cloth");
      craft.getExpansions().add("clothing");
      craft.getExpansions().add("glass");
      craft.getExpansions().add("jewelry");
      craft.getExpansions().add("leather");
      craft.getExpansions().add("locks");
      craft.getExpansions().add("paintings");
      craft.getExpansions().add("pottery");
      craft.getExpansions().add("sculptures");
      craft.getExpansions().add("ships");
      craft.getExpansions().add("shoes");
      craft.getExpansions().add("stonemasonry");
      craft.getExpansions().add("traps");
      craft.getExpansions().add("weapons");
    }
    
    Skill perform = book.getSkill("Perform");
    if(perform != null)
    {
      perform.getExpansions().add("act");
      perform.getExpansions().add("comedy");
      perform.getExpansions().add("dance");
      perform.getExpansions().add("keyboard");
      perform.getExpansions().add("oratory");
      perform.getExpansions().add("percussion instruments");
      perform.getExpansions().add("string instruments");
      perform.getExpansions().add("wind instruments");
      perform.getExpansions().add("sing");
    }

    Skill profession = book.getSkill("Profession");
    if(profession != null)
    {
      profession.getExpansions().add("architect");
      profession.getExpansions().add("baker");
      profession.getExpansions().add("barrister");
      profession.getExpansions().add("brewer");
      profession.getExpansions().add("butcher");
      profession.getExpansions().add("clerk");
      profession.getExpansions().add("cook");
      profession.getExpansions().add("courtesan");
      profession.getExpansions().add("driver");
      profession.getExpansions().add("engineer");
      profession.getExpansions().add("farmer");
      profession.getExpansions().add("fisherman");
      profession.getExpansions().add("gambler");
      profession.getExpansions().add("gardener");
      profession.getExpansions().add("herbalist");
      profession.getExpansions().add("innkeeper");
      profession.getExpansions().add("librarian");
      profession.getExpansions().add("merchant");
      profession.getExpansions().add("midwife");
      profession.getExpansions().add("miller");
      profession.getExpansions().add("miner");
      profession.getExpansions().add("porter");
      profession.getExpansions().add("sailor");
      profession.getExpansions().add("scribe");
      profession.getExpansions().add("shepherd");
      profession.getExpansions().add("stable master");
      profession.getExpansions().add("soldier");
      profession.getExpansions().add("tanner");
      profession.getExpansions().add("trapper");
      profession.getExpansions().add("woodcutter");
    }
  }

}
