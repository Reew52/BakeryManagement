/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package factory;

import java.util.ArrayList;

public interface ProductFactory<T> {
    ArrayList<T> getAll(ArrayList<T> elements);
    void createProduct(T element);
    void editProduct(T element);
    void deleteProduct(T element);
    T findByIdOrName(String idOrName);
}

