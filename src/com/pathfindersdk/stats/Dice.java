package com.pathfindersdk.stats;

import java.util.Random;


final public class Dice implements Rollable
{
  final private int numbers;
  final private int faces;
  
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
  public int roll()
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
