public class LineItem {
    Product product = new Product();
    int quantity;
    double lineTotal;
    String line;
    public void makeLineItem() {

        lineTotal = quantity * product.unitPrice;

        line = product.name + "     " + quantity + "   " + product.unitPrice + " " + lineTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
