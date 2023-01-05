package model.ACproperties.ACSon;

import model.ACproperties.Trademark;

import java.io.Serializable;

public class TradeMarkShoe extends Trademark implements Serializable {
    public TradeMarkShoe() {
        super();
    }

    public TradeMarkShoe(int id, String name) {
        super(id, name);
    }

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
    public void title() {
        System.out.printf("%-10s%s",
                "ID", "NAME\n");
        System.out.println("-----------------");
    }

    @Override
    public void display() {
        super.display();
    }
}
