package model;

import java.io.Serializable;

public class Option implements Serializable {
    private double price;
    private String name;

    public Option(String name,double price) {
        this.price = price;
        this.name = name;
    }

    public Option() {
        this.price = 0;
        this.name = "";
    }

    protected void setName(String name) {
        this.name = name;
    }//contains basic getter and setter options

    protected void setPrice(double price) {
        this.price = price;
    }

    protected String getName() {
        return name;
    }

    protected double getPrice() {
        return price;
    }

    public String toString() {//wouldn't let me make this protected oddly enough
        StringBuffer s = new StringBuffer();
        s.append("{");
        s.append(name);
        s.append(",");
        s.append(price);
        s.append("}");
        return s.toString();
    }
}