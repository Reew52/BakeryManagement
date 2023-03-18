/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

import core.Product;

public class CoffeeDecorator extends ProductDecorator {
    private String flavor;

    public CoffeeDecorator(Product product, String flavor) {
        super(product);
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return super.toString() + 
                String.format("%-10s|", flavor);
    }
}
