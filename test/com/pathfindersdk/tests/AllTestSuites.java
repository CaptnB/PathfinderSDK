package com.pathfindersdk.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pathfindersdk.tests.applicables.FeaturesTestSuite;
import com.pathfindersdk.tests.bonus.BonusTestSuite;
import com.pathfindersdk.tests.books.BooksTestSuite;
import com.pathfindersdk.tests.books.items.BookItemsTestSuite;
import com.pathfindersdk.tests.coins.CoinsTestSuite;
import com.pathfindersdk.tests.creatures.CreaturesTestSuite;
import com.pathfindersdk.tests.creatures.blocks.CreatureBlocksTestSuite;
import com.pathfindersdk.tests.enums.EnumsTestSuite;
import com.pathfindersdk.tests.equipment.EquipmentTestSuite;
import com.pathfindersdk.tests.prerequisites.PrerequisitesTestSuite;
import com.pathfindersdk.tests.stats.StatsTestSuite;
import com.pathfindersdk.tests.utils.UtilsTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ 
  BonusTestSuite.class,
  BooksTestSuite.class,
  BookItemsTestSuite.class,
  CoinsTestSuite.class,
  CreaturesTestSuite.class,
  CreatureBlocksTestSuite.class,
  EnumsTestSuite.class,
  EquipmentTestSuite.class,
  FeaturesTestSuite.class,
  PrerequisitesTestSuite.class,
  StatsTestSuite.class,
  UtilsTestSuite.class
})
public class AllTestSuites
{

}
