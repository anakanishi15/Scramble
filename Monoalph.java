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
    String message = kb.nextLine().toUpperCase();//takes in message, converts it to uppercase.
    /*
     * Ask what mode? Caesar or Monoalph. 1 & 2 respectively
     * 
     * Within caesar, ask for key letters. Should be A = __, but need to set it such that anything. 
     * So then will have to run a match check and match with lowercase array letter
     * interpolate(?) extrapolate(?) backwards to get where a should be, then fill array with standard
     * decimal numbers? Not too hard. String letter = String.valueOf((char)(i+65)); <- that code.
     * 
     * Within Monoalph, find which capitol letter you're matching with. Take index of that array space
     * match it within the lowercase letter array, fill that space with the lowercase letter.
     * Should I print it out after each letter?
     * Print out only after type end?
     * Could type out 'print' if need to.
     * Yeah, then end would just end the method, print would just continue it
     */
    for (int i = 0; i<26; i++)//to print array. Delete later.
    {
      System.out.println(cyphertext[i]);
    }
  }
}

//do something like input letter, but if want to end, type end. cause char. maybe if caesar cypher type caesar