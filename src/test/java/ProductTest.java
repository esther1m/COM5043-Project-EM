import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    
    Product test_product1;
    int test_product1_checkQuantity;
    SupplierManagement supplierManagement;
    Supplier supplier;

    @BeforeEach
    void setup(){
        test_product1 = new Product(0, "Test", 5.70, 150,0,supplierManagement);
        supplier = new Supplier("test", 04678563567f, "email@test.com");
        supplierManagement.addSupplierToList(supplier);
    }

    //checking the object initalises as it should by checking each field is correct
    @Test
    void testCreateProduct(){
        int test_product1_checkid = test_product1.getProductId();
        String test_product1_checkname = test_product1.getProductName();
        double test_product1_checkprice = test_product1.getProductPrice();
        test_product1_checkQuantity = test_product1.getProductQuantity();

        assertEquals(0, test_product1_checkid);
        assertEquals("Test", test_product1_checkname);
        assertEquals(5.70, test_product1_checkprice);
        assertEquals(150, test_product1_checkQuantity);
    }

    //checking if addStock increases the quantity by asserting equals
    @Test
    void testAddStock(){
        test_product1.addStock(50);
        test_product1_checkQuantity = test_product1.getProductQuantity();

        assertEquals(200, test_product1_checkQuantity);
    }

    //testing if the system properly removes stock by checking decreasing quantity
    @Test
    void testRemoveStock(){
        test_product1.removeStock(50);
        test_product1_checkQuantity = test_product1.getProductQuantity();

        assertEquals(100, test_product1_checkQuantity);
    }

    //checking if the system refuses to add and remove negative stock by checking unchanging quantity
    @Test
    void testNegativeStock(){
        test_product1.addStock(-50);
        test_product1_checkQuantity = test_product1.getProductQuantity();
        assertEquals(150, test_product1_checkQuantity);

        test_product1.removeStock(-50);
        test_product1_checkQuantity = test_product1.getProductQuantity();
        assertEquals(150, test_product1_checkQuantity);
    }

    //testing if the system will remove more stock than available by checking unchanging quantity
    @Test
    void testRemoveTooMuchStock(){
        test_product1.removeStock(160);
        test_product1_checkQuantity = test_product1.getProductQuantity();

        assertEquals(150, test_product1_checkQuantity);
    }

    //testing if the system will remove stock when quantity is 0, by checking quantity remains 0
    @Test
    void testRemoveZeroStock(){
        test_product1.removeStock(150);
        test_product1.removeStock(10);
        test_product1_checkQuantity = test_product1.getProductQuantity();

        assertEquals(0, test_product1_checkQuantity);
    }
}
