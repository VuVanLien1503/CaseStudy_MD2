package main;

import manager.ManagerCustomer;
import manager.ManagerShoe;
import manager.MyFileBinary;
import manager.MyRegex;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String patternChoice = "^[0-2]{1}$";
    static String path="src\\file\\customer";


    static MyRegex myRegex=new MyRegex();
    static ManagerShoe managerProduct=new ManagerShoe();
    static ManagerCustomer managerCustomer = new ManagerCustomer();
    static MyFileBinary myFileBinary=new MyFileBinary();

    public static void main(String[] args) {
       managerCustomer.setListCustomer((ArrayList<Customer>) myFileBinary.inputStream(path));
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
                if (myRegex.regex(choice, patternChoice)) {
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
                    myFileBinary.outPutStream(path,managerCustomer.listCustomer);
                    break;
            }
        } while (choiceInt != 0);
    }


}
