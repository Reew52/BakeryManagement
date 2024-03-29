/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author Dell
 */
public abstract class Product {
    private String id;
    private String name;
    private float price;

    public Product(String id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public Product(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("|%-7s| %-25s | %-6s |", 
        id, name, price);
    }
    
}
