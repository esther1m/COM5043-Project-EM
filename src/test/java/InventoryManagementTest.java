import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

//setting up variables for all tests
public class InventoryManagementTest {

    private InventoryService test_inventory;
    private SupplierService test_supplierService;
    Product test_product0;
    Product test_product1;
    Product test_product2;
  
    @BeforeEach
    void setup(){
        test_inventory = new InventoryService();
        test_supplierService = new SupplierService();

        int supplierid_1 = test_supplierService.defaultSupplier1.getSupplierId();
        int supplierid_2 = test_supplierService.defaultSupplier2.getSupplierId();
        test_product0 = new Product("test", 3.00, 50, supplierid_1, 50, 15);
        test_product1 = new Product("Second test", 6.00, 40, supplierid_1, 60, 20);
        test_product2 = new Product("Third test", 30.00, 0, supplierid_2, 70, 5);
        

        test_inventory.addProduct(test_product1);
    }

    //testing that the addProduct function works as expected by checking the id and name against the hashmap
    //should return true when product is valid
    @Test
    void testAddProduct(){
        //int test_p0_id = test_product0.getProductId();
        boolean addingProduct = test_inventory.addProduct(test_product0);
        //Product checktestproduct = test_inventory.getProductById(test_p0_id);

        assertTrue(addingProduct, "Inventory should be added");
        //assertNotNull(checktestproduct, "Product should be added with no errors");
        assertEquals("test", test_product0.getProductName());
    }

    //testing the system doesn't add a null product
    //should return false
    @Test
    void testAddNullProduct() {
        assertFalse(test_inventory.addProduct(null));
    }

     //testing the system won't add a product that already exists due to boolean addProduct method
     //should return false
     @Test
     void testNoDuplicateProduct(){
        test_inventory.addProduct(test_product1);
        boolean result = test_inventory.addProduct(test_product1);
        assertFalse (result, "Inventory should reject adding duplicate products.");
     }

    // testing getproductbyid works by assert equals (should be the same product)
    @Test
    void testGetProductById(){
        test_inventory.addProduct(test_product1);
        int id = test_product1.getProductId();
        Product checktestproductbyid = test_inventory.getProductById(id);
        assertEquals(checktestproductbyid, test_product1);
    }

    //testing getproductbyid doesn't return null values (should be null)
    @Test
    void testGetNullProductById(){
        assertNull(test_inventory.getProductById(999));
    }
    

    //testing that the removeProduct function works as expected by checking the id against the hashmap
   //should return true
    @Test
    void testRemoveProduct(){
        int id = test_product2.getProductId();
        test_inventory.addProduct(test_product2);
        boolean result = test_inventory.removeProduct(id);
        Product checktestproduct = test_inventory.getProductById((id));
        assertTrue(result);
        assertNull(checktestproduct, "Product should be remove with no errors");
    }

   

    //testing the system won't remove a nonexisting product by checking for null value
    //should return false
    @Test
    void testRemovalNonexistentProduct(){
        assertFalse(test_inventory.removeProduct(999));
    }
/* 
    //testing the system returns null for nonexistent id by checking for null value
    @Test
    void testNonexistentId(){
        Product checktestproductbyid = test_inventory.getProductById(4);
        assertNull(checktestproductbyid, "Product shouldn't exist, should return null");
    }*/
/* 
    //testing the system doesn't remove a non existent product
    @Test
    void testRemoveNonexistentProduct() {
        Supplier test_supplier = new Supplier("TestSupplier", 02074587654f, "test@test");
        test_supplierManagement.addSupplierToList(test_supplier);

        Product product = new Product("Nonexistent", 5.0, 5, 1, test_supplierManagement);
        assertFalse(test_inventory.removeProduct(999));
    }*/

    //checking getTotalValue returns corrrect total
    @Test
    void testgetTotalValue(){
        test_inventory.addProduct(test_product0);
        test_inventory.addProduct(test_product1);
        double total = test_inventory.getTotalValue();
        assertEquals(390, total);

    }

    //checking getTotalValue returns zero when the inventory is empty

    @Test
    void testgetTotalValue_EmptyInventory(){
        double total = test_inventory.getTotalValue();
        assertEquals(0, total);

    }

}

