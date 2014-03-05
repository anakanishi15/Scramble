//Amanda Nakanishi
//2/21/14
//Morse Code. Why? I got bored

import java.util.Scanner;

public class Morse
{
  private String message = "";//instance variable
  private String fileName = "";
  private String portion = "";//for taking portion without space.
  p
  
  public Morse(String newmessage, String name)
  {
    message = newmessage;//constructor
    fileName = name;
  }
  
  public void setUp()//sets up morse code
  {
    while(message.length() > 0)//while there's still characters in the message
    {
      for(int i = 0; i<message.length()-1; i++)//parse(?) 
      {
        if(message.substring(i,i+1).equals(" "))//if space, stop loop.
        {
          portion = message.substring(0,i-1);//takes the part before the space.
          message = message.substring(i, message.length());//takes rest of the message minus the space.
        }
        match(portion);
      }
    }
  }
  
  public String match(String portion)//takes letter, matches it to grid.
  {
    String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};//declares array with every letter
    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};// international morse code A-Z
    
    String letter = "";//final returned letter. match it with original sent through line?
    return letter;
  }
}