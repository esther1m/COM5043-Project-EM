import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class OrderTest {
    private Order test_order0;
    private OrderService testOS;
    private SupplierService test_supplierManagement;
    private Supplier test_supplier1;
    private HashMap <Product, Integer> products;
    private InventoryService test_inventory;

    private Product test_product0;
    private Product test_product1;
    
    @BeforeEach
    void setup(){
        
        test_supplierManagement = new SupplierService();
        test_supplier1 = new Supplier("test", "07875432578", "email@email.com");
        test_supplierManagement.addSupplierToList(test_supplier1);
        test_inventory = new InventoryService(test_supplierManagement);

        int supplierid = test_supplier1.getSupplierId();

        test_product0 = new Product("test", 3.00, 50, supplierid, 50, 15);
        test_product1 = new Product("Second test", 6.00, 40, supplierid, 60, 20);
        testOS = new OrderService(test_inventory);
        int orderid = testOS.getNextOrderID();
        test_order0 = new Order(6786, orderid, test_inventory);
    }

    @Test
    void testCreateOrder(){

        
    }
//testig that adding products to an order reduces product stock and increases the total
    @Test
    void testAddProductsToOrder(){
        //Supplier test_supplier = test_supplierManagement.defaultSupplier1;
        //int supplierid_1 = test_supplier.getSupplierId();
      
       // Product test_product = new Product("Test", 7.00, 80, supplierid_1, test_supplierManagement);
        boolean result1 = test_order0.addProductsToOrder(test_product0, 30);
        boolean result2 = test_order0.addProductsToOrder(test_product1, 10);

        assertTrue(result1, "Expected to succeed");
        assertTrue(result2, "Expected to succeed");

        assertEquals(20, test_product0.getProductQuantity());
        assertEquals(30, test_product1.getProductQuantity());

        assertEquals(150, test_order0.getTotalCost());
        assertEquals("Order complete", test_order0.getStatus());
    }
/* 
//testing adding multiple products to one order
    @Test
    void testAddMultipleProductsToOrder(){
        //Order test_order2 = new Order(70, 553);
        int supplierid_1 = test_supplierManagement.defaultSupplier1.getSupplierId();
        int supplierid_2 = test_supplierManagement.defaultSupplier2.getSupplierId();
        

        test_order0.addProductsToOrder(test_product0, 4);
        test_order0.addProductsToOrder(test_product1, 1);
        //test_order2.addProductsToOrder(test_product2, 1);

        assertEquals(76, test_product0.getProductQuantity());
        assertEquals(29, test_product1.getProductQuantity());
        //assertEquals(159, test_product2.getProductQuantity());
        assertEquals("Order complete", test_order0.getStatus());

    }*/

    //testing how system handles null product
    @Test
    void testOrderStatusAfterInvalidAdd() {
        //Order test_order1 = new Order(90);
        assertFalse(test_order0.addProductsToOrder(null, 0));
        assertEquals("Failed to place order of " + null, test_order0.getStatus());

        boolean result1 = test_order0.addProductsToOrder(null, 30);
        assertFalse(result1, "Adding null product should return false");
}
    //testing the system puts the order as processing in its initial state
    @Test
    void orderInitialState(){
        assertEquals("Processing", test_order0.getStatus());
        assertEquals(0.0, test_order0.getTotalCost());
        assertTrue(test_order0.getId() >= 0, "Order id should be a positive int");
    }
}
