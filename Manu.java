import java.util.Scanner;

public class Manu {

    public String menu1(Scanner input) 
    {

    
        String choice ;
        System.out.println("\n=========================================");
            System.out.println("Page : 1");
            System.out.println("---------------------------------------");

            System.out.println("Menu:");
            System.out.println("1. Create a file");
            System.out.println("2. Read a file");
            System.out.println("3. Write a file");
            System.out.println("4. Delet a file ");
            System.out.println("0. Exit");
            System.out.println("---------------------------------------");

            System.out.print("Enter your choice: ");
            choice = input.next();
            System.out.println("=========================================");

            return choice;
    }

    public String menu2(Scanner input) {

        System.out.println("\n=========================================");

        String choice ;
            System.out.println("---------------------------------------");

            System.out.println("Page : 2");
            System.out.println("Menu 2 :");
            System.out.println("1. Write in file : ");
            System.out.println("2. Read a file");
            System.out.println("3. Change Name : ");
            System.out.println("4. Change Password : ");
            System.out.println("0. Exit");
            System.out.println("---------------------------------------");
            System.out.print("Enter your choice: ");
            choice = input.next();
            System.out.println("=========================================");

            return choice;
        }



}
