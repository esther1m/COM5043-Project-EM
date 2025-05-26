import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductTest {
    
    //checking the object initalises as it should by checking each field is correct
    @Test
    void testCreateProduct(){
        Product test_product1 = new Product(0, "Test", 5.70, 150);
        int test_product1_checkid = test_product1.getProductId();
        String test_product1_checkname = test_product1.getProductName();
        double test_product1_checkprice = test_product1.getProductPrice();
        int test_product1_checkQuantity = test_product1.getProductQuantity();

        assertEquals(test_product1_checkid, 0);
        assertEquals(test_product1_checkname, "Test");
        assertEquals(test_product1_checkprice, 5.70);
        assertEquals(test_product1_checkQuantity, 150);
    }

}
