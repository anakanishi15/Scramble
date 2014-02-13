//Amanda Nakanishi
//2/4/14
//Monoalph encrypt/decrypt

import java.util.Scanner;

public class Monoalph
{
  public static void main(String[]args)
  {
    String[] cyphertext = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};//declares array with every letter
    String[] plaintext = new String[26];//declares array for plaintext. Cyphertext stays in place, array is blank so can input.
    Scanner kb = new Scanner(System.in);//sets up Scanner
    System.out.println("Please enter message");//prompt. I sort of want to leave it all blank, the prompts because that way only I'd know what to do.
    String message = kb.nextLine().toUpperCase();//takes in message, converts it to uppercase.
    System.out.println("Which mode do you want?");//prompt
    System.out.println("1. Caesar");//for Caesar shift.
    System.out.println("2. Monoalph");//for all other monoalphs
    int mode = kb.nextInt();//takes in number choice
    int cIndex = 900; //to save index of Cyphertext grid to.
    int pIndex = 900;//on both of these, to error out if something is wrong. Cause I'd rather have it do that than work and be wrong.
    if (mode == 1)
    {
      System.out.println("Please enter cyphertext letter.");//prompt
      kb.nextLine();//was reading the return as another line, so it filled the next one. 
      String cLetter = kb.nextLine().toUpperCase();//need to have it uppercase to trigger
      for (int i = 0; i < 26; i++)//for loop to run through array
      {
        if (cyphertext[i].equals(cLetter))//locates the cyphertext letter. I think I'd prefer to have it return the number, but that would mean this would have to be a separate method....
        {
          cIndex = i;//saves the index of the matching cyphertext letter.
        }
      }
      System.out.println("Please enter matching plaintext letter.");//prompt
      String pLetter = kb.nextLine().toUpperCase();//needs to be uppercase to run match so can find right space
      {
        for (int i = 0; i<26; i++)
        {
          if (cyphertext[i].equals(pLetter))//locates the plaintext letter (in the cyphertext grid).
          {
            pIndex = i;//saves the index of the matching plaintext letter.
          }
        }
      }
      for (int i = 0; i < 26; i++)//sets up for loop to fill the plaintext grid
      {
        plaintext[((i+cIndex)%26)] = cyphertext[((i+pIndex)%26)].toLowerCase();//fills the plaintext grid. Since cyphertext is ordered alphabetically, can just set index of plaintext that want to start on, and work from there.
        //has to be cIndex in plaintext array because you're finding the matching cyphertext index so you know which index to put into.
      }
    }
  }
  else if(mode == 2)
  {
    String cLetter = "";//declaring string.
    int check = 0;//needs to return extra line on the first time.
    while(!(cLetter.equals("END")))//MIGHT CONSIDER JUST OVERRIDE IF SEE END, CAUSE OTHERWISE SCREWS UP SETUP.
    {
      System.out.println("Please enter cyphertext letter, 'print', or 'end'.");//prompt, need to repeat it 
      if (check == 0)//need this, otherwise skips first one.
      {
        kb.nextLine();//so that it has both boxes, cause otherwise the enter cancels it.
      }
      cLetter = kb.nextLine().toUpperCase();//needs to be uppercase to run match so can find right space
      if(cLetter.equals("print"))//if print is typed in
      {
        //print array, but come back
      }
      {
        for (int i = 0; i<26; i++)
        {
          if (cyphertext[i].equals(cLetter))//locates the cyphertext letter
          {
            cIndex = i;//saves the index of the matching cyphertext letter.
          }
        }
        System.out.println("Please enter matching plaintext letter.");//prompt
        String pLetter = kb.nextLine().toUpperCase();//need to have it uppercase to trigger
        plaintext[cIndex] = pLetter.toLowerCase();//finds corresponding block in plaintext array and fills it with the plaintext letter inputted.
        check = 1;
      }
      //print out message
    }
    for (int i = 0; i<26; i++)//to print array. Delete later.
    {
      System.out.println(cyphertext[i]);
      System.out.println(plaintext[i]);
    }
  }
}
}
//do something like input letter, but if want to end, type end. cause char. maybe if caesar cypher type caesar