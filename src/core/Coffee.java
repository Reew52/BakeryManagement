/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author Dell
 */

public class Coffee extends Product implements IDrink {
    private String roastType;
    private float volume;

    public Coffee(String id, String name, float price, String roastType,float volume) {
        super(id, name, price);
        this.roastType = roastType;
        this.volume = volume;
    }

    public String getRoastType() {
        return roastType;
    }

    public void setRoastType(String roastType) {
        this.roastType = roastType;
    }

    @Override
    public float getVolume() {
        return volume;
    }

    @Override
    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("%-12s| %-7s |",
                        roastType, volume);
    }  
}
