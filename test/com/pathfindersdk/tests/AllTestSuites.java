package com.pathfindersdk.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pathfindersdk.tests.bonus.BonusTestSuite;
import com.pathfindersdk.tests.books.BooksTestSuite;
import com.pathfindersdk.tests.books.items.BookItemsTestSuite;
import com.pathfindersdk.tests.coins.CoinsTestSuite;
import com.pathfindersdk.tests.creatures.CreaturesTestSuite;
import com.pathfindersdk.tests.equipment.EquipmentTestSuite;
import com.pathfindersdk.tests.features.FeaturesTestSuite;
import com.pathfindersdk.tests.prerequisites.PrerequisitesTestSuite;
import com.pathfindersdk.tests.stats.StatsTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ 
  BonusTestSuite.class,
  BooksTestSuite.class,
  BookItemsTestSuite.class,
  CoinsTestSuite.class,
  CreaturesTestSuite.class,
  EquipmentTestSuite.class,
  FeaturesTestSuite.class,
  PrerequisitesTestSuite.class,
  StatsTestSuite.class
})
public class AllTestSuites
{

}
