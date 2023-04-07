package com.techelevator;

public class Product implements Comparable<Product>{
    private String slotLocation;
    private String productName;
    private double price;
    private String type;

    public Product(String slotLocation, String productName, double price, String type) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
        this.type = type;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.join("|", slotLocation,productName,String.format("%.2f", price),type);
    }

    @Override
    public int compareTo(Product o) {
        Product product = (Product) o;
        return this.getSlotLocation().compareTo(product.getSlotLocation());
    }
}
