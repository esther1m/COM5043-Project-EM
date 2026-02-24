import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SupplierTest {
    
    Supplier test_supplier;
    Supplier test_supplier2;
    Product test_product4;
    SupplierService supplierManagement;
    //int test_product1_checkQuantity;
    
    @BeforeEach
    void setup(){
        test_supplier = new Supplier( "Test", "09876543210", "test@email.com");
        test_supplier2 = new Supplier( "Test2", "1234567890", "email@test.com");
        int test_supplier_id = test_supplier.getSupplierId();
        supplierManagement = new SupplierService();
        supplierManagement.addSupplierToList(test_supplier);
        test_product4 = new Product("Test", 5.70, 150, test_supplier_id, 50, 30);
        
    }

    //checking the object initalises as it should by checking each field is correct
    @Test
    void testCreateSupplier(){
        int test_id = test_supplier.getSupplierId();
        int test_id2 = test_supplier2.getSupplierId();
        String test_supplier_checkname = test_supplier.getSupplierName();
        String test_supplier_checkphone = test_supplier.getSupplierPhoneNumber();
        String test_supplier_checkemail = test_supplier.getSupplierEmail();
        ArrayList <Product> test_supplier_checklist = test_supplier.getSupplierOrderHistory();

        assertNotEquals(test_id, test_id2);
        assertEquals("Test", test_supplier_checkname);
        assertEquals("09876543210", test_supplier_checkphone);
        assertEquals("test@email.com", test_supplier_checkemail);
        assertTrue(test_supplier_checklist.isEmpty());
    }

    //checking the setter methods work
    @Test
    void testSetters(){
        test_supplier.setSupplierName("Supplier");
        test_supplier.setSupplierPhoneNumber("12345678900");
        test_supplier.setSupplierEmail("testee@emails.com");

        assertEquals("Supplier", test_supplier.getSupplierName());
        assertEquals("12345678900", test_supplier.getSupplierPhoneNumber());
        assertEquals("testee@emails.com", test_supplier.getSupplierEmail());
    }

    //checking the product to order history adder
    @Test
    void testAddProduct(){
        test_supplier.addOrderHistory(test_product4);
        //ArrayList<Product> history = test_supplier.getSupplierOrderHistory();

        //assertEquals(test_product4, history.get(0));
        assertEquals(1, test_supplier.getSupplierOrderHistory().size());
        assertEquals(test_product4, test_supplier.getSupplierOrderHistory().get(0));
    }

    //checking ordering stock increases the product quantity and adds it to history
    @Test
    void testOrderStock(){
        test_supplier.orderStock(test_product4, 50);

        assertEquals(200, test_product4.getProductQuantity());
        assertEquals(1, test_supplier.getSupplierOrderHistory().size());
    }

    //checkig ordering negative stock does nothing and no throw
    @Test
    void testOrderStock_negattive(){
        test_supplier.orderStock(test_product4, -199);
        assertEquals(150, test_product4.getProductQuantity());
    }
}
