package main;

import manager.ManagerCustomer;
import model.Customer;

import java.util.Scanner;

public class Main {
    static ManagerCustomer managerCustomer = new ManagerCustomer();
    static Scanner scanner = new Scanner(System.in);
    static String patternChoice = "^[0-2]{1}$";

    public static void main(String[] args) {
        registerLogin(scanner);
    }

    public static void registerLogin(Scanner scanner) {
        boolean check = false;
        int choiceInt = -1;
        String choice;
        do {
            System.out.println("\n1. Login");
            System.out.println("\n2. Register");
            System.out.println("\n----------------");
            System.out.println("\n0. Exit :\n");
            System.out.println("\nEnter Choice : (0->2)");
            do {
                choice = scanner.nextLine();
                if (managerCustomer.regex(choice, patternChoice)) {
                    choiceInt = Integer.parseInt(choice);
                    check = true;
                } else {
                    System.out.println("Enter choice (0->2)");
                }
            } while (!check);

            switch (choiceInt) {
                case 1:
                    managerCustomer.checkLogin(managerCustomer.listCustomer,scanner);
                    break;
                case 2:
                    Customer customer=managerCustomer.create(scanner);
                    managerCustomer.add(customer);
                    break;
            }
        } while (choiceInt != 0);
    }


}
