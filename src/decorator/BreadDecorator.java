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
public class BreadDecorator extends ProductDecorator {
    private String shape;

    public BreadDecorator(Product product, String shape) {
        super(product);
        this.shape = shape;
    }

    @Override
    public String toString() {
        return super.toString() + 
                "\t" + 
                "  " + shape + 
                " | ";
    }
}
