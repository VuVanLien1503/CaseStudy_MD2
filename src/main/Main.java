package main;

import manager.managerModel.ManagerCategory;
import manager.managerModel.ManagerCustomer;
import manager.managerModel.ManagerShoe;
import manager.managerModel.ManagerTrademark;
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
