
//class that handles the inventory management
import java.util.HashMap;

public class InventoryService{
    public HashMap <Integer, Product> productsInventory;
    private SupplierService supplierService;

    public InventoryService(SupplierService supplierService){
        productsInventory = new HashMap<>();
        this.supplierService = supplierService;
    }

    //adding products to the hashmap, only if not already existing
    public boolean addProduct(Product product){
        if (product == null) {
            return false;
        }
        int id = product.getProductId();
       // int quantity = product.getProductQuantity();
        if (productsInventory.containsKey(id)){
            return false;
        } else {
            productsInventory.put(id, product);
            return true;
        }
    }

    //removing products from the hashmap
    public boolean removeProduct(int id){
        if (productsInventory.containsKey(id)){
            productsInventory.remove(id);
            return true;
        } else {
            System.out.println("Product not found.");
            return false;
        }
        
    }
    //revisit logic
    //allowing to search/return/get product from inventory by id:
    public Product getProductById(int id){
        return productsInventory.get(id);
    }

    public void getProducts(){
        if (productsInventory.size() == 0 ){
            System.out.println("No products in inventory. Please create products to add them to inventory.");   
        }
        for (int productId : productsInventory.keySet()) {
            Product product = getProductById(productId);
            System.out.println("ID: " + productId + " | Name: "  + product.getProductName() + " | Price £" + product.getProductPrice() + " | Quantity: " + product.getProductQuantity());
            
        }
        //System.out.println("All products in the inventory have been listed");
    }
    
    public double getTotalValue() {
        double total = 0.0;
        for (Product product : productsInventory.values()) {
            total = total + (product.getProductPrice() * product.getProductQuantity());
        }
        return total;
    }

    public boolean reorderStock(int productId){
        Product product1 = getProductById(productId);
        if (product1 == null){
            System.out.println("Product not found for reorder.");
            return false;
        }
        if (this.supplierService == null){
            System.out.println("Supplier service not configured.");
            return false;
        }
        int reorderThreshold = product1.getReorderThreshold();
        int reorderAmount = product1.getReorderQuantity();
       
        if (product1.getProductQuantity() <= reorderThreshold){
            Supplier supplier = this.supplierService.getSupplierById(product1.getPreferredSupplierId());
            if (supplier != null){
                supplier.orderStock(product1, reorderAmount);
                System.out.println("Reorder of " + product1.getProductName() + "ordered.");
            } else {
                return false;
            }
        }
        return true;
    }
    
}

