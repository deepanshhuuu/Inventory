package AdminPortal;
import java.util.Scanner;
import java.io.*;
import java.util.*;

abstract class Items
{
    String product_name;
    double product_no;
    float price,tax,dis;

    abstract public void add_product();
    abstract public void show_product();
    abstract public void modify_product();
    abstract public void delete_product();

    Items()
    {
        product_name="NULL";
        product_no=0;
        price=0;
        tax=0;
        dis=0;
    }

    Items(String product_name, double product_no, float price, float tax, float dis)
    {
        this.product_name=product_name;
        this.product_no=product_no;
        this.price=price;
        this.tax=tax;
        this.dis=dis;
    }

    public void setvalues(String product_name, double product_no, float price, float tax, float dis)
    {
        this.product_name=product_name;
        this.product_no=product_no;
        this.price=price;
        this.tax=tax;
        this.dis=dis;
    }

    public String getprodname()
    {
        return product_name;
    }

    public double getprodno()
    {
        return product_no;
    }

    public float getprice()
    {
        return price;
    }

    public float gettax()
    {
        return tax;
    }

    public float getdis()
    {
        return dis;
    }
}

public class Itemaccess extends Items
{
    public void add_product()
    {

        try
        {
            BufferedWriter bw = new BufferedWriter( new FileWriter("C:\\Users\\om\\Desktop\\JAVA\\inventory\\src\\DB\\Inventory\\Inventory.txt",true) );
            Scanner strInput = new Scanner(System.in);
            String prod_name,ID;
            float cost,taxes,discount;


            System.out.print("Enter the Product ID: ");
            ID = strInput.nextLine();
            System.out.print("Enter the Product Name: ");
            prod_name = strInput.nextLine();
            System.out.print("Enter price of the product: ");
            cost = strInput.nextFloat();
            System.out.print("Enter the taxes applicable on the product:");
            taxes = strInput.nextFloat();
            System.out.print("Enter discount on the product: ");
            discount = strInput.nextFloat();

            bw.write(ID+","+prod_name+","+cost+","+taxes+","+discount);
            bw.flush();
            bw.newLine();
            bw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void show_product()
    {
        try
        {
            BufferedReader br = new BufferedReader( new FileReader("C:\\Users\\om\\Desktop\\JAVA\\inventory\\src\\DB\\Inventory\\Inventory.txt") );

            String record;

            System.out.println("+-----------------------------------------------------------------------------------------+ ");
            System.out.println("|	ID		Name 	  Cost	    Taxes   Discount |");
            System.out.println("+-----------------------------------------------------------------------------------------+ ");

            while( ( record = br.readLine() ) != null )
            {
                StringTokenizer st = new StringTokenizer(record,",");
                System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+" 		"+st.nextToken()+"      |");
            }
            System.out.println("|	                                                          |");
            System.out.println("+-----------------------------------------------------------------------------------------+ ");
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public void modify_product()
    {
        try
        {
            String newName, record, ID,record2;
            float newCost,newTaxes,newDiscount;

            File db = new File("C:\\Users\\om\\Desktop\\JAVA\\inventory\\src\\DB\\Inventory\\Inventory.txt");
            File tempDB = new File("C:\\Users\\om\\Desktop\\JAVA\\inventory\\src\\DB\\Inventory\\Inventory_temp.txt");

            BufferedReader br = new BufferedReader( new FileReader(db) );
            BufferedWriter bw = new BufferedWriter( new FileWriter(tempDB) );

            Scanner strInput = new Scanner(System.in);

            System.out.println("\t\t Update Product Record\n\n");
            System.out.println("Enter the Product ID: ");
            ID = strInput.nextLine();
            System.out.println("+-------------------------------------------------------------+ ");
            System.out.println("|	ID		Name 	 Cost	Taxes   Discount |");
            System.out.println("+-------------------------------------------------------------+ ");

            while( ( record = br.readLine() ) != null )
            {
                StringTokenizer st = new StringTokenizer(record,",");
                if( record.contains(ID) )
                {
                    System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+" 		"+st.nextToken()+"      |");

                }

            }
            System.out.println("|	                                            	          |");
            System.out.println(" ------------------------------------------------------------- ");

            br.close();

            System.out.println("Enter the new Product Name: ");
            newName = strInput.nextLine();
            System.out.println("Enter the updated Cost: ");
            newCost = strInput.nextFloat();
            System.out.println("Enter the updated taxes: ");
            newTaxes = strInput.nextFloat();
            System.out.println("Enter the updated discount: ");
            newDiscount = strInput.nextFloat();

            BufferedReader br2 = new BufferedReader( new FileReader(db) );

            while( (record2 = br2.readLine() ) != null )
            {
                if(record2.contains(ID))
                {
                    bw.write(ID+","+newName+","+newCost+","+newTaxes+","+newDiscount);
                }
                else
                {
                    bw.write(record2);
                }
                bw.flush();
                bw.newLine();
            }

            bw.close();
            br2.close();
            db.delete();
            boolean success = tempDB.renameTo(db);
            System.out.println(success);
        }
        catch(IOException e)
        {
            System.out.print("\n An error Occured");
            e.printStackTrace();

        }
    }

    public void delete_product()
    {
        try
        {
            Scanner strInput =  new Scanner(System.in);
            String ID, record;


            File tempDB = new File("C:\\Users\\om\\Desktop\\JAVA\\inventory\\src\\DB\\Inventory\\Inventory_temp.txt");
            File db = new File("C:\\Users\\om\\Desktop\\JAVA\\inventory\\src\\DB\\Inventory\\Inventory.txt");


            BufferedReader br = new BufferedReader( new FileReader( db ) );
            BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ));
            System.out.println("\t\t Delete Product Record\n");

            System.out.println("Enter the Product ID: ");
            ID =  strInput.nextLine();

            while( ( record = br.readLine() ) != null )
            {
                if(record.contains(ID))
                {
                    continue;
                }

                bw.write(record);
                bw.flush();
                bw.newLine();
            }
            br.close();
            bw.close();

            db.delete();

            tempDB.renameTo(db);
        }
        catch(IOException e)
        {
            System.out.print("Error Occured");
            e.printStackTrace();
        }
    }

    public void AdminMenuMethod()
    {

        int choice;
        char ch;
        Itemaccess P1= new Itemaccess();

        Scanner sc = new Scanner(System.in);


        do
        {
            System.out.print("\n ADMINISTRATION MENU ");
            System.out.print("\n 1. Add a product ");
            System.out.print("\n 2. Display all products ");
            System.out.print("\n 3. Modify a product ");
            System.out.print("\n 4. Delete a product ");
            System.out.print("\n Enter your choice: ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1: P1.add_product();
                    break;
                case 2: P1.show_product();
                    break;
                case 3: P1.modify_product();
                    break;
                case 4: P1.delete_product();
                    break;
                default: System.out.print("\n Enter correct value!");
            }

            System.out.print("\n Do you wish to continue (Y/N): ");
            ch = sc.next().charAt(0);
        }
        while(ch=='Y'||ch=='y');
    }
}