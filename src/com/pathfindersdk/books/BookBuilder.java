package com.pathfindersdk.books;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

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
    // Start by registering new BonusType as they are most probably needed for the rest
    List<String> newBonusTypes = addNewBonusTypes(new ArrayList<String>());
    if(newBonusTypes != null && !newBonusTypes.isEmpty())
      registerNewBonusTypes(newBonusTypes);
    
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
    
    SortedSet<BookComponent> components = new TreeSet<BookComponent>();
    
    addSection(components, createRacesChapter(BookSectionType.RACES, new TreeSet<BookComponent>()));
    addSection(components, createClassesChapter(BookSectionType.CLASSES, new TreeSet<BookComponent>()));
    addSection(components, createSkillsSection(BookSectionType.SKILLS, new TreeSet<BookComponent>()));
    addSection(components, createFeatsSection(BookSectionType.FEATS, new TreeSet<BookComponent>()));
    addSection(components, createEquipmentChapter(BookSectionType.EQUIPMENT, new TreeSet<BookComponent>()));
    addSection(components, createSpellsSection(BookSectionType.SPELLS, new TreeSet<BookComponent>()));
    addSection(components, createMagicItemsChapter(BookSectionType.MAGIC_ITEMS, new TreeSet<BookComponent>()));    
    addSection(components, createMonstersChapter(BookSectionType.MONSTERS, new TreeSet<BookComponent>()));
    
    return new Book(title, components);
  }
  
  
  private void addSection(SortedSet<BookComponent> components, BookSection section)
  {
    if(section != null && !section.isEmpty())
      components.add(section);
  }
  
  
  private void registerNewBonusTypes(List<String> newTypes)
  {
    for(String newType : newTypes)
    {
      ArgChecker.checkNotNull(newType);

      BonusTypeRegister.getInstance().register(newType);
    }
  }


  private BookSection createRacesChapter(BookSectionType type, SortedSet<BookComponent> components)
  {
    addSection(components, createRacesSection(BookSectionType.RACES, new TreeSet<BookComponent>()));
    addSection(components, createAlternateRacialTraitsSection(BookSectionType.ALTERNATE_RACIAL_TRAITS, new TreeSet<BookComponent>()));
    
    if(!components.isEmpty())
      return new BookSection(type, components);
    else
      return null;
  }


  private BookSection createClassesChapter(BookSectionType type, SortedSet<BookComponent> components)
  {
    addSection(components, createClassesSection(BookSectionType.CLASSES, new TreeSet<BookComponent>()));
    addSection(components, createClassExtensionsSection(BookSectionType.CLASS_EXTENSIONS, new TreeSet<BookComponent>()));
    addSection(components, createArchetypesSection(BookSectionType.ARCHETYPES, new TreeSet<BookComponent>()));
    addSection(components, createPrestigeClassesSection(BookSectionType.PRESTIGE_CLASSES, new TreeSet<BookComponent>()));
    
    if(!components.isEmpty())
      return new BookSection(type, components);
    else
      return null;
  }


  private BookSection createEquipmentChapter(BookSectionType type, SortedSet<BookComponent> components)
  {
    addSection(components, createWeaponsSection(BookSectionType.WEAPONS, new TreeSet<BookComponent>()));
    addSection(components, createArmorsSection(BookSectionType.ARMORS, new TreeSet<BookComponent>()));
    addSection(components, createShieldsSection(BookSectionType.SHIELDS, new TreeSet<BookComponent>()));
    addSection(components, createEquipmentSection(BookSectionType.EQUIPMENT, new TreeSet<BookComponent>()));
    
    if(!components.isEmpty())
      return new BookSection(type, components);
    else
      return null;
  }


  private BookSection createMagicItemsChapter(BookSectionType type, SortedSet<BookComponent> components)
  {
    addSection(components, createMagicWeaponsSection(BookSectionType.MAGIC_WEAPONS, new TreeSet<BookComponent>()));
    addSection(components, createMagicArmorsSection(BookSectionType.MAGIC_ARMORS, new TreeSet<BookComponent>()));
    addSection(components, createMagicShieldsSection(BookSectionType.MAGIC_SHIELDS, new TreeSet<BookComponent>()));
    addSection(components, createPotionsSection(BookSectionType.POTIONS, new TreeSet<BookComponent>()));
    addSection(components, createRingsSection(BookSectionType.RINGS, new TreeSet<BookComponent>()));
    addSection(components, createRodsSection(BookSectionType.RODS, new TreeSet<BookComponent>()));
    addSection(components, createScrollsSection(BookSectionType.SCROLLS, new TreeSet<BookComponent>()));
    addSection(components, createStavesSection(BookSectionType.STAVES, new TreeSet<BookComponent>()));
    addSection(components, createWandsSection(BookSectionType.WANDS, new TreeSet<BookComponent>()));
    addSection(components, createWondrousitemsSection(BookSectionType.WONDROUS_ITEMS, new TreeSet<BookComponent>()));
    addSection(components, createIntelligentItemsSection(BookSectionType.INTELLIGENT_ITEMS, new TreeSet<BookComponent>()));
    addSection(components, createCursedItemsSection(BookSectionType.CURSED_ITEMS, new TreeSet<BookComponent>()));
    addSection(components, createArtifactsSection(BookSectionType.ARTIFACTS, new TreeSet<BookComponent>()));
    
    if(!components.isEmpty())
      return new BookSection(type, components);
    else
      return null;
  }


  private BookSection createMonstersChapter(BookSectionType type, SortedSet<BookComponent> components)
  {
    addSection(components, createMonstersSection(BookSectionType.MONSTERS, new TreeSet<BookComponent>()));
    addSection(components, createMonsterTemplatesSection(BookSectionType.MONSTER_TEMPLATES, new TreeSet<BookComponent>()));
    
    if(!components.isEmpty())
      return new BookSection(type, components);
    else
      return null;
  }


  protected List<String> addNewBonusTypes(List<String> newTypes)
  {
    return null;
  }

  protected BookSection createRacesSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }


  protected BookSection createAlternateRacialTraitsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }


  protected BookSection createClassesSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }


  protected BookSection createClassExtensionsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }


  protected BookSection createArchetypesSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }


  protected BookSection createPrestigeClassesSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }


  protected BookSection createSkillsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }


  protected BookSection createFeatsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }

  protected BookSection createWeaponsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }

  protected BookSection createArmorsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }

  protected BookSection createShieldsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }

  protected BookSection createEquipmentSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }


  protected BookSection createSpellsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  
  protected BookSection createMagicWeaponsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createMagicArmorsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createMagicShieldsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
          

  protected BookSection createPotionsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createRingsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createRodsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createScrollsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createStavesSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createWandsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createWondrousitemsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createIntelligentItemsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createCursedItemsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createArtifactsSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createMonstersSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  

  protected BookSection createMonsterTemplatesSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    return null;
  }
  
}
