import java.util.ArrayList;
import java.util.*;

public class OrderProcessing {
    ArrayList <Order> orders;

    public OrderProcessing(){
        orders = new ArrayList<>();
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
        orders.remove(findOrder);
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }
}
