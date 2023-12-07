import java.util.Scanner;
// import java.io.*;
// import java.nio.file.FileStore;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

class AllFiles {
    static Scanner scan = new Scanner(System.in);
    static int numberOfFiles ;
    public  ArrayList<FileClass>ObjectOfFiles;
    ArrayList<String>usedPassword;

    AllFiles()
    {
        numberOfFiles = 0;
        ObjectOfFiles = new ArrayList<>();
       
    }

    int length()
    {
        return ObjectOfFiles.size();

    }
    void loadFiles()
    {
        
       ObjectInputStream ois = null;
        try{

            ois = new ObjectInputStream(new FileInputStream("NamesOfAllFilesOfProject.txt"));

            while(true)
            {
                try {
                    ObjectOfFiles.add((FileClass)ois.readObject());
                } 
                catch (Exception e) {
                // System.out.println(e);
                // System.out.println("bhi excpetion all file line deck lena : ");
                break;
                }    
            }

        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Loading is falid : ");
        }

        try 
        {
            ois.close();
        } 
        catch (Exception e) {
            System.out.println("File is not closed : ");
        }
                 
    }
    void uploadInFile()
    {
         ObjectOutputStream oas = null;

         try {
                oas = new ObjectOutputStream(new FileOutputStream("NamesOfAllFilesOfProject.txt"));

         } catch (Exception e) {
            System.out.println("Eroor data is not uploaded : ");
         }

         for(FileClass f: ObjectOfFiles){
            
            try {
                oas.writeObject(f);
               // System.out.println("files is Uploaded : ");

            } catch (Exception e) {

                System.out.println("error is uploading : ");
            }
         }

         try {
                oas.close();

         } catch (Exception e) {
           System.out.println("time is not closed at the tiem of uploading : ");
         }


         System.out.println(" finally : files uploaded : ");
         
    }
    

    String setPassword(String s)
    {
        return s;
    }

    //=======================================================================
    void createNewFile()
    {
        String name,pass = null;
        System.out.print("Enter Name of File : ");
        name = scan.next();
        System.out.print("Enter Password :");
        pass = scan.next();
        pass = setPassword(pass);
        if(pass == null)
        {
            System.out.println("file canot be created : ");
            return ;
        }
        FileClass fileObj = new FileClass();
        fileObj.newFile(name, pass);
        System.out.println("File Created : ");
        numberOfFiles++;
        ObjectOfFiles.add(fileObj);


        Manu menu = new Manu();
        String choice;


        do{
            choice = menu.menu2(scan);

           switch (choice) {
               case "1":
                   // Call the createFile method
                   fileObj.writeFile(fileObj.getPassword());
                   break;
               case "2":
                   // Call the readFile method
                   
                   fileObj.readFile(fileObj.getPassword());

                   break;
               case "3":
                  
                   fileObj.changeName();
                
                   break;
                
                case "4":

                    fileObj.changePassword();
               case "0":
                   
                   System.out.println("Thank you ");
                   return ;
               default:
                   // Invalid choice
                   System.out.println("Please enter a valid choice.");
                   break;
           }

       }while(choice != "0");    

       return ;


        
    }

    //=======================================================================

    void writeOneFile()
    {
        String name;
        
        System.out.print("Enter Name : ");
        name = scan.next();
        FileClass fileObj;
        fileObj = isPresent(name);

        if( fileObj == null)
        {
            System.out.print("File is not Present : ");
            return ;
        }
        System.out.println("Enter Password : ");
        String password;
        password = scan.next();
        fileObj.writeFile(password);
    }

    void readOneFile()
    {
        String name;
        
        System.out.print("Enter Name : ");
        name = scan.next();
        FileClass fileObj;
        fileObj = isPresent(name);

        if( fileObj == null)
        {
            System.out.print("File is not Present : ");
            return ;
        }
        System.out.println("Enter Password : ");
        
        String password;
        password = scan.next();
       
        fileObj.readFile(password);
    }

    void viewAllFilesName()
    {
        int size = ObjectOfFiles.size();
        for(int i=0; i<size; i++)
        {
            System.out.println(ObjectOfFiles.get(i).getFileName());
        }
    }

    FileClass isPresent(String s)
    {
        
        int size = ObjectOfFiles.size();

        for(int i=0; i<size; i++)
        {
           // System.out.println(ObjectOfFiles.get(i).getFileName());
            if( ObjectOfFiles.get(i) != null && ObjectOfFiles.get(i).getFileName().compareToIgnoreCase(s) == 0) return ObjectOfFiles.get(i);
            
        }

        return null;
    }

    void deletOneFile()
    {
        System.out.println("Enter file Name : ");
        String name = scan.next();

        FileClass fileObje = isPresent(name);

        if(fileObje == null)
        {
            System.out.println("file is not present : ");
            return ;
        }
        System.out.println("Enter password : ");
        String password = scan.next();

        if(fileObje.getPassword().compareTo(password) != 0) 
        {
            System.out.println("Password does not match : ");
            return ;
        }

        fileObje.deletFile();
        
        removeFileFromData(fileObje);
        
    }

    void removeFileFromData(FileClass deletObject)
    {
        int size = ObjectOfFiles.size();


        for(int i=0; i<size; i++)
        {
            if(deletObject == ObjectOfFiles.get(i))
            {
                ObjectOfFiles.set(i,null);
            }
        }
    }
}
