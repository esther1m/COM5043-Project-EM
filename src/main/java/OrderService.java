import java.util.*;

public class OrderService {
    ArrayList <Order> orders;
    int nextOrderId;
    InventoryManagement inventoryManagement;

    public OrderService(){
        orders = new ArrayList<>();
        nextOrderId = -1;
        inventoryManagement = new InventoryManagement();
    }

    public void placeOrder(int orderid, int customerid, HashMap<Product, Integer> products){
        Order order1 = new Order(orderid, customerid);

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            order1.addProductsToOrder(product, quantity);
        }
        
        orders.add(order1);
    }

    public Order getOrderbyId(int id){
        for (Order order : orders) {
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    }

    public void cancelOrder(int orderid){
        Order findOrder = getOrderbyId(orderid);
        
        for (Map.Entry <Integer, Integer> entry : findOrder.productOrders.entrySet()) {
            int product_id = entry.getKey();
            int order_quantity = entry.getValue();

            Product product = inventoryManagement.getProductById(product_id);
            if (product!= null){
                product.addStock(order_quantity);
                findOrder.status = "Cancelled. Please allow a couple of days for the refund to show in your account";
                findOrder.totalCost = 0;
                orders.remove(findOrder);
            }
        }
    }


    public int getNextOrderID(){
        return nextOrderId++;
    }

    public void getOrders(){
        for (Order order : orders) {
    
            System.out.println("ID: " + order.getId());
            System.out.println( " | Products: ");

            for (Map.Entry<Integer, Integer> entry : order.productOrders.entrySet()) {
                int productId = entry.getKey();
                System.out.print( productId);
            }

            System.out.println( " | Total Cost £" + order.getTotalCost());
            System.out.println(" | Status: " + order.getStatus());

        }
    }
}
