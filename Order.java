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
    }

    /* GETTERS */
    public int getOrderNumber() {
        return this.orderNumber;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public List<Product> getProducts() {

        if (products.isEmpty()) {
            return Collections.emptyList();
        }

        List<Product> productsCopy = new ArrayList<>(products.size());
        for (Product p: products) {
            productsCopy.add(new Product(p)); // copy each product
        }
        return Collections.unmodifiableList(productsCopy);
    }

}
