import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    String user_input;
    Scanner scanner = new Scanner(System.in);
    OrderProcessing orderProcessing = new  OrderProcessing();
    HashMap<Product, Integer> products;
    //Product product = new Product(0, user_input, 0, 0)
    InventoryManagement inventoryManagement = new InventoryManagement();
    

    public void menu(){
        //user_input = null;

        //while (user_input == null) {
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
            //user_input = scanner.nextLine();

           /*  if (user_input == "1"){
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
            }*/
        //}
    }

    public void productsMenu(){
        System.out.println("Please select an option:");
        System.out.println("1. Add Products");
        System.out.println("2. Update Product quantity");
        System.out.println("3. Delete Product");
        System.out.println("4. Exit");
    }

    public void productsSwitch(){
        boolean check = true;

        while (check){
            productsMenu();
            user_input = scanner.nextLine();

            switch (user_input){
                case "1":
                    System.out.println("What's the product called?");
                    String user_product_name = scanner.nextLine();
                    System.out.println("What's the product's price?");
                    double user_product_price = scanner.nextDouble();
                    System.out.println("What quantity do we currently have of the product in stock?");
                    int user_product_quantity = scanner.nextInt();
                    scanner.nextLine();

                    Product product = new Product(0, user_product_name, user_product_price, user_product_quantity);
                    inventoryManagement.addProduct(product);
                    break;
                case "2":
                    int user_input_productid = scanner.nextInt();
                    System.out.println("What's the product id of the product you want to update the quantity for? ");
                    Product changing_product = inventoryManagement.getProductById(user_input_productid);

                    int user_input_quantity = scanner.nextInt();
                    System.out.println("What's the new quantity? ");
                    changing_product.setProductQuantity(user_input_quantity);
                    break;
                case "3":
                    int user_input_productid2 = scanner.nextInt();
                    System.out.println("What's the product id of the product you want to delete? ");
                    Product removing_product = inventoryManagement.getProductById(user_input_productid2);
                    inventoryManagement.removeProduct(removing_product);
                    break;
                case "4":
                    System.out.println("Exiting... returning to the main menu");
                    check = false;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;

            }
            
        }
    }

    public void runSystem(){
        boolean active = true;
        while (active) {
            menu();
            user_input = scanner.nextLine();

            switch (user_input) {
            //view order history
                case "1":
                    System.out.println(orderProcessing.getOrders());
                    break;
            //view products
                case "2":
                    System.out.println();
                    //System.out.println("ID |   Name    | Price | Quantity");
                    for (int productId : inventoryManagement.productsInventory.keySet()) {
                        Product product = inventoryManagement.getProductById(productId);
                        System.out.println("ID: " + productId + " | Name: "  + product.getProductName() + " | Price £" + product.getProductPrice() + " | Quantity: " + product.getProductQuantity());
                    }
                    productsSwitch();
                    break;
            //place an order
                case "3":
                    products = new HashMap<>();
                    //getting customer id
                    System.out.println("Please insert your customer ID or make one up now:");
                    int user_id = scanner.nextInt();
                    //getting auto generated order id
                    int user_order_id = orderProcessing.getNextOrderID();
                    //allowing user to add as many products as they want
                    Boolean not_complete = true;
                    while (not_complete){
                        System.out.println("Please add products to your order by entering the product id. When your order is complete, please type 'y.'");
                        if (scanner.equals("y")){
                            not_complete = false;
                        } else {
                            int user_product_id = scanner.nextInt();
                            System.out.println("What quantity would you like to buy? ");
                            int user_quantity = scanner.nextInt();
                            Product product = inventoryManagement.getProductById(user_product_id);
                            products.put(product, user_quantity);
                        }
                    }
                        orderProcessing.placeOrder(user_order_id, user_id, products);
                    break;

            //view suppliers
                case "4":
                    break;
            //exit
                case "5":
                    System.out.println("Exiting the system...");
                    System.out.println("Have a good day :)");
                    active = false;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        }
       

    }





    public static void main(String[] args) throws Exception {
        App app = new App();
        app.runSystem();

    }
}
