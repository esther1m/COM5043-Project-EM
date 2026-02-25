import java.util.*;

public class OrderService {
    public ArrayList <Order> orders;
    private static int nextOrderId = 0;
    private int orderid;
    private InventoryService inventoryManagement;

    public OrderService(InventoryService inventory){
        orders = new ArrayList<>();
        this.inventoryManagement = inventory;
    }

    public void placeOrder( int customerid, HashMap<Product, Integer> products){
        orderid = getNextOrderID();
        
        Order order1 = new Order(customerid, orderid, inventoryManagement);
        
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            order1.addProductsToOrder(product, quantity);
            if ((product.getProductQuantity() - quantity) < product.getReorderThreshold()){
                inventoryManagement.reorderStock(product.getProductId());
            }
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
/* 
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
    }*/


    public int getNextOrderID(){
       // nextOrderId = nextOrderId+1;
        return nextOrderId++;
    }

    public void getOrders(){
        if (orders.size() == 0 ){
            System.out.println("No orders created yet. Please create orders to view their history.");   
        }
        for (Order order : orders) {
    
            System.out.println("Order ID: " + order.getId());
            System.out.println( "Products Ordered: ");

            for (Map.Entry<Integer, Integer> entry : order.productsOrdered.entrySet()) {
                int productId = entry.getKey();
                Product product = inventoryManagement.getProductById(productId);
                System.out.print( product.getProductName());
            }

            System.out.println( "\nTotal Cost £" + order.getTotalCost());
            System.out.println("Status: " + order.getStatus());

        }
    }
}
