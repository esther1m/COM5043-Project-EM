
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagementTest {
    //testing that the addProduct function works as expected
    InventoryManagement test_inventory = new InventoryManagement();
    Product test_product0 = new Product(0, "test", 3.00, 50);
    Product test_product1 = new Product(1, "Second test", 6.00, 40);
    Product checktestproduct = test_inventory.getProductById(0);

    @Test
    void testAddProduct(){
        test_inventory.addProduct(test_product0);

        assertNotNull(checktestproduct, "Product should be added with no errors");
        assertEquals("test", test_product0.getProductName());
    }

    @Test
    void testRemoveProduct(){
        test_inventory.removeProduct(test_product0);
        assertNull(checktestproduct, "Product should be remove with no errors");
    }
}

