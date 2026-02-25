import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FinancialManagementTest {
    SupplierService supplierManagement;
    InventoryService inventory;
    OrderService orderService;
    Supplier supplier;
    int preferredSupplierID;
    Product product1;
    Product product2;
    Order order;
    ArrayList<Order> orders;

    @BeforeEach
    void setup(){
        supplierManagement = new SupplierService();
        inventory = new InventoryService(supplierManagement);
        orderService = new OrderService(inventory);
        
        supplier = new Supplier("test", "075648364465" ,"test@test");
        supplierManagement.addSupplierToList(supplier);
        preferredSupplierID = supplier.getSupplierId();

        // adding products to the inventory
        product1 = new Product("Widget", 10.0, 5, preferredSupplierID, 2, 5); // £50 stock value
        product2 = new Product("Gadget", 20.0, 3, preferredSupplierID, 3, 1); // £60 stock value
        inventory.addProduct(product1);
        inventory.addProduct(product2);

       
    }
    @Test
    void testFinancialCalculationsAreCorrect() {
        // creating order (simulate sale of 2 gadgets = £40)
        order = new Order(789, orderService.getNextOrderID(), inventory);
        order.addProductsToOrder(product1, 1); 
        order.addProductsToOrder(product2, 2);

        orders = new ArrayList<>();
        orders.add(order);
        // testing the calculation
        FinancialService report = new FinancialService(orders, inventory);

        double inventoryValue = report.calculateInventory();
        double salesRevenue = report.calculateSalesRevenue();
        double netIncome = salesRevenue - inventoryValue;

 
        assertEquals(60.0, inventoryValue); 
        assertEquals(50.0, salesRevenue);     
        assertEquals(-10, netIncome);       // loss scenario
    }

    @Test
    void testPositiveIncome() {

        Order order = new Order(765,orderService.getNextOrderID(), inventory);
        order.addProductsToOrder(product1, 5); // Sale £50
        order.addProductsToOrder(product2, 3);

        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);

        FinancialService report = new FinancialService(orders, inventory);
        assertEquals(0, report.calculateInventory());
        assertEquals(110.0, report.calculateSalesRevenue());
        assertEquals(110, report.calculateSalesRevenue() - report.calculateInventory());
}

}

