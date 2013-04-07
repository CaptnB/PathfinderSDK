package com.pathfindersdktests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pathfindersdktests.bonus.BonusTestSuite;
import com.pathfindersdktests.books.BookTestSuite;
import com.pathfindersdktests.coins.CoinsTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ 
  BonusTestSuite.class ,
  BookTestSuite.class ,
  CoinsTestSuite.class
  })
public class AllTestSuites
{

}
