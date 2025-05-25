
//class that handles the inventory management
import java.util.HashMap;

public class InventoryManagement{
    private HashMap <Integer, Product> productsInventory;

    public InventoryManagement(){
        productsInventory = new HashMap<>();
    }

    //adding products to the hashmap
    public void addProduct(Product product){
        int id = product.getProductId();
        productsInventory.put(id,product);
    }

    //removing products from the hashmap
    private void removeProduct(Product product){
        int id =product.getProductId();
        productsInventory.remove(id);
    }

    //allowing to search/return/get product from inventory by id:
    public Product getProductById(int id){
        return productsInventory.get(id);
    }
    
}

