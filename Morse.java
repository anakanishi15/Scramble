//Amanda Nakanishi
//2/21/14
//Morse Code. I got bored

import java.util.*;//means import everything from java utilities, which is what * means
import java.io.*;

public class Morse
{
  private String message = "";//instance variable
  private String fileName = "";
  private String portion = "";//for taking portion without space.
  private String print = "";//to save message final to.
  
  
  public Morse(String newmessage, String name)
  {
    message = newmessage;//constructor
    fileName = name;
  }
  
  public void setUp()throws IOException//sets up morse code 
  {
    String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};//declares array with every letter
    while(message.length() > 0)//while there's still characters in the message
    {
      for(int i = 0; i<message.length()-1; i++)//parse(?) 
      {
        if(message.substring(i,i+1).equals(" "))//if space, stop loop.
        {
          portion = message.substring(0,i);//takes the part before the space.
          message = message.substring(i+1, message.length());//takes rest of the message minus the space.
        System.out.println(portion);
        System.out.println(message);
        }
        int morseIndex = match(portion);
        String character = english[morseIndex];
        print += character; 
      }
    }
    File end = new File(fileName + "Morse.txt");//name of file
    FileWriter wr = new FileWriter(end);//yay internet. Writes text to file. This gets the file in question
    wr.write(print);//writes message to file. REWRITES ANY EXISTING TEXT. BE CAREFUL.
    wr.close();//closes
  }
  
  public int match(String str)//takes letter, matches it to grid.
  {
    portion = str; 
    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};// international morse code A-Z
    for(int i = 0; i<26; i++)
    {
      if(morse[i].equals(portion))
      {
        //System.out.println(i);
        return i;
      }
    }
    return 0;//won't ever need a return statement, cause will get no matter what. What do you put there?
  }
}

//right now it can separate the character correctly, it gets rid of the spaces and delete the character from the message for the first one, but after that, it screws up.
// for the first separated character, it works fine. After that, it's bad.