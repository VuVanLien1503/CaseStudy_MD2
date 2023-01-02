package main;

import manager.*;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String patternChoice = "^[0-2]{1}$";
    static String pathCustomer ="src\\file\\customer";
    static String pathShoe ="src\\file\\shoe";
    static String pathCategory ="src\\file\\category";
    static String pathTradeMark ="src\\file\\trademark";


    static MyRegex myRegex=new MyRegex();
    static ManagerTrademark managerTrademark=new ManagerTrademark();
    static ManagerCategory managerCategory=new ManagerCategory();
    static ManagerShoe managerShoe=new ManagerShoe(managerCategory,managerTrademark);
    static ManagerCustomer managerCustomer = new ManagerCustomer(managerShoe);
    static ManagerLogin login=new ManagerLogin(managerCustomer);


    static MyFileBinary myFileBinary=new MyFileBinary();

    public static void main(String[] args) {
       managerCustomer.setListCustomer((ArrayList<Customer>) myFileBinary.inputStream(pathCustomer));
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
            System.out.println("0. Exit :");
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
                    login.checkLogin(managerCustomer.listCustomer,scanner);
                    break;
                case 2:
                    Customer customer=managerCustomer.create(scanner);
                    managerCustomer.add(customer);
                    myFileBinary.outPutStream(pathCustomer,managerCustomer.listCustomer);
                    break;
            }
        } while (choiceInt != 0);
    }


}
