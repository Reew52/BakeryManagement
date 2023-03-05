/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import core.Bread;
import core.Cake;
import core.Coffee;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */

public class BakeryProductFactory<Product> implements ProductFactory<Product> {
    private ArrayList<Product> elements;

    
    public BakeryProductFactory (ArrayList<Product> elements){
        this.elements=elements;
    }

    @Override
    public ArrayList<Product> getAll(ArrayList<Product> elements) {
        return elements;
    }
    
    @Override
    public void createProduct(Product element) {
        elements.add(element);
    }

    @Override
    public void editProduct(Product element) {
        int index = elements.indexOf(element);
        if (index != -1) {
            elements.set(index, element);
        }
    }

    @Override
    public void deleteProduct(Product element) {
        elements.remove(element);
    }

    @Override
    public Product findByIdOrName(String idOrName) {
        for (Product element : elements) {
            if (element instanceof Bread) {
                Bread bread = (Bread) element;
                if (bread.getId().equals(idOrName) || bread.getName().equals(idOrName)) {
                    return element;
                }
            }
        }
        return null;
    }
    
    
}