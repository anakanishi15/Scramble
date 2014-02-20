//Amanda Nakanishi
//Driver
//2/14/14

import java.util.Scanner;

public class ScrambleDriver
{
  public static void main(String[]args)
  {
    Scanner kb = new Scanner(System.in);//sets up scanner
    System.out.println("1. Frequency Analysis");//choices
    System.out.println("2. Monoalph");
    int choice = kb.nextInt();//takes in choice
    System.out.println("Please input the message.");
    String message = kb.nextLine();//takes in message
    if (choice == 1)
    {
      FrequencyAnalysis thing = new FrequencyAnalysis(message);
    }
  }
}