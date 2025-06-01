
public class Product {
    //class Product, initalising the variables
    private int productId;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private int preferredSupplierID;
    private int reorderThreshold;
    private int reorderQuantity;
    private SupplierManagement supplierManagement;

    //the constructor method for class Product
    public Product (int productId, String productName, double productPrice, int productQuantity, int preferredSupplierID, SupplierManagement sm) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.preferredSupplierID = preferredSupplierID;
        this.supplierManagement = sm;

        reorderThreshold = 15;
        reorderQuantity = 150;
        
    }

    //getter methods, returns the variables of Product instance
    public int getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public double getProductPrice(){
        return productPrice;
    }

    public int getProductQuantity(){
        return productQuantity;
    }

    public void setProductQuantity(int quantity){
        this.productQuantity = quantity;
    }

    //adding stock to product
    public void addStock(int amount){
        if (amount > 0){
            productQuantity = productQuantity + amount;
        }
    }

    //removing stock from product, checking there's enough stock and reordering if not
    public void removeStock(int amount){
        if (amount > 0 && productQuantity >= amount) {
            productQuantity = productQuantity - amount;
        } else {
            System.out.println("Sorry, this product " + productName + " could not be ordered.");
        }
        if (productQuantity < reorderThreshold) {
            System.out.println(productName + " is low stock.");
            Supplier supplier = supplierManagement.getSupplierById(preferredSupplierID);
            supplier.orderStock(this, reorderQuantity);
        }
    }
}
