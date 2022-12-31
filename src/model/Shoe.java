package model;

public class Shoe {
    private int id;
    private String name;
    private String type;
    private int size;
    private int quantity;
    private Category category;
    private Trademark trademark;
    private double price;
    private String describe;

    public Shoe() {
    }

    public Shoe(int id, String name, String type, int size, int quantity, Category category, Trademark trademark, double price, String describe) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "Shoe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                ", category=" + category +
                ", trademark=" + trademark +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }
    public void display(){
        System.out.printf("%-5s%-10s%-10s%-10s%-10s%-10s%-10s%-15s%s",
                this.id,this.name,this.type,this.size,this.quantity,this.category,this.trademark,this.price,this.describe+"\n");

    }

}
