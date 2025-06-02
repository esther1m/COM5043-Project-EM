import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

//setting up variables for all tests
public class OrderProcessingTest {

    @Test
    void testCreateAndCancelOrder() {
        InventoryManagement test_inventory = new InventoryManagement();
        SupplierManagement test_sm = new SupplierManagement();
        Supplier test_supplier = new Supplier("test", 087472037485f, "email@email.com");
        HashMap <Product, Integer> products = new HashMap<>();

        test_sm.addSupplierToList(test_supplier);

        Product product = new Product("TestItem", 10.0, 10, 1, test_sm);
        int product_id = product.getProductId();
        test_inventory.addProduct(product);
        products.put(product, 5);

        OrderProcessing test_op = new OrderProcessing();
        test_op.placeOrder(6, 679, products);
        
        assertEquals(155, test_inventory.getProductById(product_id).getProductQuantity());

        test_op.cancelOrder(6);
        assertEquals(155, test_inventory.getProductById(product_id).getProductQuantity());
    }
}