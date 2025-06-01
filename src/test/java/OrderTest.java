import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class OrderTest {
    Order test_order0;
    SupplierManagement test_supplierManagement;
    
    @BeforeEach
    void setup(){
        test_order0 = new Order(0, 0);
        test_supplierManagement = new SupplierManagement();
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
        int supplierid_1 = test_supplierManagement.defaultSupplier1.getSupplierId();
      
        Product test_product = new Product(0, "Test", 7.00, 80, supplierid_1);
        test_order0.addProductsToOrder(test_product, 70);

        assertEquals(10, test_product.getProductQuantity());
        assertEquals("Order complete", test_order0.getStatus());
    }
//incomplete
    @Test
    void testAddMultipleProductsToOrder(){
        int supplierid_1 = test_supplierManagement.defaultSupplier1.getSupplierId();
        int supplierid_2 = test_supplierManagement.defaultSupplier2.getSupplierId();
        Product test_product = new Product(0, "Test", 7.00, 80, supplierid_1);
        Product test_product1 = new Product(1, "Test1", 7.00, 30, supplierid_1);
        Product test_product2 = new Product(2, "Test2", 6.00, 10, supplierid_2);
    }
}
