package student.customjavacms;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner;


public class CreateFile {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nEnter a filename :");
    String filename = sc.next();
    sc.close();
    try {
      File theFile = new File(filename);
      if (theFile.createNewFile()) {
        System.out.println("File created: " + theFile.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}