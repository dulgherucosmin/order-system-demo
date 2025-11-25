import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Order {
    
    private int orderNumber;
    private List<Product> products;
    private int timestamp;

    public Order(int orderNumber, ArrayList<Product> products, int timestamp) {
        this.orderNumber = orderNumber;
        this.timestamp = timestamp;

        // validate data (check if null / empty)
        if (products == null || products.isEmpty()) {
            this.products = Collections.emptyList();
        }
        else {
            // create a temporary variable
            List<Product> tempProducts = new ArrayList<>(products.size());
            // loop through products
            for (Product p: products) {
                tempProducts.add(new Product(p)); // avoid using the same instance so create a new one
            }
            // return list that is unmodifiable
            this.products = Collections.unmodifiableList(tempProducts);
        }
    }

    /* GETTERS */
    public int getOrderNumber() {
        return this.orderNumber;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public List<Product> getProducts() {

        // validate if null
        if (products.isEmpty()) {
            return Collections.emptyList();
        }

        // create a temporary variable
        List<Product> productsCopy = new ArrayList<>(products.size());
        // loop through products
        for (Product p: products) {
            productsCopy.add(new Product(p)); // avoid using the same instance, so create a new product
        }
        // return list that is unmodifiable
        return Collections.unmodifiableList(productsCopy);
    }

}
