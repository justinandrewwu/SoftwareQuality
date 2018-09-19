//Name: Peri Smith
//Java Code for reading through Simple Class

//package Simple;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SimpleReader{

  public static void main(String[] args) throws FileNotFoundException {
//declare File
    File file = new File("Simple.java");
    //initialize Scanner
    FindMethods(file);
    WorkingMethods(file);
    //Sequence(file);

    }


  public static void FindMethods(File file) throws FileNotFoundException{
    Scanner scan = new Scanner(file);
    String[] met = {
      "Simple()",
      "Simple(String text, Number number, Boolean truth, Integer initVals, int depth) ",
      "flip()",
      "nextInSequence()",
      "number()",
      "text()",
      "toString()",
      "truth()"
    };
    int size = met.length;

    //iterate thru File
    System.out.println("Methods In Class : ");
    for (int i = 0; i<size; i++)
    {
      while(scan.hasNextLine()){
        String str = scan.findInLine(met[i]);
        if(str != null){
          System.out.println(met[i] + " : Pass");
          break;
        }
        else{
          System.out.println(met[i] + " : Fail");
          break;
        }

    }
  }
}

  public static void WorkingMethods(File file){
    System.out.println("Do Methods Work: ");
    Simple mysimple = new Simple();

    //Test flip() and Truth()
    if(mysimple.truth() == true){
      mysimple.flip();
        if(mysimple.truth() == true){
          System.out.println("Flip : Fail");
          }
        else{
          System.out.println("Flip : Pass");
          System.out.println("Truth : Pass");
        }
    }
    else{
      mysimple.truth();
      if(mysimple.truth() == true){
        System.out.println("Flip : Pass");
        System.out.println("Truth : Pass");
        }
      else{
        System.out.println("Flip : Fail");
      }
    }

    //Test nextInSequence
    System.out.println("Does nextInSequence work: ");
    //int d = mysimple.depth;
    int x = mysimple.nextInSequence();
    int y = mysimple.nextInSequence();
    int z = mysimple.nextInSequence();
    int a = mysimple.nextInSequence();
    int b = mysimple.nextInSequence();
    //System.out.println("depth : " + d);
    System.out.println("first : " + x);
    System.out.println("second : " + y);
    System.out.println("third : " + z);
    System.out.println("fourth : " + a);
    System.out.println("fifth : " + b);

    //Test toString()
    System.out.println("Does toString work? ");
    String str = mysimple.toString();
    System.out.println(str);

  }

  /*public static void Sequence(File file){
  //Sequences
  Simple mysimple = new Simple();
  mysimple.Integer[] seq = [1,2,3];
  String test = "test";
  mysimple.Simple(test, 12, true, seq, 0);
  System.out.println(" What sequence can we produce?");

}*/
}
