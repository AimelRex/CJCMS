package student.customjavacms;
import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class FileManager {

  // CREATE A FILE
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

  // SELECT A FILE
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

  //ADDS THE BASICS
  public static void BasicTemplate(String filename){
    try {
      File myObj = new File("template.html");
      Scanner Reader = new Scanner(myObj);
      File file = new File(filename);
      try {
        FileWriter Writer = new FileWriter(file);// to append don't forget it's FileWriter(file, true)
        while (Reader.hasNextLine()) {
          String data = Reader.nextLine();
          Writer.write(data);
          Writer.write(System.lineSeparator());
        }
        Writer.close();
        Reader.close();
        System.out.println(">Successfully wrote to the file.");
      }catch (IOException z){
        System.out.println(">An error occurred.");
        System.out.print(z.getMessage());
      }
      
    
    } catch (FileNotFoundException e) {
      System.out.println(">An error occurred.");
      e.printStackTrace();
    }
  }

}