package student.customjavacms;
import java.util.Scanner;

/**
 * CJCMS
 * Made by AimelRex
 */
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println("=======================================================\n ______       __     ______     __    __     ______    \n/\\  ___\\     /\\ \\   /\\  ___\\   /\\ '-./  \\   /\\  ___\\   \n\\ \\ \\____   _\\_\\ \\  \\ \\ \\____  \\ \\ \\-./\\ \\  \\ \\___  \\  \n \\ \\_____\\ /\\_____\\  \\ \\_____\\  \\ \\_\\ \\ \\_\\  \\/\\_____\\ \n  \\/_____/ \\/_____/   \\/_____/   \\/_/  \\/_/   \\/_____/ \n");
        System.out.println("Welcome to CJCMS !\nA Custom Java Content Manager System\nMade by AimelRex\nType help to show commands\n=======================================================");
        boolean done = false;
        String SelectedFile = null;
        Scanner sc = new Scanner(System.in);
        while (!done){
            System.out.println( "\nWhat would you like to do ?" );
            String answer = sc.next();
            switch (answer.toLowerCase()){
                case "h":
                case "help":
                    System.out.println("\nWelcome to the help menu, just press enter to exit this menu.");
                    System.out.println("\nhelp      >   show you all commands and their use");
                    System.out.println("\ncreate    >   create a new file and ask you the name of it");
                    System.out.println("\nselect    >   select a file to work on it");
                    System.out.println("\nmodify    >   enter the modify menu");
                    System.out.println("\nstop      >   close the program");
                    sc.nextLine();
                    break;

                case "create":
                    System.out.println("Enter a file name to create it :");
                    String CreatedFile = sc.next();
                    FileManager.CreateFile(CreatedFile);
                    break;
                
                case "select":
                    System.out.println("Enter a file name to select it :");
                    SelectedFile = sc.next();
                    SelectedFile = FileManager.SelectFile(SelectedFile);
                    break;
                
                case "mod":
                case "modify":
                    if (SelectedFile == null){
                        System.out.println("You have to select a file before modifying it.");
                    } else {
                        System.out.println("Yaaay");
                    }
                    
                    break;

                case "close":
                case "stop":
                    System.out.println("Goodbye ! Thanks for using CJCMS.");
                    done = true;
                    break;

                default:
                    System.out.println("This command does not exists, type help to show commands.");
                    break;
            }
        }
    }
}
