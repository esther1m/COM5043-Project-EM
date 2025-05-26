
public class Product {
    //class Product, initalising the variables
    private int productId;
    private String productName;
    private double productPrice;
    private int productQuantity;

    //the constructor method for class Product
    public Product (int productId, String productName, double productPrice, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    //getter methods, returns the variables of Product instance
    public int getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    private double getProductPrice(){
        return productPrice;
    }

    private int getProductQuantity(){
        return productQuantity;
    }

    //adding stock to product
    private void addStock(int amount){
        if (amount > 0){
            productQuantity = productQuantity + amount;
        }
    }

    //removing stock from product
    private void removeStock(int amount){
        if (amount > 0) {
            productQuantity = productQuantity - amount;
            if (productQuantity == 0){
                //place a new order from supplier to restock
            }
        }
    }
}
