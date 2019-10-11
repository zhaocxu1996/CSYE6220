package edu.neu.csye.model;

public class Item {

    private int quantity;
    private String name;
//    private String type;

    public Item(){
        //empty
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getType() { return type; }
//
//    public void setType(String type) { this.type = type; }
}
