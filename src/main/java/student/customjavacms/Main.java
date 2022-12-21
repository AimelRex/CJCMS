package student.customjavacms;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println("=======================================================\n ______       __     ______     __    __     ______    \n/\\  ___\\     /\\ \\   /\\  ___\\   /\\ '-./  \\   /\\  ___\\   \n\\ \\ \\____   _\\_\\ \\  \\ \\ \\____  \\ \\ \\-./\\ \\  \\ \\___  \\  \n \\ \\_____\\ /\\_____\\  \\ \\_____\\  \\ \\_\\ \\ \\_\\  \\/\\_____\\ \n  \\/_____/ \\/_____/   \\/_____/   \\/_/  \\/_/   \\/_____/ \n");
        System.out.println("Welcome to CJCMS !\nA Custom Java Content Manager System\nMade by AimelRex\n=======================================================");
        boolean done = false;
        Scanner sc = new Scanner(System.in);
        while (!done){
            System.out.println( "\nWhat would you like to do ? (type help to show commands)" );
            String answer = sc.next();
            switch (answer.toLowerCase()){
                case "help":
                    System.out.println("\nWelcome to the help menu, just press enter to exit this menu.");
                    sc.nextLine();
                    break;

                case "create":
                    System.out.println("Enter a file name :");
                    String filename = sc.next();
                    CreateFile.main(filename);
                    break;

                case "stop":
                    System.out.println("Goodbye ! Thanks for using CJCMS.");
                    done = true;
                    break;

                default:
                    System.out.println("Type help to show commands.");
                    break;
            }
        }
        sc.close();
    }
}
