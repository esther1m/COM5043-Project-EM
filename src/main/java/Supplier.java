import java.util.ArrayList;

public class Supplier {
    //class Supplier, initalising the variables
    private int supplierId;
    private String supplierName;
    private int supplierPhoneNumber;
    private String supplierEmail;
    private ArrayList <Product> supplierOrderHistory;

    //the constructor method for class Product
    public Supplier(int supplierId, String supplierName, int supplierPhoneNumber, String supplierEmail){
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

    public int getSupplierPhoneNumber(){
        return supplierPhoneNumber;
    }

    public String getSupplierEmail(){
        return supplierEmail;
    }

    public ArrayList getSupplierOrderHistory(){
        return supplierOrderHistory;
    }

    //method to add a product to order history
    public void addOrderHistory(Product product){
        supplierOrderHistory.add(product);
    }
}
