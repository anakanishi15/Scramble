//Amanda Nakanishi
//1/30/14
//Frequency analysis method. Returns either table of values or individual value for letter requested. In %
import java.util.*;//means import everything from java utilities, which is what * means
import java.io.*;

public class FrequencyAnalysis
{
  private String message;//instance variable
  private String nameVariable;
  
  public FrequencyAnalysis(String newmessage, String name)//constructor
  {
    message = newmessage;//input = message
    nameVariable = name;//takes name
  }
  
  public void setUp() throws IOException//sets up format of the final chart. 
  {
    int messageLength = 0;//declares and initializes length of message
    Scanner kb = new Scanner(System.in);//sets up scanner
    String analyze = message.toUpperCase();//sets all letters to standard case
    messageLength = analyze.length();//sets length of message
    System.out.println("1. Search for individual letter");
    System.out.println("2. Print whole chart");
    int answer = kb.nextInt();//whether or not whole thing
    if (answer==1)//if want percent on specific letter
    {
      System.out.println("Which letter?");
      kb.nextLine();//because it reads the new line, so I listened to Ms. Nagoshi.
      String letter = kb.nextLine().toUpperCase();//input letter stuffs, turns it into uppercase so it works with the letters
      int letterNumber = letter(letter, analyze);//letter looking for, message string, gets number of times letter appears
      double percent = percentage(letterNumber,analyze);//letter looking for, message string, gets percent value of #
      message = (letter + " = " + percent + "%");//prints out percentage for that one letter
      File end = new File(nameVariable + "FrequencyAnalysis" + letter + ".txt");//saves document as [inputted name][FrequencyAnalysis][letter in question].txt
      FileWriter wr = new FileWriter(end);//yay internet. Writes text to file. This gets the file in question
      wr.write(message);//writes message to file. REWRITES ANY EXISTING TEXT. BE CAREFUL.
      wr.close();//closes
    }
    else if(answer == 2)//if want a list of percentages
    {
      String nMessage = "";
      for(int i = 0; i<26; i++)//for loop, going through each letter in the alphabet
      {
        String letter = String.valueOf((char)(i+65));//Ms. Nagoshi helped me. She found this on the internet. Works with decimal
        int letterNumber = letter(letter,analyze);//finds number of occurrences of letter
        double percent = percentage(letterNumber,analyze);//gets percentage for letter
        nMessage += (letter + " = " + percent + "%\n");//prints out percentage for that one letter
      }
      File end = new File(nameVariable + "FrequencyAnalysiswhole.txt");
      FileWriter wr = new FileWriter(end);//yay internet. Writes text to file. This gets the file in question
      wr.write(nMessage);//writes message to file. REWRITES ANY EXISTING TEXT. BE CAREFUL.
      wr.close();//closes
    }
    System.out.println("done."); //informs user of completed task
  }
  
  public int letter(String letter, String analyze)//takes letter and string
  {
    int count = 0;//count of letter
    for(int i = 0; i<analyze.length(); i++)//runs through whole string looking for that letter
    {
      if(analyze.substring(i,i+1).equals(letter))//checks for letter
      {
        count++;//adds one
      }
    }
    return count;//returns count of that letter
  }
  
  public double percentage(int letterNumber, String analyze)//takes number, and string converts it to percentage
  {
    Double percent = (double)letterNumber/analyze.length();//changes it to decmials
    percent = percent*100;//turns it into a percent
    String cutPercent = Double.toString(percent);//sets to string (internet)
    if(cutPercent.length()>5)
    {
    cutPercent = cutPercent.substring(0,5);//Goes to three decimals points, always rounds down. 
    }
    percent = Double.parseDouble(cutPercent);//turns it back into double. (internet)
    return percent;
  }
}
