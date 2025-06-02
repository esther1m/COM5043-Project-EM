import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SupplierTest {
    
    Supplier test_supplier;
    Product test_product4;
    SupplierManagement supplierManagement;
    //int test_product1_checkQuantity;
    
    @BeforeEach
    void setup(){
        test_supplier = new Supplier( "Test", 09876543210f, "test@email.com");
        int test_supplier_id = test_supplier.getSupplierId();
        supplierManagement = new SupplierManagement();
        supplierManagement.addSupplierToList(test_supplier);
        test_product4 = new Product("Test", 5.70, 150, test_supplier_id, supplierManagement);
        
    }

    //checking the object initalises as it should by checking each field is correct
    @Test
    void testCreateSupplier(){
        String test_supplier_checkname = test_supplier.getSupplierName();
        float test_supplier_checkphone = test_supplier.getSupplierPhoneNumber();
        String test_supplier_checkemail = test_supplier.getSupplierEmail();
        ArrayList <Product> test_supplier_checklist = test_supplier.getSupplierOrderHistory();

        
        assertEquals("Test", test_supplier_checkname);
        assertEquals(09876543210f, test_supplier_checkphone);
        assertTrue(test_supplier_checklist.isEmpty());
    }

    //checking the setter methods work
    @Test
    void testSetters(){
        test_supplier.setSupplierPhoneNumber(12345678900f);
        test_supplier.setSupplierEmail("testee@emails.com");

        assertEquals(12345678900f, test_supplier.getSupplierPhoneNumber());
        assertEquals("testee@emails.com", test_supplier.getSupplierEmail());
    }

    //checking the product to order history adder
    @Test
    void testAddProduct(){
        test_supplier.addOrderHistory(test_product4);
        ArrayList<Product> history = test_supplier.getSupplierOrderHistory();

        assertEquals(test_product4, history.get(0));
    }
}
