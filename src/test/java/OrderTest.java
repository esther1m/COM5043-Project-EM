import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class OrderTest {
    Order test_order0;
    SupplierManagement test_supplierManagement;
    
    @BeforeEach
    void setup(){
        test_order0 = new Order(0, 0);
        test_supplierManagement = new SupplierManagement();
        Supplier test_supplier1 = new Supplier("test", 07875432578f, "email@email.com");
        test_supplierManagement.addSupplierToList(test_supplier1);
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
        Supplier test_supplier = test_supplierManagement.defaultSupplier1;
        int supplierid_1 = test_supplier.getSupplierId();
      
        Product test_product = new Product("Test", 7.00, 80, supplierid_1, test_supplierManagement);
        test_order0.addProductsToOrder(test_product, 70);

        assertEquals(160, test_product.getProductQuantity());
        assertEquals("Order complete", test_order0.getStatus());
    }
//testing adding multiple products to one order
    @Test
    void testAddMultipleProductsToOrder(){
        Order test_order2 = new Order(70, 553);
        int supplierid_1 = test_supplierManagement.defaultSupplier1.getSupplierId();
        int supplierid_2 = test_supplierManagement.defaultSupplier2.getSupplierId();
        Product test_product = new Product("Test", 7.00, 80, supplierid_1, test_supplierManagement);
        Product test_product1 = new Product("Test1", 7.00, 30, supplierid_1, test_supplierManagement);
        Product test_product2 = new Product("Test2", 6.00, 10, supplierid_2, test_supplierManagement);

        test_order2.addProductsToOrder(test_product, 4);
        test_order2.addProductsToOrder(test_product1, 1);
        test_order2.addProductsToOrder(test_product2, 1);

        assertEquals(76, test_product.getProductQuantity());
        assertEquals(29, test_product1.getProductQuantity());
        assertEquals(159, test_product2.getProductQuantity());
        assertEquals("Order complete", test_order2.getStatus());

    }

    @Test
    void testOrderStatusAfterInvalidAdd() {
        Order test_order1 = new Order(90, 679);
        assertFalse(test_order1.addProductsToOrder(null, 0));
        assertEquals("Failed to place order of null due to stock issues", test_order1.getStatus());
}

}
