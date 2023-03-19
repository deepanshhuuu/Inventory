package Login;
import UserPortal.Shop;
import java.io.*;
import java.util.*;

public class Login
{
    int flag =0;
    public void LoginMain()
    {
        try
        {
            Scanner sc= new Scanner(System.in);
            System.out.print("\n Enter Username: ");
            String userid = sc.nextLine();
            String uid = userid;
            File temp = new File("C:\\Users\\om\\Desktop\\JAVA\\inventory\\src\\DB\\DB.txt");
            BufferedReader br = new BufferedReader(new FileReader(temp));
            if(temp.exists())
            {
                System.out.print("\n Enter User Password: ");
                String userpass = sc.nextLine();
                while((uid=br.readLine())!=null)
                {
                    StringTokenizer st = new StringTokenizer(uid,",");
                    String check_uid=st.nextToken();
                    String check_pass=st.nextToken();

                    if(check_uid.equals(userid)&&check_pass.equals(userpass))
                    {
                        System.out.println("Login Successful");
                        System.out.println("Redirecting to the shopping page");
                        Shop S = new Shop();
                        S.Shopping();
                        flag = 1;
                        break;
                    }
                    else
                    {
                        System.out.println("Fetching.....");

                    }
                }
            }
            if(flag==0)
            {
                System.out.print("\n Please register first and then shop");
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
