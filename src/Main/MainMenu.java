package Main;

import Login.*;
import RegistrationPackage.*;
import AdminPortal.*;
import java.util.Scanner;


class MainMenu
{

    public static void menumethod ()
    {
        boolean run = true;

        try
        {
            Scanner sc = new Scanner (System.in);
            while (run)
            {
                System.out.println();
                System.out.print("\n Choose one of these options: ");
                System.out.println();
                System.out.print("\n 1. Register ");
                System.out.print("\n 2. Login and Shop");
                System.out.print("\n 3. Admin Login");
                System.out.print("\n 4. Exit");
                System.out.print("\n Enter your choice: ");
                String input = sc.nextLine();
                int answer;

                try
                {
                    answer = Integer.valueOf (input);
                }
                catch (Exception e)
                {
                    answer = -1;
                }

                switch (answer)
                {
                    case 1: System.out.print("\n Register ");
                        Registration R = new Registration();
                        R.UserRegistrationMethod();
                        System.out.print("Redirecting to main page ");

                        break;

                    case 2: System.out.print("\n Login and Shop");

                        Login L = new Login();
                        L.LoginMain();
                            break;

                    case 3: System.out.println ("\n Admin Login");
                        AdminVerify ad = new AdminVerify();
                        String adminname = ad.getAdminId();
                        String adminpassword = ad.getAdminPassword();
                        System.out.print("\n Enter Admin Username: ");
                        String admid = sc.nextLine();
                        System.out.print("\n Enter Admin Password: ");
                        String admpass = sc.nextLine();

                        if (admid.equals(adminname) && admpass.equals(adminpassword))
                        {
                            System.out.print("\n Redirecting to Admin Portal");
                            Itemaccess adm = new Itemaccess();
                            adm.AdminMenuMethod();
                        }
                        else
                        {
                            System.out.println("\n Admin credentials could not be verified");
                        }
                        break;

                    case 4: run = false;
                        break;
                    default: System.out.print("\n Incorrect Input ");
                        System.out.print("\n Please enter a Number between 1-4");
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            System.out.println ("\n Something went wrong");
            e.printStackTrace();
        }

        finally
        {
            System.out.println ("\n Thanks for visiting us! ");
            System.out.println ("\n Hope to see you again soon");
            System.out.println ("\n Bye!");
        }
    }

    public static void main (String[] args)
    {
        System.out.println ("\n *************************");
        System.out.println ("\n       Welcome");
        System.out.println ("\n *************************");
        menumethod();
    }
}