/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package crud;

import java.util.ArrayList;

public interface IProductCRUD<Product> {
    void createProduct(Product element);
    void editProduct(Product element);
    void deleteProduct(Product element);
    Product findByIdOrName(String idOrName);
}

