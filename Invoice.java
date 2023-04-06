import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Invoice {
   /*Class: Invoice
Responsibilities: show all of the data, Format the display, and calculate the amount due
Collaborators:  customer, lineItem
*/
    String Title;
    double amountDue;
    ArrayList<String> lineItems = new ArrayList<String>();
    Customer customer = new Customer();
    LineItem lineItem = new LineItem();
    String[] fields;

   public void addLineItem(){
       lineItems.add(lineItem.line);
   }
    public void InvoicePrint(){
        customer.CustomerPrint();
        System.out.println("\n\n\n");
        System.out.println("\nproductName               quantity     unitCost     totalCost");
        System.out.println("================================================================");
        System.out.printf(String.valueOf(lineItems));
        System.out.println("\n--------------------------------------------------------------");
        System.out.printf(""+"amount due: "+ amountDue); //%30s should pad stuff
    }

    public void getTotal(){

    }

}
