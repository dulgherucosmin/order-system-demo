import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.time.LocalDateTime;

class Inventory {

    private static Inventory instance = null;

    private static int ordersFilled = 0;
    private ArrayList<Product> products = new ArrayList<>();

    // empty constructor
    private Inventory() {}

    public static synchronized Inventory getInstance() {

        // check if an instance is null
        if (instance == null) {
            // create instance
            instance = new Inventory();
        }
        return instance;
    }

    public ArrayList<Product> getInventory() {
        // create copy variable
        ArrayList<Product> copy = new ArrayList<>();
        if (!(products == null)) {
            // copy all values into the new variable
            copy.addAll(products);
        }
        // sort the copy arraylist
        Collections.sort(copy);
        // return
        return copy;
    }

    public void add(Product product) {
        // check if product is a null object
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        // add product to the products arraylist
        products.add(product);
    }

    public void remove(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        Iterator<Product> iterator = products.iterator();
        // while the iterator can keep going
        while (iterator.hasNext()) {
            Product p = iterator.next();
            // products match
            if (p == product) {
                // remove product
                iterator.remove(); // safe removal during iteration
                break;
            }
        }
    }

    public Product search(Product product) {
        // check if product is a null object
        if (product == null) {
            throw new IllegalStateException("Product cannot be null.");
        }

        // loop through products
        for (Product p: products) {
            // product is found
            if (p == product) {
                return p; // return product object
            }
        }
        // default return statement
        return null;
    }

    public Order generateOrder(int[] productCodes) {
        ArrayList<Product> orderProducts = new ArrayList<>();
        ArrayList<Product> productsToRemove = new ArrayList<>();

        // loop through product codes
        for (int code : productCodes) {
            // loop through products
            for (Product p : products) {
                // product codes match
                if (p.getProductCode() == code) {
                    orderProducts.add(p); // add to the order products
                    productsToRemove.add(p); // mark for removal
                }
            }
        }
        // remove products after iteration to avoid errors
        for (Product p : productsToRemove) {
            this.remove(p);
        }

        // increment orders filled
        ordersFilled++;
        // return new order object
        return new Order(ordersFilled, orderProducts, LocalDateTime.now());
    }

}
