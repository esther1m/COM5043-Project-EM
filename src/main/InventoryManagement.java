package main;
//class that handles the inventory management
import java.util.HashMap;

public class InventoryManagement{
    private HashMap <Integer, Product> productsInventory;

    private InventoryManagement(){
        productsInventory = new HashMap<>();
    }

    //adding products to the hashmap
    private void addProduct(Product product){
        int id = product.getProductId();
        productsInventory.put(id,product);
    }

    //removing products from the hashmap
    private void removeProduct(Product product){
        int id =product.getProductId();
        productsInventory.remove(id);
    }

    //allowing to search/return/get product from inventory by id:
    private Product getProductbyId(int id){
        return productsInventory.get(id);
    }
    
}

