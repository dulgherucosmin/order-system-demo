public class Product implements Comparable<Product> {

    private static int nextProductCode = 1;
    private int productCode = 0;
    private String title;
    private double price;

    public Product(String title, double price) {
        // TODO: data validation
        this.title = title;
        this.price = price;
        this.productCode = nextProductCode++;
    }

    public Product(Product copyProduct) {
        // Data already validated as a Product objected is passed in
        this.productCode = copyProduct.productCode;
        this.title = copyProduct.title;
        this.price = copyProduct.price;
    }

    @Override
    public String toString() {
        return "Product Code: " + this.productCode + "\nTitle: " + this.title + "\nPrice: $" + this.price;
    }

    @Override
    public boolean equals(Object object) {
        // verify that object is a product object
        if (!(object instanceof Product)) {
            return false; // we can only compare products
        }
        else {
            // cast object into a product variable
            Product otherProduct = (Product) object;
            // check if product codes are equal
            if (otherProduct.getProductCode() == this.productCode) {
                return true;
            }
        }
        // default return statement
        return false;
    }

    // refactor hashcode such that it matches the equals method
    @Override
    public int hashCode() {
        return Integer.hashCode(this.productCode);
    }

    @Override
    public int compareTo(Product otherProduct) {
        // non-null -> null relation
        if (otherProduct == null ) { return 1; }
        //
        if (this.title == null && otherProduct.title == null) { return 0; }
        if (this.title == null) { return -1; }
        if (otherProduct.title == null) { return 1; }

        // TODO: proper comments here
        return this.title.compareToIgnoreCase(otherProduct.title);

    }

    /* SETTERS */
    public void setTitle(String newTitle) {
        // TODO: data validation
        this.title = newTitle;
    }

    public void setPrice(double newPrice) {
        // TODO: data validation
        this.price = newPrice;
    }
        
    /* GETTERS */
    public int getProductCode() {
        return this.productCode;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() { 
        return this.price;
    }   
}