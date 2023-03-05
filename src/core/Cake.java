/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author Dell
 */
public class Cake extends Product {
    private String flavor;
    private String size;

    public Cake(String id, String name,String flavor, String size, float price) {
        super(id, name, price);
        this.flavor = flavor;
        this.size = size;
    }
    
    public String getFlavor() {
        return flavor;
    }
    
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cake{" + "flavor=" + flavor + ", size=" + size + '}';
    }
}

