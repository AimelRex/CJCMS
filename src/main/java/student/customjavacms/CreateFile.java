package student.customjavacms;
import java.io.File; 
import java.io.IOException;
import java.util.Scanner;


public class CreateFile {
  public static void main(String filename) {
    try {
      File theFile = new File(filename);
      if (theFile.createNewFile()) {
        System.out.println("File created: " + theFile.getName());
      } else {
        System.out.println("File already exists.");
      }

    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
  }
}