import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SupplierManagementTest {

    SupplierManagement test_suppliermanagement;
    Supplier test_supplier;

    @BeforeEach
    void setup(){
        test_suppliermanagement = new SupplierManagement();
        test_supplier = new Supplier("test supplier", 0363454637764f, "test@supplier.com");
    }

    //checking a supplier can be successfuly be added to the method by checking the array is not null
    @Test
    void testAddSupplierToList(){
        test_suppliermanagement.addSupplierToList(test_supplier);
        assertNotNull(test_suppliermanagement.supplierList);
    }

    //testing a supplier can be successfuly removed from the method by checking the array is null
    @Test
    void testDeleteSupplierFromList(){
        test_suppliermanagement.deleteSupplierFromList(test_supplier.getSupplierId());
        assertEquals(2, test_suppliermanagement.supplierList.size());
    }

    //testing updatng supplier contacts
    @Test
    void testUpdateSupplierContacts(){
        test_suppliermanagement.updateSupplierContactDetails(test_supplier, 0, null);

        assertEquals(test_supplier.getSupplierPhoneNumber(), 0);
        assertNull(test_supplier.getSupplierEmail());
    }
}
