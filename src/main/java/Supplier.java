import java.util.ArrayList;

public class Supplier {
    //class Supplier, initalising the variables
    private static int nextSupplierId = 0;

    private int supplierId;
    private String supplierName;
    private float supplierPhoneNumber;
    private String supplierEmail;
    private ArrayList <Product> supplierOrderHistory;

    //the constructor method for class Product
    public Supplier(String supplierName, float supplierPhoneNumber, String supplierEmail){
        this.supplierName = supplierName;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.supplierEmail = supplierEmail;

        this.supplierId = nextSupplierId;
        nextSupplierId++;
        supplierOrderHistory = new ArrayList<>();
    }

    //getter methods, returns the variables of Supplier Instance
    public int getSupplierId(){
        return supplierId;
    }

    public String getSupplierName(){
        return supplierName;
    }

    public float getSupplierPhoneNumber(){
        return supplierPhoneNumber;
    }

    public String getSupplierEmail(){
        return supplierEmail;
    }

    public ArrayList <Product> getSupplierOrderHistory(){
        return supplierOrderHistory;
    }

    //setter methods if the user wants to update the supplier details
    public void setSupplierName(String name){
        supplierName = name;
    }

    public void setSupplierPhoneNumber(float phoneNumber){
        supplierPhoneNumber = phoneNumber;
    }

    public void setSupplierEmail(String email){
        supplierEmail = email;
    }

    //method to add a product to order history
    public void addOrderHistory(Product product){
        supplierOrderHistory.add(product);
    }

    //method to order stock
    public void orderStock(Product product, int stock){
        product.addStock(stock);
        this.addOrderHistory(product);
    }
}
