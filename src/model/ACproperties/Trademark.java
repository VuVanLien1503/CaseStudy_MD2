package model.ACproperties;

import java.io.Serializable;

public class Trademark implements Serializable {
    private int id;
    private String name;

    public Trademark() {
    }

    public Trademark(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name ;
    }

    public void display(){
        System.out.printf("%-10s%s",
                this.id,this.name+"\n");

    }
}
