import java.util.Scanner;

public class Main extends FileClass{
    static Scanner scan = new Scanner(System.in);
    static void working()
    {
        System.out.println("Working : ");
    }
    public static void main(String[] args) {
        AllFiles ag = new AllFiles();
        
        ag.loadFiles();
       

        String choice ;
        Manu menu = new Manu();
        do{
             choice = menu.menu1(scan);

            switch (choice) {
                case "1":
                    // Call the createFile method
                    ag.createNewFile();
                    break;
                case "2":
                    // Call the readFile method
                    ag.readOneFile();
                    break;
                case "3":
                    // Call the writeFile method
                    ag.writeOneFile();
                    
                    break;
                
                case "4":
                    ag.deletOneFile();
                    break;
                case "0":
                    System.out.println("Thank you for using the program.");
                    break ;
                default:
                    // Invalid choice
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        }while(choice.compareTo("0") != 0 ); 
        System.out.println("working: "); 
         
            
    ag.uploadInFile();
    return ;
        
    }
}
