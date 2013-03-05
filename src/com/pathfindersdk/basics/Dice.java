package com.pathfindersdk.basics;

import java.util.Random;

public class Dice implements Rollable
{
  protected Integer numbers;
  protected Integer faces;
  
  public Dice(int numbers, int faces)
  {
    if(numbers > 0)
      this.numbers = numbers;
    else
      this.numbers = 1;
    
    if(faces > 0)
      this.faces = faces;
    else
      this.faces = 1;
  }
  
  @Override
  public Integer roll()
  {
    int roll = 0;
    Random random = new Random();
    for(int i = 0; i < numbers; i++)
    {
      roll += random.nextInt(faces) + 1;
    }
    return roll;
  }
}
