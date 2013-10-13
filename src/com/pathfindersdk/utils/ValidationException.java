package com.pathfindersdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationException extends Exception
{
  private static final long serialVersionUID = -990120330872729192L;
  private List<String> messages = new ArrayList<String>();
  
  public void addMessage(String message)
  {
    messages.add(message);
  }

  public List<String> getMessages()
  {
    return Collections.unmodifiableList(messages);
  }

}
