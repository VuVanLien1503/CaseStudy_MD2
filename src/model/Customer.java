package model;

import manager.ManagerShoe;

public class Customer {
    private  int id;
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String passWord;
    private ManagerShoe cart;
    private ManagerShoe history;

    public Customer() {
    }

    public Customer(int id,String name, String email, String passWord) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
        this.age=18;
        this.address="Hà Nội";
        this.cart=null;
        this.history=null;
    }

    public Customer(int id, String name, int age, String address, String phone, String email, String passWord, ManagerShoe cart, ManagerShoe history) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.passWord = passWord;
        this.cart = cart;
        this.history = history;
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

    public ManagerShoe getCart() {
        return cart;
    }

    public void setCart(ManagerShoe cart) {
        this.cart = cart;
    }

    public ManagerShoe getHistory() {
        return history;
    }

    public void setHistory(ManagerShoe history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", cart=" + cart +
                ", history=" + history +
                '}';
    }
    public void display(){
        System.out.printf("%-5s%-10s%-10s%-10s%-10s%-10s%-10s%-15s%s",
                this.id,this.name,this.age,this.address,this.phone,this.email,this.passWord,this.cart,this.history+"\n");

    }
}
