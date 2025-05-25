package main;
//class that handles the inventory management
import java.util.HashMap;

public class InventoryManagement{
    private HashMap <Integer, Product> productsInventory;

    private InventoryManagement(){
        productsInventory = new HashMap<>();
    }

    //adding products to the hashmap
    private void addProducts(Product product){
        int id = product.getProductId();
        productsInventory.put(id,product);
    }

    //removing products from the hashmap
    private void removeProducts(Product product){
        int id =product.getProductId();
        productsInventory.remove(id);
    }
    
}

