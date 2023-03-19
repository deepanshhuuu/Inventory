package RegistrationPackage;
import java.util.Scanner;
import java.io.*;

public class Registration
{
    static Register register = new Register();

    public void UserRegistrationMethod() throws Exception
    {
        Scanner scanner = new Scanner(System.in);


        String  fileName=  "C:\\Users\\om\\Desktop\\JAVA\\inventory\\src\\DB\\DB.txt"; //Path to DB
        FileWriter myWriter = new FileWriter(fileName,true); // Writing into a file

        System.out.print("\n Enter Name: ");
        String uName = scanner.nextLine();
        register.setUName(uName);
        System.out.print("\n Enter userName:  ");
        String userName = scanner.nextLine();
        register.setUserName(userName);
        System.out.print("\n Enter password: ");
        String password = scanner.nextLine();
        register.setUserPassword(password);
        System.out.print("\n Enter emailId: ");
        String emailId = scanner.nextLine();
        register.setEmailId(emailId);
        myWriter.write("\n" + userName+","+password+","+uName+","+emailId );
        myWriter.close();
        System.out.println(register.toString());

    }
}

class Register
{
    private String UName;
    private String UserName;
    private String Password;
    private String emailId;

    public String getUName()
    {
        return UName;
    }
    public void setUName(String UName)
    {
        this.UName = UName;
    }
    public String getUserName()
    {
        return UserName;
    }
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }
    public String getUserPassword()
    {
        return Password;
    }
    public void setUserPassword(String Password)
    {
        this.Password = Password;
    }
    public String getEmailId()
    {
        return emailId;
    }
    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    @Override
    public String toString()
    {
        System.out.print("\n The details entered: ");
        return "Name=" + UName + ", UserName=" + UserName + ", Password=" + Password + ", emailId=" + emailId + " ";
    }
}