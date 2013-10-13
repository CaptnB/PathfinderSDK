package com.pathfindersdk.tests.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.utils.ValidationException;

public class ValidationExceptionTest
{
  @Test (expected = ValidationException.class)
  public void testValidationExceptionThrow() throws ValidationException
  {
    throw new ValidationException();
  }

  @Test
  public void testAddMessage()
  {
    ValidationException ve = new ValidationException();
    ve.addMessage("Exception message");
    
    assertEquals(1, ve.getMessages().size());
  }

  @Test
  public void testGetMessages()
  {
    ValidationException ve = new ValidationException();
    ve.addMessage("First exception message");
    ve.addMessage("Second exception message");

    String messages = "";
    for(String message : ve.getMessages())
      messages += message + "\n";
    
    assertEquals("First exception message\nSecond exception message\n", messages);
  }

}
