package model.ACproperties.ACSon;

import model.ACproperties.Trademark;

import java.io.Serializable;

public class TradeMarkHandBag extends Trademark implements Serializable {
    public TradeMarkHandBag() {
    }

    public TradeMarkHandBag(int id, String name) {
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

    @Override
    public void display() {
        super.display();
    }
}
