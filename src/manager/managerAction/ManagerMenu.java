package manager.managerAction;

import manager.managerModel.ManagerCustomer;
import manager.managerModel.ManagerShoe;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMenu {
     Scanner scanner = new Scanner(System.in);
     String patternChoice = "^[0-2]{1}$";
     String pathCustomer = "src\\file\\customer";
     String pathShoe = "src\\file\\shoe";
     String pathCategory = "src\\file\\category";
     String pathTradeMark = "src\\file\\trademark";
    MyRegex myRegex=new MyRegex();
    MyFileBinary myFileBinary = new MyFileBinary();
    ManagerCustomer managerCustomer;
    ManagerShoe managerShoe;
    ManagerLogin login=new ManagerLogin(managerCustomer);


    public ManagerMenu(ManagerCustomer managerCustomer, ManagerShoe managerShoe) {
        managerCustomer.setListCustomer((ArrayList<Customer>) myFileBinary.inputStream(pathCustomer));
        this.managerCustomer = managerCustomer;
        this.managerShoe = managerShoe;
    }

    public ManagerCustomer getManagerCustomer() {
        return managerCustomer;
    }

    public void setManagerCustomer(ManagerCustomer managerCustomer) {
        this.managerCustomer = managerCustomer;
    }

    public ManagerShoe getManagerShoe() {
        return managerShoe;
    }

    public void setManagerShoe(ManagerShoe managerShoe) {
        this.managerShoe = managerShoe;
    }
    public  void begin(Scanner scanner) {
        boolean check = false;
        int choice = -1;
        String input;
        do {
            do {
                System.out.println("MENU:");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("----------------");
                System.out.println("0. Exit :");
                System.out.println("----------------");
                System.out.println("Enter Choice Menu From 0->2 ");
                System.out.print("Enter Choice: ");
                input = scanner.nextLine();
                if (myRegex.regex(input, patternChoice)) {
                    choice = Integer.parseInt(input);
                    check = true;
                } else {
                    System.err.println("                         Incorrect Choice, Please Re-Enter");
                    System.out.println("\n");
                }
            } while (!check);

            switch (choice) {
                case 1:
                    Customer customer;
                    customer = login.checkLogin(managerCustomer.listCustomer, scanner);
                    if (customer != null) {
                        if (login.isAdmin(customer)) {
                            menuAdmin(scanner);
                        } else {
                            menuCustomer();
                        }
                    }
                    break;
                case 2:
                    Customer newCustomer = managerCustomer.create(scanner);
                    managerCustomer.add(newCustomer);
                    myFileBinary.outPutStream(pathCustomer, managerCustomer.listCustomer);
                    break;
            }
        } while (choice != 0);
    }

    public  void menuAdmin(Scanner scanner) {
        String pattern = "^[0-2]$";
        boolean check = false;
        String input;
        int choice = -1;
        do {
            do {
                System.out.println("MENU:");
                System.out.println("1. Action Customer");
                System.out.println("2. Action Shoe");
                System.out.println("------------------");
                System.out.println("0. Back Login :");
                System.out.println("------------------");
                input = scanner.nextLine();
                if (myRegex.regex(input, pattern)) {
                    choice = Integer.parseInt(input);
                    check = true;
                } else {
                    System.err.println("                          incorrect choice, please re-enter");
                    System.out.println("\n");
                }
            } while (!check);


            switch (choice) {
                case 1:
                    System.out.println("ACTION-CUSTOMER");
                    break;
                case 2:
                    System.out.println("ACTION-SHOE");
                    break;
            }
        } while (choice != 0);

    }

    public static void menuCustomer() {

    }
}
