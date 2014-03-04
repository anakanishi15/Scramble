//Amanda Nakanishi
//2/4/14
//Monoalph encrypt/decrypt

import java.util.*;//means import everything from java utilities, which is what * means
import java.io.*;

public class Monoalph
{
  private String message = "";//instance variable
  private String fileName;
  
  public Monoalph(String newmessage, String name)
  {
    message = newmessage;//constructor
    fileName = name;
  }
  
  public void setUp() throws IOException//sets up format of the final chart
  {
    String[] cyphertext = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};//declares array with every letter
    String[] plaintext = new String[26];//declares array for plaintext. Cyphertext stays in place, array is blank so can input.
    Scanner kb = new Scanner(System.in);//sets up Scanner
    message = message.toUpperCase();//converts message to uppercase.
    System.out.println("Which mode do you want?");//prompt
    System.out.println("1. Caesar");//for Caesar shift.
    System.out.println("2. Monoalph");//for all other monoalphs
    int mode = kb.nextInt();//takes in number choice
    int cIndex = 900; //to save index of Cyphertext grid to.
    int pIndex = 900;//on both of these, to error out if something is wrong. Cause I'd rather have it do that than work and be wrong.
    String cLetter = "";//input for the cyphertext letter
    String pLetter = "";//input for the plaintext letter.
    if (mode == 1)
    {
      System.out.println("Please enter cyphertext letter.");//prompt
      kb.nextLine();//was reading the return as another line, so it filled the next one. 
      cLetter = kb.nextLine().toUpperCase();//need to have it uppercase to trigger
      for (int i = 0; i < 26; i++)//for loop to run through array
      {
        if (cyphertext[i].equals(cLetter))//locates the cyphertext letter. I think I'd prefer to have it return the number, but that would mean this would have to be a separate method....
        {
          cIndex = i;//saves the index of the matching cyphertext letter.
        }
      }
      System.out.println("Please enter matching plaintext letter.");//prompt
      pLetter = kb.nextLine().toUpperCase();//needs to be uppercase to run match so can find right space
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
      for (int i = 0; i < 26; i++)
      {
        message = message.replaceAll(cyphertext[i], plaintext[i]);//replaces each letter. Can't be in previous for loop because of unfilled overlap.
      }
      File end = new File(fileName + "MonoalphCaesar.txt");//want to specify key?
      FileWriter wr = new FileWriter(end);//yay internet. Writes text to file. This gets the file in question
      wr.write(message);//writes message to file. REWRITES ANY EXISTING TEXT. BE CAREFUL.
      wr.close();//closes
    }
    else if(mode == 2)    
    {
      int check = 0;//needs to return extra line on the first time.
      int printNum = 0;//to see which iteration of the print it is. So things don't get overwritten
      while((!(cLetter.equals("END")))||(!(pLetter.equals("END"))))//MIGHT CONSIDER JUST OVERRIDE IF SEE END, CAUSE OTHERWISE SCREWS UP SETUP.
      {
        System.out.println("Please enter cyphertext letter, 'print', or 'end'.");//prompt, need to repeat it 
        if (check == 0)//need this, otherwise skips first one.
        {
          kb.nextLine();//so that it has both boxes, cause otherwise the enter cancels it.
        }
        cLetter = kb.nextLine().toUpperCase();//needs to be uppercase to run match so can find right space
        if((cLetter.equals("PRINT")) || (pLetter.equals("PRINT")))//if print is typed in
        {
          printNum++;
          File end = new File(fileName + "Monoalphprint" + printNum + ".txt");//name of file
          for (int i = 0; i < 26; i++)//gets stuck here. why? works fine up.
          {
            if(!(plaintext[i] == null))
            {
              message = message.replaceAll(cyphertext[i], plaintext[i]);//replaces each letter. Can't be in previous for loop because of unfilled overlap.
            }
          }
          FileWriter wr = new FileWriter(end);//yay internet. Writes text to file. This gets the file in question
          wr.write(message);//writes message to file.
          wr.close();//closes
        }
        else if(!(cLetter.equals("END")))
        {
          System.out.print("loading");
          for (int i = 0; i<26; i++)
          {
            if (cyphertext[i].equals(cLetter))//locates the cyphertext letter
            {
              cIndex = i;//saves the index of the matching cyphertext letter.
            }
          }
          System.out.println("Please enter matching plaintext letter, 'end', or 'print'.");//prompt
          pLetter = kb.nextLine().toUpperCase();//need to have it uppercase to trigger
          plaintext[cIndex] = pLetter.toLowerCase();//finds corresponding block in plaintext array and fills it with the plaintext letter inputted.
          check = 1;
        }
      }
      for (int i = 0; i < 26; i++)//for when you want to print and not come back.
      {
        message = message.replaceAll(cyphertext[i], plaintext[i]);//replaces each letter. Can't be in previous for loop because of unfilled overlap.
      }
      File end = new File(fileName + "Monoalph.txt");
      FileWriter wr = new FileWriter(end);//yay internet. Writes text to file. This gets the file in question
      wr.write(message);//writes message to file. REWRITES ANY EXISTING TEXT. BE CAREFUL.
      wr.close();//closes
    }
    System.out.println("done");
  }
  //should make a fill method?
}
//do something like input letter, but if want to end, type end. cause char. maybe if caesar cypher type caesar