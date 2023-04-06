import javax.swing.*;

public class Customer {
    /*customer
Name, address
*/
    Address address = new Address();
    String name = "john smith";
    JLabel addressLabel;
    JPanel customerAddress;
    public void CustomerPrint() {

        System.out.println(name + "\n" + address.street + "\n" + address.city + ", " + address.state + " " + address.zip);
    }

}
