import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

//setting up variables for all tests
public class InventoryManagementTest {
    InventoryManagement test_inventory;
    SupplierManagement test_supplierManagement;
    Product test_product0;
    Product test_product1;
    Product test_product2;
  
    @BeforeEach
    void setup(){
        test_inventory = new InventoryManagement();
        test_supplierManagement = new SupplierManagement();
        int supplierid_1 = test_supplierManagement.defaultSupplier1.getSupplierId();
        int supplierid_2 = test_supplierManagement.defaultSupplier2.getSupplierId();
        test_product0 = new Product(0, "test", 3.00, 50, supplierid_1, test_supplierManagement);
        test_product1 = new Product(1, "Second test", 6.00, 40, supplierid_1, test_supplierManagement);
        test_product2 = new Product(2, "Third product", 30.00, 0, supplierid_2, test_supplierManagement);

        test_inventory.addProduct(test_product1);
    }

    //testing that the addProduct function works as expected by checking the id and name against the hashmap
    @Test
    void testAddProduct(){
        boolean addingProduct = test_inventory.addProduct(test_product0);
        Product checktestproduct = test_inventory.getProductById(0);

        assertTrue(addingProduct, "Inventory should be added");
        assertNotNull(checktestproduct, "Product should be added with no errors");
        assertEquals("test", test_product0.getProductName());
    }

    // testing getproductbyid works by assert equals (should be the same product)
    @Test
    void testGetProductById(){
        Product checktestproductbyid = test_inventory.getProductById(1);
        assertEquals(checktestproductbyid, test_product1);
    }

    //testing that the removeProduct function works as expected by checking the id against the hashmap
    @Test
    void testRemoveProduct(){
        test_inventory.removeProduct(test_product1.getProductId());
        Product checktestproduct = test_inventory.getProductById(1);
        assertNull(checktestproduct, "Product should be remove with no errors");
    }

    //testing the system won't add a product that already exists due to boolean addProduct method
    @Test
    void testNoDuplicateProduct(){
        boolean result = test_inventory.addProduct(test_product1);
        assertFalse (result, "Inventory should reject adding duplicate products.");
    }

    //testing the system won't remove a nonexisting product by checking for null value
    @Test
    void testRemovalNonexistentProduct(){
        test_inventory.removeProduct(test_product2.getProductId());
        assertNull(test_inventory.getProductById(2), "Nonexistent product removal should have no effect");
    }

    //testing the system returns null for nonexistent id by checking for null value
    @Test
    void testNonexistentId(){
        Product checktestproductbyid = test_inventory.getProductById(4);
        assertNull(checktestproductbyid, "Product shouldn't exist, should return null");
    }
}

