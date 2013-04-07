package com.pathfindersdk.tests.prerequisites;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.creatures.CreatureType;
import com.pathfindersdk.enums.CreatureMainType;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.features.AbilityIncrease;
import com.pathfindersdk.features.Race;
import com.pathfindersdk.features.RacialTrait;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.prerequisites.RacialTraitPrerequisite;

public class RacialTraitPrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testRacialTraitPrerequisite()
  {
    new RacialTraitPrerequisite(null);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testIsFilledNull()
  {
    Prerequisite<Race> prereq = new RacialTraitPrerequisite("Test trait");
    prereq.isFilled(null);
  }

  @Test
  public void testIsFilledPass()
  {
    SortedSet<RacialTrait> racialTraits = new TreeSet<RacialTrait>();
    RacialTrait trait = new RacialTrait("Test trait", new TreeSet<Bonus>());
    racialTraits.add(trait);
    
    RaceItem raceItem = new RaceItem("Test race", new CreatureType(CreatureMainType.ABERRATION), new ArrayList<AbilityIncrease>(), 
        SizeType.MEDIUM, new HashMap<SpeedType, Integer>(), VisionType.DARKVISION_120, racialTraits, new TreeSet<LanguageType>(), new TreeSet<LanguageType>());
    Race race = new Race(raceItem);
    
    Prerequisite<Race> prereq = new RacialTraitPrerequisite("Test trait");
    
    assertTrue(prereq.isFilled(race));
  }

  @Test
  public void testIsFilledFail()
  {
    SortedSet<RacialTrait> racialTraits = new TreeSet<RacialTrait>();
    RacialTrait trait = new RacialTrait("Test trait", new TreeSet<Bonus>());
    racialTraits.add(trait);
    
    RaceItem raceItem = new RaceItem("Test race", new CreatureType(CreatureMainType.ABERRATION), new ArrayList<AbilityIncrease>(), 
        SizeType.MEDIUM, new HashMap<SpeedType, Integer>(), VisionType.DARKVISION_120, racialTraits, new TreeSet<LanguageType>(), new TreeSet<LanguageType>());
    Race race = new Race(raceItem);
    
    Prerequisite<Race> prereq = new RacialTraitPrerequisite("Test trait 2");
    
    assertFalse(prereq.isFilled(race));
  }

}
