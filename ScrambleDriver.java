//Amanda Nakanishi
//Driver
//2/14/14

import java.util.*;//means import everything from java utilities, which is what * means
import java.io.*;

public class ScrambleDriver
{
  public static void main(String[]args) throws IOException//Ms. Nagoshi helped me. if no file is found, throws error that says no file found. Try catch exception? File not found exception needs to be also can write 'throws FileNotFoundException'
    //why does 'throws FileNotFoundException' not always work for more than one.
  {
    String message = "";//sets up variable for message
    Scanner kb = new Scanner(System.in);//sets up scanner
    System.out.println("put file name");
    String name = "./Files/" + kb.nextLine();//for file name. Ms. Nagoshi helped me with this part. (The next like 6 lines)
    Scanner x = new Scanner(new File(name));//to read in file.
    while (x.hasNext())//while there's still something new to be read in
    {
      message += x.nextLine();//will read in the file
    }
    //message = message.replaceAll("[^A-Za-z0-9]", "");//from stackoverflow. Replaces all nonalphanumeric characters
    //do you want to strip punctuation or spaces or...?
    System.out.println(message);
    System.out.println("1. Frequency Analysis");//choices
    System.out.println("2. Monoalph");
    int choice = kb.nextInt();//takes in choice
    if (choice == 1)
    {
      FrequencyAnalysis thing = new FrequencyAnalysis(message);//new object
      thing.setUp();//runs the message through frequency analysis
    }
    else if(choice == 2)
    {
      Monoalph thing = new Monoalph(message);//new object
      thing.setUp();//runs the monoalph
    }
  }
}

//system arguments... preface file with ./foldername
//do I want to create a new file if none are found? File [file name here] = new File(filename+".txt"); file.createNewFile();