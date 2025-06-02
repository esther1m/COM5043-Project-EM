import java.util.ArrayList;
import java.util.Map;;

public class FinancialManagement {
    private InventoryManagement inventory;
    private ArrayList<Order> orders;
    private OrderProcessing orderProcessing;
    double total;

    public FinancialManagement(InventoryManagement inventory, ArrayList <Order> orders){
        this.inventory = inventory;
        this.orders = orders;
    }

    public double calculateInventory(){
        total = 0.0;
        total = inventory.getTotalValue();
        return total;
    }

    public double calculateSalesRevenue(){
        total = 0.0;
        for (Order order : orders) {
            total += order.getTotalCost();
        }
        return total;
    }

    public void generateReport() {
        double inventoryValue = calculateInventory();
        double sales = calculateSalesRevenue();
        double net = sales - inventoryValue;

        System.out.println("----- Financial Report -----");
        System.out.println("Total Inventory Value: £" + inventoryValue);
        System.out.println("Total Sales Revenue: £" + sales);
        System.out.println("Net Income: £" + net);
        System.out.println("----------------------------");
    }
}
