package UserPortal;
import AdminPortal.Itemaccess;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product
{
    // properties
    private String pid;
    private String pname;
    private int qty;
    private double price;
    private double totalPrice;

    // constructor
    Product(String pid,String pname, int qty, double price, double totalPrice)
    {
        this.pid=pid;
        this.pname = pname;
        this.qty = qty;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    // getter methods
    public String getPid()
    {
        return pid;
    }
    public String getPname()
    {
        return pname;
    }
    public int getQty()
    {
        return qty;
    }
    public double getPrice()
    {
        return price;
    }
    public double getTotalPrice()
    {
        return totalPrice;
    }

    // displayFormat
    public static void displayFormat()
    {
        System.out.print("\nID       Name       Quantity      Price   Total Price\n");
    }

    // display
    public void display()
    {
        System.out.format("%-9s %-9s %8d %10.2f %10.2f\n", pid,pname, qty, price, totalPrice);
    }
}

public class Shop
{
   public void Shopping()
   {
       // variables
       String productName = null;
       String productId = null;
       int quantity = 0;
       double price = 0.0;
       double totalPrice = 0.0;
       double overAllPrice = 0.0;
       char choice = '\0';
       Itemaccess Iobj = new Itemaccess();
       Iobj.show_product();

       // create Scanner class object
       Scanner scan = new Scanner(System.in);

       List<Product> product = new ArrayList<Product>();

       do
       {
           // read input values
           System.out.print("\n Enter product details,");
           System.out.print("\n Product ID:");
           productId =scan.nextLine();
           System.out.print("\n Name: ");
           productName = scan.nextLine();
           System.out.print("\n Quantity: ");
           quantity = scan.nextInt();
           System.out.print("\n Price (per item): ");
           price = scan.nextDouble();

           // calculate total price for that product
           totalPrice = price * quantity;

           // calculate overall price
           overAllPrice += totalPrice;

           // create Product class object and add it to the list
           product.add( new Product(productId,productName, quantity, price, totalPrice) );

           // ask for continue?
           System.out.print("Want to add more item? (y or n): ");
           choice = scan.next().charAt(0);

           // read remaining characters, don't store (no use)
           scan.nextLine();
       }
       while (choice == 'y' || choice == 'Y');

       // display all product with its properties
       Product.displayFormat();
       for (Product p : product)
       {
           p.display();
       }

       // overall price
       System.out.println("\nTotal Price = " + overAllPrice);

    }

}
