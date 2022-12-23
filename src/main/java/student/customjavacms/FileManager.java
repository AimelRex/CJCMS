package student.customjavacms;
import java.io.File; 
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
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

  //ADD THE BASICS
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

  //CHANGE THE TITLE
  public static void TitleChanger(String filename, String title){
    System.out.println(">Changing the title.");
    File toModify = new File(filename);
    String old ="";
    try{
      BufferedReader BReader = new BufferedReader(new FileReader(toModify));
      String line = BReader.readLine();
      while (line != null) 
      {
        if(line.contains("<title>")){
          old=old+"<title>"+title+"</title>"+System.lineSeparator();
        }else{
          old = old + line + System.lineSeparator();
        }
        line = BReader.readLine();
      }
      FileWriter writer = new FileWriter(toModify);    
      writer.write(old);
      writer.close();
      BReader.close();
      System.out.println(">Successfully changed title.");
    } catch(IOException e){
      System.out.println(">An error occurred.");
      e.printStackTrace();
    }
    
  }
    
    
    
    
    
    
    
    
    

}