package main;

import manager.ManagerCategory;
import manager.ManagerCustomer;
import manager.ManagerShoe;
import manager.ManagerTrademark;
import manager.managerAction.ManagerMenu;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ManagerCategory managerCategory = new ManagerCategory();
    static ManagerTrademark managerTrademark = new ManagerTrademark();
    static ManagerShoe managerShoe = new ManagerShoe(managerCategory, managerTrademark);
    static ManagerCustomer managerCustomer = new ManagerCustomer(managerShoe);
    static ManagerMenu menu = new ManagerMenu(managerCustomer, managerShoe);

    public static void main(String[] args) {
        menu.begin(scanner);

    }

}
