
public class Product {
    //class Product, initalising the variables
    private int nextProductId = 0;

    private int productId;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private int preferredSupplierID;
    private int reorderThreshold;
    private int reorderQuantity;
    

    //the constructor method for class Product
    public Product (String productName, double productPrice, int productQuantity, int preferredSupplierID, int reorderQuantity, int reorderThreshold) {
        productId = getNextProductID();
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.preferredSupplierID = preferredSupplierID;
        this.reorderQuantity = reorderQuantity;
        this.reorderThreshold = reorderThreshold;

/*move to supplier prefences??
        reorderThreshold = 15;
        reorderQuantity = 150;
     */   
    }

    //getter methods, returns the variables of Product instance

    private int getNextProductID(){
        nextProductId = nextProductId++;
        return nextProductId;
    }

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
/* 
    public void setProductQuantity(int quantity){
        this.productQuantity = quantity;
    }*/

    //setting the product's price
    public void setPrice(double price) {
        this.productPrice = price;
    }

    //adding stock to product
    public void addStock(int amount){
        if (amount > 0){
            productQuantity = productQuantity + amount;
        }
    }
//revisit this logic
    //removing stock from product, checking there's enough stock and reordering if not
    public void removeStock(int amount){
        if (amount > 0 && productQuantity >= amount) {
            productQuantity = productQuantity - amount;
        } else {
            System.out.println("Sorry, this product " + productName + " could not be ordered.");
        }
        if (productQuantity < reorderThreshold) {
            System.out.println(productName + " is low stock.");
            //Supplier supplier = supplierManagement.getSupplierById(preferredSupplierID);
            //supplier.orderStock(this, reorderQuantity);
        }
    }
}
