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

public class BakeryProductFactory<T> implements ProductFactory<T> {
    private ArrayList<T> elements;

    
    public BakeryProductFactory (ArrayList<T> elements){
        this.elements=elements;
    }

    @Override
    public ArrayList<T> getAll(ArrayList<T> elements) {
        return elements;
    }
    
    @Override
    public void createProduct(T element) {
        elements.add(element);
    }

    @Override
    public void editProduct(T element) {
        int index = elements.indexOf(element);
        if (index != -1) {
            elements.set(index, element);
        }
    }

    @Override
    public void deleteProduct(T element) {
        elements.remove(element);
    }

    @Override
    public T findByIdOrName(String idOrName) {
        for (T element : elements) {
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