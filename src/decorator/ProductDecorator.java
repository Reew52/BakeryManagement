/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

import core.Product;

public abstract class ProductDecorator extends Product {
    protected Product product;

    public ProductDecorator(Product product) {
        super(product);
        this.product = product;
    }

    @Override
    public String getId() {
        return product.getId();
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public void setName(String name) {
        product.setName(name);
    }

    @Override
    public float getPrice() {
        return product.getPrice();
    }

    @Override
    public void setPrice(float price) {
        product.setPrice(price);
    }

    @Override
    public String toString() {
        return product.toString();
    }
}
