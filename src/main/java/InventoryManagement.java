
//class that handles the inventory management
import java.util.HashMap;

public class InventoryManagement{
    public HashMap <Integer, Product> productsInventory;

    public InventoryManagement(){
        productsInventory = new HashMap<>();
    }

    //adding products to the hashmap, only if not already existing
    public boolean addProduct(Product product){
        int id = product.getProductId();
        if (productsInventory.containsKey(id)){
            return false;
        }
        productsInventory.put(id,product);
        return true;
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

    //allowing to search/return/get product from inventory by id:
    public Product getProductById(int id){
        return productsInventory.get(id);
    }

    public void getProducts(){
        for (int productId : productsInventory.keySet()) {
            Product product = getProductById(productId);
            System.out.println("ID: " + productId + " | Name: "  + product.getProductName() + " | Price £" + product.getProductPrice() + " | Quantity: " + product.getProductQuantity());
        }
    }
    
    public double getTotalValue() {
        double total = 0.0;
        for (Product product : productsInventory.values()) {
            total = total + (product.getProductPrice() * product.getProductQuantity());
        }
        return total;
    }
    
}

