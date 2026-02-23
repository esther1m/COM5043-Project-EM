import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

//setting up variables for all tests
public class OrderProcessingTest {

    private InventoryService test_inventory;
    private SupplierService test_sm;
    private OrderService test_op;
    private Supplier test_supplier;
    private Product product;
    private HashMap <Product, Integer> products;
    private Product test_product0;
    private Product test_product1;
    
  
    @BeforeEach
    void setup (){
        test_inventory = new InventoryService();
        test_sm = new SupplierService();
        test_op = new OrderService();
        test_supplier = new Supplier("test", "087472037485", "email@email.com");
        int supplierid = test_supplier.getSupplierId();
        products = new HashMap<>();
        test_product0 = new Product("test", 3.00, 50, supplierid, 50, 15);
        test_product1 = new Product("Second test", 6.00, 40, supplierid, 60, 20);
    }
/* 
    @Test
    void testCreateAndCancelOrder() {

        test_sm.addSupplierToList(test_supplier);

        int product_id = product.getProductId();
        test_inventory.addProduct(product);
        products.put(product, 5);

        OrderService test_op = new OrderService();
        test_op.placeOrder(679, products);
        
        assertEquals(155, test_inventory.getProductById(product_id).getProductQuantity());

        test_op.cancelOrder(6);
        assertEquals(155, test_inventory.getProductById(product_id).getProductQuantity());
    }*/

    //testing the system places an order and reduces inventory correctly
    @Test
    void testPlaceAnOrder(){
        //int product_id = product.getProductId();
        test_inventory.addProduct(test_product0);
        test_inventory.addProduct(test_product1);
        assertEquals(390, test_inventory.getTotalValue());
        products.put(test_product1, 5);
        products.put(test_product0, 10);
        test_op.placeOrder(457, products);

        assertEquals(330, test_inventory.getTotalValue());
        int orderId = (test_op.getNextOrderID() - 1);
        Order placed = test_op.getOrderbyId(orderId);
        assertNotNull(placed);
        assertEquals("Order complete", placed.getStatus());
    }

}