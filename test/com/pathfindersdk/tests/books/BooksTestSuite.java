package com.pathfindersdk.tests.books;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  BookBuilderTest.class,
  BookComponentTest.class,
  BookItemTest.class,
  BookSectionTest.class,
  BookTest.class,
  IndexTest.class
})
public class BooksTestSuite
{

}
