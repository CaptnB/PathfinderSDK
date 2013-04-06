package com.pathfindersdktests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pathfindersdktests.bonus.BonusTestSuite;
import com.pathfindersdktests.books.BookTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ 
  BonusTestSuite.class ,
  BookTestSuite.class
  })
public class AllTestSuites
{

}
