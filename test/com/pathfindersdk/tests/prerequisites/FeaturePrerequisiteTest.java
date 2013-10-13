package com.pathfindersdk.tests.prerequisites;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import com.pathfindersdk.applicables.AbilityIncrease;
import com.pathfindersdk.applicables.Feature;
import com.pathfindersdk.applicables.Race;
import com.pathfindersdk.bonus.NullBonus;
import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.CreatureType;
import com.pathfindersdk.enums.CreatureMainType;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.prerequisites.FeaturePrerequisite;
import com.pathfindersdk.prerequisites.Prerequisite;

public class FeaturePrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testFeaturePrerequisite()
  {
    new FeaturePrerequisite(null);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testIsFilledNull()
  {
    Prerequisite prereq = new FeaturePrerequisite("Test trait");
    prereq.isFilled(null);
  }

  @Test
  public void testIsFilledPass()
  {
    SortedSet<Feature> features = new TreeSet<Feature>();
    Feature trait = new Feature("Test trait", new NullBonus());
    features.add(trait);
    
    RaceItem raceItem = new RaceItem("Test race", new CreatureType(CreatureMainType.ABERRATION), new ArrayList<AbilityIncrease>(), 
        SizeType.MEDIUM, new HashMap<SpeedType, Integer>(), VisionType.DARKVISION_120, features, new TreeSet<LanguageType>(), new TreeSet<LanguageType>());

    Character character = new Character();
    character.setRace(new Race(raceItem));
    
    Prerequisite prereq = new FeaturePrerequisite("Test trait");
    
    assertTrue(prereq.isFilled(character));
  }

  @Test
  public void testIsFilledFail()
  {
    SortedSet<Feature> features = new TreeSet<Feature>();
    Feature feature = new Feature("Test trait", new NullBonus());
    features.add(feature);
    
    RaceItem raceItem = new RaceItem("Test race", new CreatureType(CreatureMainType.ABERRATION), new ArrayList<AbilityIncrease>(), 
        SizeType.MEDIUM, new HashMap<SpeedType, Integer>(), VisionType.DARKVISION_120, features, new TreeSet<LanguageType>(), new TreeSet<LanguageType>());

    Character character = new Character();
    character.setRace(new Race(raceItem));
    
    Prerequisite prereq = new FeaturePrerequisite("Test trait 2");
    
    assertFalse(prereq.isFilled(character));
  }

}
