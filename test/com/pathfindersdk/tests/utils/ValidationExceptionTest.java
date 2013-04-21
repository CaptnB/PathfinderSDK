package com.pathfindersdk.tests.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.utils.ValidationException;

public class ValidationExceptionTest
{
  @Test (expected = ValidationException.class)
  public void testValidationExceptionThrow() throws ValidationException
  {
    throw new ValidationException("An exception");
  }

  @Test
  public void testAddMessage()
  {
    ValidationException ve = new ValidationException("First exception message");
    ve.addMessage("Second exception message");
    
    assertEquals(2, ve.getMessages().size());
  }

  @Test
  public void testGetMessages()
  {
    ValidationException ve = new ValidationException("First exception message");
    ve.addMessage("Second exception message");

    String messages = "";
    for(String message : ve.getMessages())
      messages += message + "\n";
    
    assertEquals("First exception message\nSecond exception message\n", messages);
  }

}
