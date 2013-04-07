package com.pathfindersdk.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pathfindersdk.tests.bonus.BonusTestSuite;
import com.pathfindersdk.tests.books.BooksTestSuite;
import com.pathfindersdk.tests.coins.CoinsTestSuite;
import com.pathfindersdk.tests.prerequisites.PrerequisitesTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ 
  BonusTestSuite.class,
  BooksTestSuite.class,
  CoinsTestSuite.class,
  PrerequisitesTestSuite.class
})
public class AllTestSuites
{

}
