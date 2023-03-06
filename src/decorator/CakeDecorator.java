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
public class CakeDecorator extends ProductDecorator {
    private boolean isFrosted;

    public CakeDecorator(Product product, boolean isFrosted) {
        super(product);
        this.isFrosted = isFrosted;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t" + 
                isFrosted +
                "   | ";
    }
}