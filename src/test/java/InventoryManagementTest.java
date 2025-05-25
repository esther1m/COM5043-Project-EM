
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagementTest {
    //testing that the addProduct function works as expected
    @Test
    void testAddProduct(){
        InventoryManagement test_inventory = new InventoryManagement();
        Product test_product = new Product(0, "test", 3.00, 50);

        test_inventory.addProduct(test_product);
        Product checktestproduct = test_inventory.getProductById(0);

        assertNotNull(checktestproduct, "Product should be added with no errors");
        assertEquals("test", test_product.getProductName());
    }
}

