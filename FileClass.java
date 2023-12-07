// Hare Krishna!
import java.io.*;
import java.util.Scanner;

public class FileClass implements Serializable{

    private String fileName;
    private String password;
    private int key;
    static Scanner input = new Scanner(System.in);

    String getFileName()
    {
        return fileName;
    }

    public String getPassword() {
        return password;
    }

    public void changeName()
    {
        System.out.println("Enter new Name : ");
        String name;
        name  = input.next();
        this.fileName = name;
    }

    public void changePassword()
    {
        String p;
        System.out.println("Enter password : ");
        p = input.next();

        if(p.compareTo(this.password) != 0 )
        {
            return ;
        }

        System.out.println("Enter new Password : ");
        p = input.next();

        this.password = p;
    }
    
    FileClass()
    {
       fileName = null;
       password = null;
        key = 1;
    }

    public String setPassword(String password) {

        if(password.length()!= 4)
        {
            System.out.println("Password should be of 4 digit : ");
            return null;
        }
        for(int i=0; i<4; i++)
        {
            if(password.charAt(i) >'9' || password.charAt(i)<'0' ) return null;
        }
        return password;
    }

    void newFile(String fileName,String password)
    {
        this.fileName = fileName;
        String tempPassword;
        if((tempPassword = setPassword(password)) == null)
        {
            return ;
        }
        this.password = tempPassword;
        
        File myFile = null;
        try
        {
             myFile = new File(fileName);
        }
        catch(Exception e)
        {
            System.out.println("File Name is Not Correct : ");
        }
        
        
        try
        {
            myFile.createNewFile();

        }
        catch(IOException e)
        {
            System.out.println(e);
            System.out.println("File can not Created! : ");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void readFile(String password)
    {
        if(this.password . compareToIgnoreCase(password) != 0)
        {
            System.out.println("Invalid Password : ");
            return ;
        }
        System.out.println("--------------------------------------------");
        try{
            File myFileReader = new File(this.fileName);
            Scanner read = new Scanner(myFileReader);
            StringBuffer data = new StringBuffer("");
            while(read.hasNextLine())
            {
                data.append(read.nextLine());
                data.append(" ");
            }
            String sdata = data.toString();
            int size = sdata.length();

            for(int i=0; i<size; i++)
            {
                System.out.print((char)(sdata.charAt(i)-key));
            }

            read.close();
        }
        catch(IOException e)
        {
             System.out.println(e);
            System.out.println("File can not Read! : ");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("\n--------------------------------------------");
    }

    void writeFile(String password)
    {
        
        if(this.password . compareToIgnoreCase(password) != 0)
        {
            System.out.println("Invalid Password : ");
            return ;
        }

        try{
            FileWriter myFileWriter = new FileWriter(fileName,true);
            System.out.println("Enter Contain : ");
            
            String ch;
            System.out.println("Enter $ at end : ");
            System.out.println("--------------------------------------------\n");

            do{
                ch = input.next();
                
                for(int i=0; i<ch.length(); i++)
                {
                    myFileWriter.write(ch.charAt(i) + key );
                }
                myFileWriter.write(' '+key);
                if(ch == "$") 
                {
                    myFileWriter.close();
                    return ;
                }
            }while( ch.charAt(0) != '$');
            System.out.println("\n--------------------------------------------\n");
           
            myFileWriter.close();
            
        }
        catch(IOException  e)
        {
            System.out.println(e);
            System.out.println("File can not Open : ");
        }
    }

     void deletFile()
    {
        
        try{

            File myFile = new File(this.fileName);
            myFile.delete();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("File can Not be Deleted ");
        }

        
    }

}

