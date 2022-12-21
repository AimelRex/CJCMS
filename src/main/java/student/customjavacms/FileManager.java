package student.customjavacms;
import java.io.File; 
import java.io.IOException;
import java.util.Scanner;


public class FileManager {

  public static void CreateFile(String filename) {
    try {
      File f = new File(filename);
      if (f.createNewFile()) {
        System.out.println(">File created : " + f.getName());
      } else {
        System.out.println(">File already exists.");
      }

    } catch (IOException e) {
      System.out.println(">An error occurred.");
    }
  }


  public static String SelectFile(String filename){
    Scanner scf = new Scanner(System.in);
    File f = new File(filename);
    if(f.exists() && !f.isDirectory()) { 
      System.out.println(">File has been selected");
      
      return filename;
    } else{
      System.out.println(">File doesn't exist, would you like to create it ? y/n");
      String ChoiceCreate = scf.nextLine();
      switch (ChoiceCreate.toLowerCase()) {
        case "y":
        case "yes":
          System.out.println(">File will be created...");
          FileManager.CreateFile(filename);
          System.out.println(">File has been selected");
          return filename;
        
        default:
          System.out.println(">This command does not exists");
          

        case "n":
        case "no":
          System.out.println(">File will not be created.");
          return null;
      
      }

    }
    
  }
}