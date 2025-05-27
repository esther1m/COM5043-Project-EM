import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SupplierTest {
    
    Supplier test_supplier;
    //int test_product1_checkQuantity;
    
    @BeforeEach
    void setup(){
        test_supplier = new Supplier(0, "Test", 09876543210f, "test@email.com");
    }

    //checking the object initalises as it should by checking each field is correct
    @Test
    void testCreateSupplier(){
        int test_supplier_checkid = test_supplier.getSupplierId();
        String test_supplier_checkname = test_supplier.getSupplierName();
        float test_supplier_checkphone = test_supplier.getSupplierPhoneNumber();
        String test_supplier_checkemail = test_supplier.getSupplierEmail();
        ArrayList <Product> test_supplier_checklist = test_supplier.getSupplierOrderHistory();

        assertEquals(0, test_supplier_checkid);
        assertEquals("Test", test_supplier_checkname);
        assertEquals(09876543210f, test_supplier_checkphone);
        assertTrue(test_supplier_checklist.isEmpty());
    }
}
