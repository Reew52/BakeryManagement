/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

import core.Product;

/**
 *
 * @author Dell
 */
public class CoffeeDecorator extends ProductDecorator {
    private String flavor;

    public CoffeeDecorator(Product product, String flavor) {
        super(product);
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return super.toString() + 
                "\t" + 
                " " + flavor + 
                "    |  ";
    }
}
