import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        }
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
