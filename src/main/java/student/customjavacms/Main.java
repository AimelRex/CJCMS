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
        boolean modDone = true;
        String SelectedFile = null;
        Scanner sc = new Scanner(System.in);
        while (!done){
            // System.out.println( "\nWhat would you like to do ?" );
            String answer = sc.next();
            switch (answer.toLowerCase()){
                case "h":
                case "help":
                    System.out.println("=======================================================\n~~MAIN help page~~");
                    System.out.println("\nhelp      >   show you all commands and their use");
                    System.out.println("\ncreate    >   create a new file and ask you the name of it");
                    System.out.println("\nselect    >   select a file to work on it");
                    System.out.println("\nmodify    >   enter the modify menu");
                    System.out.println("\nstop      >   close the program");
                    System.out.println("=======================================================");
                    sc.nextLine();
                    break;

                case "create":
                    System.out.println(">Enter a file name to create it :");
                    String CreatedFile = sc.next();
                    FileManager.CreateFile(CreatedFile);
                    break;
                
                case "select":
                    System.out.println(">Enter a file name to select it :");
                    SelectedFile = sc.next();
                    SelectedFile = FileManager.SelectFile(SelectedFile);
                    break;
                
                case "mod":
                case "modify":
                    if (SelectedFile == null){
                        System.out.println(">You have to select a file before modifying it.");
                    } else {
                        modDone = false;
                        System.out.println("\n=======================================================\nYou are now in the MODIFY menu.");
                        while(!modDone){
                            // System.out.println( "\nWhat would you like to do ?" );
                            String modAnswer = sc.next();
                            switch (modAnswer) {
                                case "h":
                                case "help":
                                    System.out.println("=======================================================\n~~MODIFY help page~~");
                                    System.out.println("\nhelp      >   show you all commands and their use");
                                    System.out.println("\nexit      >   exit this menu to go back to the main menu");
                                    System.out.println("=======================================================");
                                    break;
                                
                                case "main":    
                                case "exit":
                                    System.out.println(">Going back to main menu.");
                                    modDone = true;
                                    break;
                                    
                                default:
                                    System.out.println(">This command does not exists, type help to show commands.");
                                    break;
                            }
                        }

                    }
                    System.out.println("\n=======================================================\nYou are now in the MAIN menu.");
                    break;

                case "close":
                case "stop":
                    System.out.println(">Goodbye ! Thanks for using CJCMS.");
                    done = true;
                    break;

                default:
                    System.out.println(">This command does not exists, type help to show commands.");
                    break;
            }
        }
    }
}
