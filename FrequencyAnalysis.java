//Amanda Nakanishi
//1/30/14
//Frequency analysis method. Returns either table of values or individual value for letter requested. In %
import java.util.Scanner;
public class FrequencyAnalysis
{
  public static void main(String[]args)
  {
    int messageLength = 0;//declares and initializes length of message
    Scanner kb = new Scanner(System.in);//sets up scanner
    System.out.println("Put message.");
    String message = kb.nextLine();//input into console.
    String analyze = message.toLowerCase();//sets all letters to standard case
    messageLength = analyze.length();//sets length of message
    System.out.println("1. Search for individual letter");
    System.out.println("2. Print whole chart");
    int answer = kb.nextInt();//whether or not whole thing
    if (answer==1)//if want percent on specific letter
    {
      System.out.println("Which letter?");
      kb.nextLine();//because it reads the new line, so I listened to Ms. Nagoshi.
      String letter = kb.nextLine();//input letter stuffs
      int letterNumber = letter(letter, analyze);//letter looking for, message string, gets number of times letter appears
      double percent = percentage(letterNumber,analyze);//letter looking for, message string, gets percent value of #
      System.out.println(letter + " = " + percent);//prints out percentage for that one letter
    }
    else if(answer == 2)//if want a list of percentages
    {
      for(int i = 0; i<26; i++)//for loop, going through each letter in the alphabet
      {
        String letter = String.valueOf((char)(i+97));//Ms. Nagoshi helped me. She found this on the internet. Had to adapt it to lowercase
        int letterNumber = letter(letter,analyze);//finds number of occurrences of letter
        double percent = percentage(letterNumber,analyze);//gets percentage for letter
        System.out.println(letter + " = " + percent);//prints out percentage for that one letter
      }
    }
  }
  
  public static int letter(String letter, String analyze)//takes letter and string
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
  
  public static double percentage(int letterNumber, String analyze)//takes number, and string converts it to percentage
  {
    Double percent = (double)letterNumber/analyze.length();//changes it to percentages
    return percent;
  }
}
  