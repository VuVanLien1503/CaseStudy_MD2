package model.AC;


import Interface.Product;
import model.ACproperties.Trademark;

public class Shoe extends Product {
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public void setSize(int size) {
        super.setSize(size);
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Override
    public Trademark getTrademark() {
        return super.getTrademark();
    }

    @Override
    public void setTrademark(Trademark trademark) {
        super.setTrademark(trademark);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public String getDescribe() {
        return super.getDescribe();
    }

    @Override
    public void setDescribe(String describe) {
        super.setDescribe(describe);
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public void setCategory(String category) {
        super.setCategory(category);
    }

    public Shoe() {
    }

    public Shoe(int id, String name, String type, int size, int quantity, String category, Trademark trademark, double price, String describe) {
        super(id, name, type, size, quantity, category, trademark, price, describe);
    }

    @Override
    public void display() {
        System.out.printf("%-5s%-15s%-20s%-10s%-10s%-15s%-20s%-20s%-25s%s",
                "| "+this.getId(), "| "+this.getName(), "| "+this.getType(), "| "+this.getSize(),
                "| "+this.getPrice(),"| "+ this.getQuantity(),"| "+ this.getCategory(),"| "+ this.getDescribe(), "| "+this.getTrademark()," |" + "\n");
    }
}
