import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FinancialManagementTest {

    @Test
    void testFinancialCalculationsAreCorrect() {
        InventoryManagement inventory = new InventoryManagement();
        SupplierManagement supplierManagement = new SupplierManagement();
        Supplier supplier = new Supplier("test", 075648364465f ,"test@test");
        supplierManagement.addSupplierToList(supplier);
        int preferredSupplierID = supplier.getSupplierId();

        // adding products to the inventory
        Product product1 = new Product(1, "Widget", 10.0, 5, preferredSupplierID, supplierManagement); // £50 stock value
        Product product2 = new Product(2, "Gadget", 20.0, 3, preferredSupplierID, supplierManagement); // £60 stock value
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // creating order (simulate sale of 2 gadgets = £40)
        Order order = new Order(4, 789);
        order.addProductsToOrder(product1, 2); // 2 gadgets ordered
        order.addProductsToOrder(product2, 1);

        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);

        // testing the calculation
        FinancialManagement report = new FinancialManagement(inventory, orders);

        double inventoryValue = report.calculateInventory();
        double salesRevenue = report.calculateSalesRevenue();
        double netIncome = salesRevenue - inventoryValue;

 
        assertEquals(4570.0, inventoryValue, 0.01); 
        assertEquals(40.0, salesRevenue, 0.01);     // 2 x £20
        assertEquals(-4530, netIncome, 0.01);       // loss scenario
    }

    @Test
    void testNetIncomeZero() {
        InventoryManagement inventory2 = new InventoryManagement();
        SupplierManagement sm = new SupplierManagement();
        Supplier supplier = new Supplier("test supplier 2", 75859756378f, "emai@email.com");
        sm.addSupplierToList(supplier);
        int preferredSupplierID = supplier.getSupplierId();

        Product p1 = new Product(60, "BalanceItem", 10.0, 5, preferredSupplierID, sm); // Inventory £50
        inventory2.addProduct(p1);

        Order order = new Order(765, 4);
        order.addProductsToOrder(p1, 5); // Sale £50

        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);

        FinancialManagement report = new FinancialManagement(inventory2, orders);
        assertEquals(1500.0, report.calculateInventory(), 0.01);
        assertEquals(50.0, report.calculateSalesRevenue(), 0.01);
        assertEquals(-1450.0, report.calculateSalesRevenue() - report.calculateInventory(), 0.01);
}

}

