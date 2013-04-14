package com.pathfindersdk.books;

import java.util.ArrayList;
import java.util.List;

import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;


/**
 * A base builder for creating Book objects.
 */
public abstract class BookBuilder
{
  final public Book createBook(String title)
  {
    ArgChecker.checkNotNull(title);
    ArgChecker.checkNotEmpty(title);
    
    // Start by registering new BonusType as they are most probably needed for the rest
    List<String> bonusTypes = new ArrayList<String>();
    addNewBonusTypes(bonusTypes);
    registerNewBonusTypes(bonusTypes);
    
    // This builder forces a book organization in chapters and sections
    // 
    // Races (chapter)
    // -> Races (section)
    // -> Alternate racial traits
    // Classes (chapter)
    // -> Classes (section)
    // -> Class extensions
    // -> Archetypes
    // -> Prestige classes
    // ...
    
    List<BookComponent> components = new ArrayList<BookComponent>();
    
    addSection(components, createRacesChapter(BookSectionType.RACES, new ArrayList<BookComponent>()));
    addSection(components, createClassesChapter(BookSectionType.CLASSES, new ArrayList<BookComponent>()));
    addSection(components, createSkillsSection(BookSectionType.SKILLS, new ArrayList<BookComponent>()));
    addSection(components, createFeatsSection(BookSectionType.FEATS, new ArrayList<BookComponent>()));
    addSection(components, createEquipmentChapter(BookSectionType.EQUIPMENT, new ArrayList<BookComponent>()));
    addSection(components, createSpellsSection(BookSectionType.SPELLS, new ArrayList<BookComponent>()));
    addSection(components, createMagicItemsChapter(BookSectionType.MAGIC_ITEMS, new ArrayList<BookComponent>()));    
    addSection(components, createMonstersChapter(BookSectionType.MONSTERS, new ArrayList<BookComponent>()));
    
    return new Book(title, components);
  }
  
  
  private void addSection(List<BookComponent> components, BookSection section)
  {
    if(section != null && !section.isEmpty())
      components.add(section);
  }
  
  
  private void registerNewBonusTypes(List<String> newTypes)
  {
    for(String newType : newTypes)
    {
      BonusTypeRegister.getInstance().register(newType);
    }
  }


  private BookSection createRacesChapter(BookSectionType type, List<BookComponent> components)
  {
    addSection(components, createRacesSection(BookSectionType.RACES, new ArrayList<BookComponent>()));
    addSection(components, createAlternateRacialTraitsSection(BookSectionType.ALTERNATE_RACIAL_TRAITS, new ArrayList<BookComponent>()));
    
    return new BookSection(type, components);
  }


  private BookSection createClassesChapter(BookSectionType type, List<BookComponent> components)
  {
    addSection(components, createClassesSection(BookSectionType.CLASSES, new ArrayList<BookComponent>()));
    addSection(components, createClassExtensionsSection(BookSectionType.CLASS_EXTENSIONS, new ArrayList<BookComponent>()));
    addSection(components, createArchetypesSection(BookSectionType.ARCHETYPES, new ArrayList<BookComponent>()));
    addSection(components, createPrestigeClassesSection(BookSectionType.PRESTIGE_CLASSES, new ArrayList<BookComponent>()));
    
    return new BookSection(type, components);
  }


  private BookSection createEquipmentChapter(BookSectionType type, List<BookComponent> components)
  {
    addSection(components, createWeaponsSection(BookSectionType.WEAPONS, new ArrayList<BookComponent>()));
    addSection(components, createArmorsSection(BookSectionType.ARMORS, new ArrayList<BookComponent>()));
    addSection(components, createShieldsSection(BookSectionType.SHIELDS, new ArrayList<BookComponent>()));
    addSection(components, createEquipmentSection(BookSectionType.EQUIPMENT, new ArrayList<BookComponent>()));
    
    return new BookSection(type, components);
  }


  private BookSection createMagicItemsChapter(BookSectionType type, List<BookComponent> components)
  {
    addSection(components, createMagicWeaponsSection(BookSectionType.MAGIC_WEAPONS, new ArrayList<BookComponent>()));
    addSection(components, createMagicArmorsSection(BookSectionType.MAGIC_ARMORS, new ArrayList<BookComponent>()));
    addSection(components, createMagicShieldsSection(BookSectionType.MAGIC_SHIELDS, new ArrayList<BookComponent>()));
    addSection(components, createPotionsSection(BookSectionType.POTIONS, new ArrayList<BookComponent>()));
    addSection(components, createRingsSection(BookSectionType.RINGS, new ArrayList<BookComponent>()));
    addSection(components, createRodsSection(BookSectionType.RODS, new ArrayList<BookComponent>()));
    addSection(components, createScrollsSection(BookSectionType.SCROLLS, new ArrayList<BookComponent>()));
    addSection(components, createStavesSection(BookSectionType.STAVES, new ArrayList<BookComponent>()));
    addSection(components, createWandsSection(BookSectionType.WANDS, new ArrayList<BookComponent>()));
    addSection(components, createWondrousitemsSection(BookSectionType.WONDROUS_ITEMS, new ArrayList<BookComponent>()));
    addSection(components, createIntelligentItemsSection(BookSectionType.INTELLIGENT_ITEMS, new ArrayList<BookComponent>()));
    addSection(components, createCursedItemsSection(BookSectionType.CURSED_ITEMS, new ArrayList<BookComponent>()));
    addSection(components, createArtifactsSection(BookSectionType.ARTIFACTS, new ArrayList<BookComponent>()));
    
    return new BookSection(type, components);
  }


  private BookSection createMonstersChapter(BookSectionType type, List<BookComponent> components)
  {
    addSection(components, createMonstersSection(BookSectionType.MONSTERS, new ArrayList<BookComponent>()));
    addSection(components, createMonsterTemplatesSection(BookSectionType.MONSTER_TEMPLATES, new ArrayList<BookComponent>()));
    
    return new BookSection(type, components);
  }


  protected void addNewBonusTypes(List<String> newTypes)
  {
  }

  protected BookSection createRacesSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }


  protected BookSection createAlternateRacialTraitsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }


  protected BookSection createClassesSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }


  protected BookSection createClassExtensionsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }


  protected BookSection createArchetypesSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }


  protected BookSection createPrestigeClassesSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }


  protected BookSection createSkillsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }


  protected BookSection createFeatsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }

  protected BookSection createWeaponsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }

  protected BookSection createArmorsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }

  protected BookSection createShieldsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }

  protected BookSection createEquipmentSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }


  protected BookSection createSpellsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  
  protected BookSection createMagicWeaponsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createMagicArmorsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createMagicShieldsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
          

  protected BookSection createPotionsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createRingsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createRodsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createScrollsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createStavesSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createWandsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createWondrousitemsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createIntelligentItemsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createCursedItemsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createArtifactsSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createMonstersSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  

  protected BookSection createMonsterTemplatesSection(BookSectionType type, List<BookComponent> components)
  {
    return new BookSection(type, components);
  }
  
}
