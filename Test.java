import java.io.FileWriter;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) {
     
        // create inventory instance
        Inventory inv =  Inventory.getInstance();

        // add 6 items with to the inventory
        inv.add(new Product("Banana", 2.00));
        inv.add(new Product("Apple", 2.00));
        inv.add(new Product("Yogurt", 1.50));
        inv.add(new Product("Frozen Pizza", 5.60));
        inv.add(new Product("Bread", 2.40));
        inv.add(new Product("Jam", 2.15));
        
        System.out.println("Showing inventory:\n");
        // loop through inventory
        for (Product p: inv.getInventory()) {
            // print out the product
            System.out.println(p.toString());
        }

        // testing generateOrder method
        int[] codes = {2,1,5,3};
        Order order = inv.generateOrder(codes);

        try {
            // create writer object
            FileWriter writer = new FileWriter("Order.txt");
            // write order information to the text file
            writer.write("Order Number: " + order.getOrderNumber() + "\n");
            writer.write("Timestamp: " + order.getTimestamp() + "\n");
            // loop through products
            for (Product p : order.getProducts()) {
                // write product information to text file
                writer.write(p.getProductCode() + "," + p.getTitle() + "," + p.getPrice() + "\n");
            }
            writer.close();
        // handle IO exception
        } catch (IOException e) {
            System.out.println("Error writing to file. Displaying Error: " + e.getMessage());
        }

    
        Inventory reducedInv = Inventory.getInstance();

        System.out.println("Showing reduced inventory:\n");
        // loop through inventory
        for (Product p: reducedInv.getInventory()) {
            // print out the product
            System.out.println(p.toString());
        }
    }

}
