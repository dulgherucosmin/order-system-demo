import java.util.ArrayList;
import java.util.Objects;

final class Order {
    
    private int orderNumber;
    private ArrayList<Product> products;
    private int timestamp;

    public Order(int orderNumber, ArrayList<Product> products, int timestamp) {
        this.orderNumber = orderNumber;
        this.timestamp = timestamp;


        // validate data (check if null / empty)
        if (products == null || products.isEmpty()) {
            // create a new empty arraylist (copy of products)
            this.products = new ArrayList<Product>();
        }
        else {
            // create new variable as a copy of the products arraylist
            ArrayList<Product> copy = new ArrayList<>(products.size());

            // loop through products
            for (Product p: products) {
                copy.add(p);
            }
            this.products = copy;
        }
    }

    @Override
    public String toString() {
        // create info string variable
        String s = "Order Number: " + this.orderNumber + "\nTimestamp: " + this.timestamp + "Products:";
        // loop through products
        for (Product p: products) {
            // add product string to the main string s
            s += "\n\n" + p.toString();
        }
        return s;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) { return true; }
        
        // validate that the object is an Order object
        if (!(object instanceof Order)) { return false; }

        Order otherOrder = (Order) object;
        return otherOrder.getOrderNumber() == this.orderNumber 
            && otherOrder.getTimestamp() == this.timestamp 
            && Objects.equals(this.products, otherOrder.products);
    }
    // override hashcode such that it matches equal method
    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, timestamp, products);
    }

    /* GETTERS */
    public int getOrderNumber() {
        return this.orderNumber;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public ArrayList<Product> getProducts() {

        // validate if null
        if (products.isEmpty()) {
            return new ArrayList<Product>();
        }

        // create new variable as a copy of the products arraylist
        ArrayList<Product> copy_ = new ArrayList<>(products.size());
        // loop through products
        for (Product p: products) {
            copy_.add(p);
        }
        // return statement
        return copy_;
    }

}
