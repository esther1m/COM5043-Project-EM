
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
    public void removeProduct(Product product){
        int id = product.getProductId();
        productsInventory.remove(id);
    }

    //allowing to search/return/get product from inventory by id:
    public Product getProductById(int id){
        return productsInventory.get(id);
    }

    public HashMap <Integer, Product> getProducts(){
        return productsInventory;
    }
    
}

