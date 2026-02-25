import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SupplierServiceTest {

    SupplierService test_suppliermanagement;
    Supplier test_supplier;

    @BeforeEach
    void setup(){
        test_suppliermanagement = new SupplierService();
        test_supplier = new Supplier("test supplier", "0363454637764", "test@supplier.com");
    }

    //checking the default suppliers exist when constructing
    @Test
    void testDefaultSuppliers(){
        assertNotNull(test_suppliermanagement.defaultSupplier1);
        assertNotNull(test_suppliermanagement.defaultSupplier2);
    }
    
    //checking a supplier can be successfuly be added to the method by checking the array is not null
    @Test
    void testAddSupplierToList(){
        
        //assertNotNull(test_suppliermanagement.supplierList);
        boolean added = test_suppliermanagement.addSupplierToList(test_supplier);
        assertTrue(added);
    }

    //testing a supplier cannot be duplicated
    @Test
    void testAddSupplierToList_duplicate(){
        boolean added = test_suppliermanagement.addSupplierToList(test_supplier);
        assertTrue(added);

        boolean added2 = test_suppliermanagement.addSupplierToList(test_supplier);
        assertFalse(added2);
    }

    //testing adding null suppliers, should return false
    @Test
    void testAddNullSupplier() {
        assertFalse(test_suppliermanagement.addSupplierToList(null));
    }

    //testing a supplier can be successfuly removed from the method by checking the array size goes back to default (2)
    @Test
    void testDeleteSupplierFromList(){
        test_suppliermanagement.addSupplierToList(test_supplier);
        test_suppliermanagement.deleteSupplierFromList(test_supplier.getSupplierId());
        assertEquals(2, test_suppliermanagement.supplierList.size());
    }

    //testing deleting a supplier removes them from the list
    @Test
    void testDeleteSupplier_deletesFromList(){
        Supplier remove = new Supplier("delete test", "09090909090", "test@delete.com");
        test_suppliermanagement.addSupplierToList(remove);
        int id = remove.getSupplierId();
        //ensuring succesful addition 
        assertEquals(remove, test_suppliermanagement.getSupplierById(id));

        //delete
        test_suppliermanagement.deleteSupplierFromList(id);
        assertNull(test_suppliermanagement.getSupplierById(id));

    }

    //testing deleting a nonexistent supplier is handed gracefully
    @Test
    void testDeleteSupplier_nonexistent(){
        assertDoesNotThrow(() -> test_suppliermanagement.deleteSupplierFromList(9999999));
    }

    //testing updatng supplier contacts
    @Test
    void testUpdateSupplierContacts(){
        test_suppliermanagement.addSupplierToList(test_supplier);
        test_suppliermanagement.updateSupplierContactDetails(test_supplier, "023232", "test@test");

        assertEquals(test_supplier.getSupplierPhoneNumber(), "023232");
        //assertNull(test_supplier.getSupplierEmail());
        assertEquals(test_supplier.getSupplierEmail(), "test@test");
    }

    //testing getting supplier by invalid id returns null
    @Test
    void testGetSupplierbyNullId(){
        assertNull(test_suppliermanagement.getSupplierById(999999));
    }



    

}
