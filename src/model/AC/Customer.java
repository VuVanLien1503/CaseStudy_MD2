package model.AC;


import model.ACproperties.Role;

import java.io.Serializable;

public class Customer implements Serializable {
    private  int id;
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String passWord;
    private Role role;


    public Customer() {
    }

    public Customer(int id, String name, int age, String address, String phone, String email, String passWord) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.passWord = passWord;
        this.role=new Role(1,"USER");
    }

    public Customer(int id, String name, String email, String passWord) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
        this.role=new Role(1,"USER");
    }

    public Customer(int id, String name, int age, String address, String phone, String email, String passWord, Role role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void display(){
        System.out.printf("%-5s%-10s%-10s%-10s%-15s%-25s%s",
                this.id,this.name,this.age,this.address,this.phone,this.email,this.passWord+"\n");

    }
}
