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
    }

    //testing that the addProduct function works as expected by checking the id and name against the hashmap
    @Test
    void testAddProduct(){
        test_inventory.addProduct(test_product0);
        Product checktestproduct = test_inventory.getProductById(0);

        assertNotNull(checktestproduct, "Product should be added with no errors");
        assertEquals("test", test_product0.getProductName());
    }

    // testing getproductbyid works by assert equals (should be the same product)
    @Test
    void testGetProductById(){
        test_inventory.addProduct(test_product1);
        
        Product checktestproductbyid = test_inventory.getProductById(1);
        assertEquals(checktestproductbyid, test_product1);
    }

    //testing that the removeProduct function works as expected by checking the id against the hashmap
    @Test
    void testRemoveProduct(){
        test_inventory.removeProduct(test_product0);
        Product checktestproduct = test_inventory.getProductById(0);
        assertNull(checktestproduct, "Product should be remove with no errors");
    }
}

