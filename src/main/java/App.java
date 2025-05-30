import java.util.Scanner;

public class App {

    String user_input;
    Scanner scanner = new Scanner(System.in);
    OrderProcessing orderProcessing = new  OrderProcessing();
    //Product product = new Product(0, user_input, 0, 0)
    InventoryManagement inventoryManagement = new InventoryManagement();

    public void menu(){
        user_input = null;

        while (user_input == null) {
            System.out.println("Welcome to the Warehouse Management System.");
            System.out.println("Please select an option:");
            System.out.println("1. View Order History");
            System.out.println("2. View Products");
            //System.out.println("3. Add Products");
            System.out.println("3. Place an Order");
            System.out.println("4. View Suppliers");
            //System.out.println("5. Edit Supplier Details");
            //System.out.println("6. View Financial Report");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            user_input = scanner.nextLine();

            if (user_input == "1"){
                orderProcessing.getOrders();
            } if (user_input == "2"){
                inventoryManagement.getProducts();
            } if (user_input == "3") {
                int user_id = scanner.nextInt();
                System.out.println("Please Enter your customer id. If you have never shopper with us before, please enter the ID of your choosing:");
                int user_add_product = scanner.nextInt();

                while (user_add_product != 1) {
                    int user_add = scanner.nextInt();
                    System.out.println("Please place your order using the product ids to add them to your order. Press 1 to checkout.");
                    Product product = user_add.
                    System.out.println("What's the quantity of " + user_add);
                }
                orderProcessing.placeOrder(0, user_id, null);
            }
        }
    }





    public static void main(String[] args) throws Exception {

        

    }
}
