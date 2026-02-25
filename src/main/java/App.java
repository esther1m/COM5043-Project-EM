import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    String user_input;
    Scanner scanner = new Scanner(System.in);
    
    HashMap<Product, Integer> products;
    //Product product = new Product(0, user_input, 0, 0)
    SupplierService supplierManagement = new SupplierService();
    InventoryService inventoryManagement = new InventoryService(supplierManagement);
    OrderService orderProcessing = new  OrderService(inventoryManagement);
    //Supplier supplier = new Supplier("Best Suppliers LTD", "075837825377", "bestsuppliersltd@gmail.com");
    //supplierManagement.addSupplierToList(supplier);

    public void menu(){
            System.out.println("Welcome to the Warehouse Management System.");
            System.out.println("Please select an option:");
            System.out.println("1. View Order History");
            System.out.println("2. View Products");
            //System.out.println("3. Add Products");
            System.out.println("3. Place an Order");
            System.out.println("4. View Suppliers");
            //System.out.println("5. Edit Supplier Details");
            //System.out.println("6. View Financial Report");
            System.out.println("5. View total inventory values");
            System.out.println("6. Generate a Financial Report");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            //user_input = scanner.nextLine();
    }

    public void productsMenu(){
        System.out.println("Please select an option:");
        System.out.println("1. View Products");
        System.out.println("2. Add Products");
        //System.out.println("2. Update Product quantity");
        System.out.println("3. Change price of Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Exit");
    }

    //revisit logic

    public void productsSwitch(){
        boolean check = true;

        while (check){
            productsMenu();
            user_input = scanner.nextLine();

            switch (user_input){
                case "1":
                    inventoryManagement.getProducts();
                    break;
                case "2":
                    System.out.println("What's the product called?");
                    String user_product_name = scanner.nextLine();
                    System.out.println("What's the product's price?");
                    double user_product_price = scanner.nextDouble();
                    System.out.println("What quantity do we currently have of the product in stock?");
                    int user_product_quantity = scanner.nextInt();
                    //System.out.print("What's the id of the preferred supplier for this product?");
                    //int user_product_supplier = scanner.nextInt();
                    System.out.println("When reordering " + user_product_name + " , how many should we buy?");
                    int user_product_reorder_quantity = scanner.nextInt();
                    System.out.println("At what stock threshold should we reorder " + user_product_name + " ");
                    int user_product_reorder_threshold = scanner.nextInt();
                    scanner.nextLine();

                    //int supplierId = supplier.getSupplierId();
                    Product product = new Product(user_product_name, user_product_price, user_product_quantity, 1, user_product_reorder_quantity, user_product_reorder_threshold);
                    inventoryManagement.addProduct(product);
                    
                    break;
                //case "3":
                    /*int user_input_productid = scanner.nextInt();
                    System.out.println("What's the product id of the product you want to update the quantity for? ");
                    Product changing_product = inventoryManagement.getProductById(user_input_productid);

                    int user_input_quantity = scanner.nextInt();
                    System.out.println("What's the new quantity? ");
                    changing_product.setProductQuantity(user_input_quantity);*/    
                    //break;
                case "3":
                    System.out.println("What's the product id of the product you want to change the price of? ");
                    int user_input_productid1 = scanner.nextInt();
                    scanner.nextLine();
                    Product changing_product = inventoryManagement.getProductById(user_input_productid1);
                    String productName0 = changing_product.getProductName();
                    System.out.println("What is the new price of " + productName0 + "?");
                    int user_input_price = scanner.nextInt();
                    scanner.nextLine();
                    changing_product.setPrice(user_input_price);
                    System.out.println("Price of " + productName0 + "successfully changed to " + user_input_price);
                    break;
                case "4":
                    
                    System.out.println("What's the product id of the product you want to delete? ");
                    int user_input_productid2 = scanner.nextInt();
                    scanner.nextLine();
                    Product removing_product = inventoryManagement.getProductById(user_input_productid2);
                    String productName = removing_product.getProductName();
                    inventoryManagement.removeProduct(user_input_productid2);
                    System.out.println(productName + " has been successfully deleted from inventory.");
                    break;
                case "5":
                    System.out.println("Exiting... returning to the main menu");
                    check = false;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;

            }
            
        }
    }

    public void SupplierMenu(){
        System.out.println("Please select an option:");
        System.out.println("1. Add Supplier");
        System.out.println("2. Update Supplier Details");
        System.out.println("3. Delete Supplier");
        System.out.println("4. Exit");
    }

    public void supplierSwitch(){
        boolean checkSupplier = true;

        while (checkSupplier){
        SupplierMenu();
            user_input = scanner.nextLine();

            switch (user_input){
                case "1":
                    System.out.println("What's the Supplier called?");
                    String user_suplier_name = scanner.nextLine();
                    System.out.println("What's the supplier's contact number?");
                    String user_supplier_phone_number = scanner.nextLine();
                    System.out.println("What's the supplier's email?");
                    String user_supplier_email = scanner.nextLine();
                    //scanner.nextLine();

                    Supplier supplier = new Supplier(user_suplier_name, user_supplier_phone_number, user_supplier_email);
                    supplierManagement.addSupplierToList(supplier);
                    System.out.println("Supplier successfully added");
                    break;
                case "2":
                    System.out.println("What Supplier do you want to edit? Please insert their supplier id: ");
                    int user_supplier_id = scanner.nextInt();
                    scanner.nextLine();
                    Supplier changing_supplier = supplierManagement.getSupplierById(user_supplier_id);

                    System.out.println("Do you want to edit the supplier contact number? (Y or N): ");
                    String answer1 = scanner.nextLine().trim();
                    if (answer1.equalsIgnoreCase("Y")){
                        System.out.println("Enter the supplier's new phone number: ");
                        String new_number = scanner.nextLine();
                        changing_supplier.setSupplierPhoneNumber(new_number);
                        System.out.println("Contact number changed: " + new_number);
                    }
                    System.out.println("Do you want to edit the supplier's email? (Y or N): ");
                    String answer2 = scanner.nextLine().trim();
                    if (answer2.equalsIgnoreCase("Y")) {
                        System.out.println("Enter the supplier's new email: ");
                        String new_email = scanner.nextLine();
                        changing_supplier.setSupplierEmail(new_email);
                        System.out.println("Contact number changed: " + new_email);
                    }
                    break;
                case "3":
                    System.out.println("What's the supplier id of the supplier you want to delete? ");
                    int user_input_supplierid = scanner.nextInt();
                    scanner.nextLine();
                    Supplier removing_supplier = supplierManagement.getSupplierById(user_input_supplierid);
                    supplierManagement.deleteSupplierFromList(user_input_supplierid);
                    System.out.println("Successfully deleted supplier " + removing_supplier.getSupplierName());
                    break;
                case "4":
                    System.out.println("Exiting... returning to the main menu");
                    checkSupplier = false;
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
                    orderProcessing.getOrders();
                    break;
            //view products
                case "2":
                    System.out.println();

                    inventoryManagement.getProducts();
                    productsSwitch();
                    break;
            //place an order
                case "3":
                    products = new HashMap<>();
                    //getting customer id
                    System.out.println("Please insert your customer ID or make one up now:");
                    int user_id = scanner.nextInt();
                    
                    //getting auto generated order id
                    //int user_order_id = orderProcessing.getNextOrderID();
                    //allowing user to add as many products as they want
                    Boolean not_complete = true;
                    while (not_complete){
                        scanner.nextLine();
                        System.out.println("Please add products to your order by entering the product id. If your order is complete, please type 'y.'");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("y")){
                            not_complete = false;
                        } else {
                            int user_product_id = Integer.parseInt(input);
                            System.out.println("What quantity would you like to buy? ");
                            int user_quantity = scanner.nextInt();
                            Product product = inventoryManagement.getProductById(user_product_id);
                            products.put(product, user_quantity);
                        }
                    }
                        orderProcessing.placeOrder( user_id, products);
                    break;

            //view suppliers
                case "4":
                System.out.println();
                
                for (Supplier supplier : supplierManagement.supplierList) {
                    System.out.println("ID: " + supplier.getSupplierId() + " | Name: "  + supplier.getSupplierName() + " | Phone: " + supplier.getSupplierPhoneNumber() + " | Email: " + supplier.getSupplierEmail());
                }
                    supplierSwitch();
                    break;
                case "5":
                    System.out.println();
                    System.out.println("Total Inventory Value: £" + inventoryManagement.getTotalValue());
                    break;
                case "6":
                    FinancialService report = new FinancialService(orderProcessing.orders, inventoryManagement);
                    report.generateReport();;
                    break;
            //exit
                case "7":
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
