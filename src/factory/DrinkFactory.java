/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package factory;

import core.Drink;

/**
 *
 * @author Dell
 */
public interface DrinkFactory {
    Drink createDrink(String type, int id, String name, float price, float volume);
}
