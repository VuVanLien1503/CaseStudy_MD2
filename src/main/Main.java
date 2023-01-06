package main;

import Interface.Product;
import manager.managerModel.AC.ManagerCustomer;
import manager.managerModel.AC.ManagerProduct;
import manager.managerModel.properties.ManagerTrademark;
import manager.managerAction.ManagerMenu;
import model.ACproperties.Trademark;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ManagerTrademark managerTrademark = new ManagerTrademark();
    static ManagerCustomer managerCustomer = new ManagerCustomer(managerTrademark);
    static ManagerMenu managerMenu = new ManagerMenu(managerCustomer, managerTrademark);

    static ManagerProduct managerProduct = new ManagerProduct(managerTrademark);

    public static void main(String[] args) {
        managerMenu.begin(scanner);

//        managerMenu.actionProduct(scanner);

    }

}
