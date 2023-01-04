package Interface;

import model.ACproperties.Trademark;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private int id;
    private String name;
    private String type;
    private int size;
    private int quantity;
    private String category;
    private Trademark trademark;
    private double price;
    private String describe;

    public Product(int id, String name, String type, int size, int quantity, String category, Trademark trademark, double price, String describe) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.category = category;
        this.trademark = trademark;
        this.price = price;
        this.describe = describe;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Trademark getTrademark() {
        return trademark;
    }

    public void setTrademark(Trademark trademark) {
        this.trademark = trademark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

        public abstract void display();
}
