import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private int nextOrderId = 0;
    private int id;
    private HashMap<Integer, Integer> productOrders;
    private int customerId;
    private double totalCost;
    private String status;


    public Order(int customerId){
        id = nextOrderId;
        nextOrderId++;

        this.customerId = customerId;

        totalCost = 0;
        productOrders = new HashMap<>();
        status = "Processing";

    }

    public boolean addProductsToOrder(Product product, int customerOrderQuantity){
        if (product == null){
            System.out.println("Cannot add null product to order");
            status = "Failed to place order of " + product + " due to stock issues";
            return false;
        }
        int product_id = product.getProductId();

        if (product.getProductQuantity() >= customerOrderQuantity){
            product.removeStock(customerOrderQuantity);
            productOrders.put(product_id, customerOrderQuantity);
            status = "Pending";
            totalCost = totalCost + (product.getProductPrice() * customerOrderQuantity);
        } else {
            status = "Failed to place order of " + product + " due to stock issues";
            return false;
        }
        status = "Order complete";
        return true;
    }

    public int getId() {
        return id;
    }

    public double getTotalCost(){
        return totalCost;
    }

    public String getStatus(){
        return status;
    }
//revisit this logic
    public void getProductOrders(){
        for (int productId : productOrders.keySet()) {
            //Product product = inventoryManagement.getProductById(productId);
           // System.out.println("ID: " + productId + " | Name: "  + product.getProductName() + " | Price £" + product.getProductPrice() + " | Quantity: " + productOrders.entrySet());
        }

    }

    
}
