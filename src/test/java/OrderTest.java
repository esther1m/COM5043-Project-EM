import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class OrderTest {
    Order test_order0;
    
    @BeforeEach
    void setup(){
        test_order0 = new Order(0, 0);
    }

    @Test
    void testCreateOrder(){


        int test_id = test_order0.getId();
        //int test_customerId = test_order0.get
        double test_totalCost = test_order0.getTotalCost();
        String test_status = test_order0.getStatus();

        assertEquals(0, test_id);
        assertEquals(0, test_totalCost);
        assertEquals("Processing", test_status);
    }

    @Test
    void testAddProductsToOrder(){
        Product test_product = new Product(0, "Test", 7.00, 80);
        test_order0.addProductsToOrder(test_product, 70);

        assertEquals(10, test_product.getProductQuantity());
        assertEquals("Order complete", test_order0.getStatus());
    }

    @Test
    void testAddMultipleProductsToOrder(){
        Product test_product = new Product(0, "Test", 7.00, 80);
        Product test_product1 = new Product(1, "Test1", 7.00, 30);
        Product test_product2 = new Product(2, "Test2", 6.00, 10);
    }
}
