/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

public class Bread extends Product {
    private String type;
    private float weight;

    public Bread(String id, String name,String type, float weight, float price) {
        super(id, name, price);
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Bread{" + "type=" + type + ", weight=" + weight + '}';
    }
    
    
}