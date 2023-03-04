/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import core.Coffee;
import core.Drink;

/**
 *
 * @author Dell
 */
public class CoffeeFactory implements DrinkFactory {
    public Drink createDrink(String type, int id, String name, float price, float volume) {
        if (type.equalsIgnoreCase("Coffee")) {
            return new Coffee(id, name, price, volume);
        } else {
            return null;
        }
    }
}