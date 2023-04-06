import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.StrokeBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Main extends JFrame {
    JFrame Jframe = new JFrame();
    JPanel mainPnl;
    JLabel title;
    JPanel topPnl;
    JPanel addressPnl;
    JPanel invoicePnl;
    JPanel resultPnl;
    JSeparator topSeparator;
    JPanel inputPnl;
    JPanel butonPnl;
    JTextArea customerName;
    JTextArea quantity;
    JTextArea productName;
    JTextArea unitCost;
    JTextArea street;
    JTextArea zip;
    JTextArea state;
    JTextArea city;
    JPanel customerPnl;
    JPanel productPnl;
    ArrayList<String> lineItems = new ArrayList<String>();

    Customer customer = new Customer();
    Invoice invoice = new Invoice();
    Product product = new Product();
    Address address = new Address();
    LineItem lineItem = new LineItem();

    public Main(){
        mainPnl = new JPanel();
    BorderLayout mainLayout = new BorderLayout();
    mainPnl.setLayout(mainLayout);
    add(mainPnl);
    //createResultPnl();
    createButtonPnl();
    createInputPnl();
    //mainPnl.add(resultPnl, BorderLayout.SOUTH);
    mainPnl.add(inputPnl, BorderLayout.CENTER);
    mainPnl.add(butonPnl, BorderLayout.NORTH);
    //resultPnl.setVisible(false);
    setSize(600, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainLayout.setVgap(40);
    setVisible(true);}
    JButton generateInvoice;
    JButton addLineItemBtn;
    double cost;
    double quant;
    double totalCost = cost * quant;

String customerN, customerStreet, customerCity, customerZip, customerState;
    final int FIELDS_LENGTH = 4;

    String id, name, description;
    String unitCostString, quanityString;
    double unitPrice, totCost;
    int quanti;
    String pName;
    String[] lines;
    double lineTot;
    double orderTot = 0;
    private void createButtonPnl(){
        butonPnl = new JPanel();
        addLineItemBtn = new JButton("add line item");
        addLineItemBtn.addActionListener((ActionEvent a) ->{
            pName = String.valueOf(productName.getText());
            unitPrice = Double.valueOf(unitCost.getText());
            quanti = Integer.valueOf(quantity.getText());
            double lineTot = quanti * unitPrice;
            orderTot = lineTot + orderTot;
            lineItems.add( pName + ", " + unitPrice + "," + quanti + "," + lineTot);

           //lineItems.add(productName.getText() +"               " + quantity.getText() +"     " + unitCost.getText() +"     "+ totalCost);
        });
        generateInvoice = new JButton("generate invoice");
        //generate invoice
        //

        generateInvoice.addActionListener((ActionEvent ae) ->  {
            customerN = customerName.getText();
            customerCity = city.getText();
            customerStreet = street.getText();
            customerZip = zip.getText();
            customerState = state.getText();
            System.out.println(customerN + "\n" + customerStreet + "\n" +  customerCity + ", " + customerState + " " + customerZip);
            System.out.println("\nproductName         unitCost           quantity     totalCost");
            System.out.println("================================================================");
            //lineItems.replaceAll(",", " ");
            //System.out.printf(String.valueOf(lineItems));


            String[] fields;
            for (String a : lineItems) {
                fields = a.split(",", 0);
                if (fields.length == FIELDS_LENGTH) {
                    id = fields[0].trim();
                    name = fields[1].trim();
                    description = fields[2].trim();
                    cost = Double.parseDouble(fields[3].trim());
                    System.out.printf("\n%-21s%-23s%-10s%-13s", id, name, description, cost);
                }
            }
            System.out.println("\n\n================================================================");
            System.out.printf("\n%-65s","order total: " + orderTot);
            //System.out.printf(String.valueOf("\n" + lineItems));

                });
        butonPnl.add(generateInvoice); butonPnl.add(addLineItemBtn);
    }

    private void createInputPnl(){

        inputPnl = new JPanel(new GridLayout(2, 4));
        createProductPnl();
        createCustomerPnl();
        inputPnl.add(productPnl);
        inputPnl.add(customerPnl);
    }
    private void createProductPnl(){
        productPnl = new JPanel();
        quantity = new JTextArea("Quantity");
        productName = new JTextArea("Product Name");
        unitCost = new JTextArea("Unit Cost");
        productPnl.add(productName); productPnl.add(unitCost); productPnl.add(quantity);
    }
    private void createCustomerPnl(){
        customerPnl = new JPanel();
        customerName = new JTextArea("Customer Name");
        street = new JTextArea("Street");
        zip = new JTextArea("Zip");
        state = new JTextArea ("State");
        city = new JTextArea("City");
        customerPnl.add(street); customerPnl.add(zip); customerPnl.add(state); customerPnl.add(city); customerPnl.add(customerName);
    }
    /*private  void createResultPnl() {
        resultPnl = new JPanel(new BorderLayout());
        createTopPnl();
        createInvoice();
        resultPnl.add(topPnl, BorderLayout.NORTH);
        resultPnl.add(invoicePnl, BorderLayout.CENTER);
    }*/
JTextArea invoiceArea;
JSeparator bottomSeperator;
    private void createInvoice(){
invoicePnl = new JPanel(new BorderLayout());
topSeparator = new JSeparator();
topSeparator.setBorder(new LineBorder(Color.BLACK, 10));
bottomSeperator = new JSeparator();
bottomSeperator.setBorder(new LineBorder(Color.BLACK, 10));
invoiceArea = new JTextArea(25, 30);
invoicePnl.add(topSeparator, BorderLayout.NORTH);
invoicePnl.add(invoiceArea, BorderLayout.CENTER);
invoicePnl.add(bottomSeperator, BorderLayout.SOUTH);

    }
    private void createTopPnl(){
        createAddressPnl();
        topPnl = new JPanel();
        topPnl.setLayout(new BorderLayout());
        title = new JLabel("Invoice", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD,36));
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);
        topPnl.add(title, BorderLayout.NORTH);
        topPnl.add(addressPnl, BorderLayout.WEST);

    }
    private void createAddressPnl(){
addressPnl = new JPanel();
addressPnl.setBorder(new LineBorder(Color.BLACK, 5, true));

    }
    public static void main(String[] args) {
        JFrame jframe = new Main();


    }
}