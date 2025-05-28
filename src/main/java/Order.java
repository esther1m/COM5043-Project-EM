import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    int id;
    HashMap<Integer, Integer> productOrders;
    int customerId;
    double totalCost;
    String status;

    public Order(int id, int customerId){
        this.id = id;
        this.customerId = customerId;

        totalCost = 0;
        productOrders = new HashMap<>();
        status = "Processing";
    }

    public void addProductsToOrder(Product product, int customerOrderQuantity){
        int product_id = product.getProductId();

        if (product.getProductQuantity() > customerOrderQuantity){
            product.removeStock(customerOrderQuantity);
            productOrders.put(product_id, customerOrderQuantity);
            status = "Pending";
            totalCost = totalCost + (product.getProductPrice() * customerOrderQuantity);
        } else {
            status = "Failed to place order due to stock issues";
        }
    }

}
