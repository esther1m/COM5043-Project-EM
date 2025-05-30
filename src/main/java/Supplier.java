import java.util.ArrayList;

public class Supplier {
    //class Supplier, initalising the variables
    private int supplierId;
    private String supplierName;
    private float supplierPhoneNumber;
    private String supplierEmail;
    private ArrayList <Product> supplierOrderHistory;

    //the constructor method for class Product
    public Supplier(int supplierId, String supplierName, float supplierPhoneNumber, String supplierEmail){
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.supplierEmail = supplierEmail;
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

    public ArrayList getSupplierOrderHistory(){
        return supplierOrderHistory;
    }

    //setter methods if the user wants to update the supplier details
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
}
