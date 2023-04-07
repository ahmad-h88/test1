package com.techelevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VendingMachine {

    private Map<Product, Integer> products;

    public VendingMachine() {
        this.products = readProductsFromFile();
    }

    public void displayItems(){
        products.forEach((product, qty) -> {
            String quantity = qty > 0 ? String.valueOf(qty) : "SOLD OUT";
            System.out.println(product+"|"+quantity);
        });
    }

    private Map<Product, Integer> readProductsFromFile(){
        Map<Product, Integer> productList = new TreeMap<>();
        final int productsAvailable = 5;
        try (BufferedReader reader = new BufferedReader(new FileReader("./vendingmachine.csv"))){
            String line;
            while (Objects.nonNull(line = reader.readLine())){
                String[] productDetails = line.split("\\|");
                Product product = createProductFromStringArray(productDetails);
                productList.put(product, productsAvailable);
            }
        }catch (IOException e){
            System.out.println("Could not found the file");
        }
        return productList;
    }

    private Product createProductFromStringArray(String[] productDetails){
        String slot = productDetails[0];
        String name = productDetails[1];
        double price = Double.parseDouble(productDetails[2]);
        String type = productDetails[3];
        return new Product(slot, name, price, type);
    }

    public Product findProductByName(String selectedProduct) {
        Product product = null;
        for (Product p : products.keySet()){
            if (p.getSlotLocation().equalsIgnoreCase(selectedProduct)){
                product = p;
                break;
            }
        }
        return product;
    }

    public void purchase(Product product) {
        int productsInStock = products.get(product);
        if (productsInStock > 0){
            products.put(product, products.get(product) -1);
            printSound(product);
            return;
        }
        throw new RuntimeException("Product SOLD OUT!!! Select another one");
    }

    private void printSound(Product product) {
        switch (product.getType()){
            case "Chip":
                System.out.println("Crunch Crunch, Yum!");
                break;
            case "Candy":
                System.out.println("Munch Munch, Yum!");
                break;
            case "Gum":
                System.out.println("Chew Chew, Yum!");
                break;
            case "Drink":
                System.out.println("Glug Glug, Yum!");
        }
    }
}
