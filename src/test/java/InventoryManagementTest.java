import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

//setting up variables for all tests
public class InventoryManagementTest {
    InventoryManagement test_inventory;
    Product test_product0;
    Product test_product1;
  
    @BeforeEach
    void setup(){
        test_inventory = new InventoryManagement();
        test_product0 = new Product(0, "test", 3.00, 50);
        test_product1 = new Product(1, "Second test", 6.00, 40);

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
        test_inventory.removeProduct(test_product1);
        Product checktestproduct = test_inventory.getProductById(1);
        assertNull(checktestproduct, "Product should be remove with no errors");
    }

    //testing the system won't add a product that already exists
    @Test
    void testNoDuplicateProduct(){
        test_inventory.addProduct(test_product1);
        boolean result = test_inventory.addProduct(test_product1);
        assertFalse (result, "Inventory should reject adding duplicate products.");
    }

    //testing the system won't remove a nonexisting product
    @Test
    void testRemovalNonexistentProduct(){
        test_inventory.removeProduct(test_product1);
        assertNull(test_inventory.getProductById(1), "Nonexistent product removal should have no effect");
    }

    //testing the system returns null for nonexistent id
    @Test
    void testNonexistentId(){
        Product checktestproductbyid = test_inventory.getProductById(4);
        assertNull(checktestproductbyid, "Product shouldn't exist, should return null");
    }
}

