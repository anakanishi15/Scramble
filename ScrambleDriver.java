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
    System.out.println("Existing file? Yes/No");
    String exist = kb.nextLine().toLowerCase();//if a file exists
    if (exist.equals("yes"))//Bri's idea to check if want to make a file.
    {
      System.out.println("put file name (including extentions)");
      String name = "./Files/" + kb.nextLine();//for file name. Ms. Nagoshi helped me with this part. (The next like 6 lines)
      Scanner x = new Scanner(new File(name));//to read in file.
      while (x.hasNext())//while there's still something new to be read in
      {
        message += x.nextLine();//will read in the file
      }
    }
    else if(exist.equals("no"))//if file doesn't exist. Note: be careful with strings and ==
    {
      System.out.println("Type file name. Don't put the extention");
      String newFileName = kb.nextLine();
      File different = new File("./Files/" + newFileName + ".txt");//file name + .txt to make the file Part before is for location.
      //WHAT IF SAME FILE EXISTS? OVERWRITE? Won't overwrite.
      different.createNewFile();
      System.out.println("Enter text.");//prompt
      message = kb.nextLine();//gets text
      FileWriter wr = new FileWriter(different);//yay internet. Writes text to file. This gets the file in question
      wr.write(message);//writes message to file. REWRITES ANY EXISTING TEXT. BE CAREFUL.
      wr.close();//closes
      //want to write text to document here.
    }
    System.out.println(message);
    System.out.println("1. Frequency Analysis");//choices
    System.out.println("2. Monoalph");
    int choice = kb.nextInt();//takes in choice
    if (choice == 1)
    {
      FrequencyAnalysis thing = new FrequencyAnalysis(message);//new object
      thing.setUp();//runs the message through frequency analysis
      //want result to be printed to file. Create new one, probably. So there's one for the start text, and one for the finish.
    }
    else if(choice == 2)
    {
      Monoalph thing = new Monoalph(message);//new object
      thing.setUp();//runs the monoalph
      //same as in Freq Ana part.
    }
  }
}

//system arguments... preface file with ./foldername