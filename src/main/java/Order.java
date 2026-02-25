import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private int id;
    public HashMap<Integer, Integer> productsOrdered;
    private int customerId;
    private double totalCost;
    private String status;
    private InventoryService inventory;


    public Order(int customerId, int orderId, InventoryService inventory){

        this.customerId = customerId;
        this.inventory = inventory;
        this.id = orderId;

        totalCost = 0;
        productsOrdered = new HashMap<>();
        status = "Processing";

    }

    public boolean addProductsToOrder(Product product, int customerOrderQuantity){
        if (product == null){
            System.out.println("Cannot add null product to order");
            status = "Failed to place order of " + product;
            return false;
        }
        int product_id = product.getProductId();

        if (product.getProductQuantity() >= customerOrderQuantity){
            product.removeStock(customerOrderQuantity);
            productsOrdered.put(product_id, customerOrderQuantity);
            status = "Pending";
            totalCost = totalCost + (product.getProductPrice() * customerOrderQuantity);
        } else {
            status = "Failed to place order of " + product.getProductName() + " due to stock issues";
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

    
}
