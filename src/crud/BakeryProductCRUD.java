/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import core.Bread;
import core.Cake;
import core.Coffee;
import java.util.ArrayList;

public class BakeryProductCRUD<Product> implements ProductCRUD<Product> {
    private ArrayList<Product> elements;

    
    public BakeryProductCRUD (ArrayList<Product> elements){
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
                if (bread.getId().equalsIgnoreCase(idOrName) || bread.getName().equalsIgnoreCase(idOrName)) {
                    return element;
                }
            }else if (element instanceof Cake) {
                Cake cake = (Cake) element;
                if (cake.getId().equalsIgnoreCase(idOrName) || cake.getName().equalsIgnoreCase(idOrName)) {
                    return element;
                }
            } else if (element instanceof Coffee) {
                Coffee coffee = (Coffee) element;
                if (coffee.getId().equalsIgnoreCase(idOrName) || coffee.getName().equalsIgnoreCase(idOrName)) {
                    return element;
                }
            }
        }
        return null;
    }
    
    
}