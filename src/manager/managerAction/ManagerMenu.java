package manager.managerAction;

import Interface.Product;
import manager.managerModel.AC.ManagerCustomer;
import manager.managerModel.AC.ManagerProduct;
import manager.managerModel.properties.ManagerRole;
import manager.managerModel.properties.ManagerTrademark;
import model.AC.Customer;
import model.ACproperties.Role;
import model.ACproperties.Trademark;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMenu {
    Scanner scanner = new Scanner(System.in);
    String patternChoice = "^[0-2]{1}$";
    MyRegex myRegex = new MyRegex();
    ManagerCustomer managerCustomer;
    ManagerTrademark managerTrademark;
    ManagerProduct managerProduct;
    ManagerRole managerRole=new ManagerRole();
    ManagerLogin login = new ManagerLogin(managerCustomer);
    MyFileBinary myFileBinary=new MyFileBinary();


    public ManagerMenu(ManagerCustomer managerCustomer, ManagerTrademark managerTrademark) {
        managerProduct= new ManagerProduct(managerTrademark);
        this.managerCustomer = managerCustomer;
        this.managerTrademark = managerTrademark;
        Role role=managerRole.getListRole().get(0);
        Customer customer=new Customer(0,"Lien",33,"NamDinh","0987654321","admin@gmail.com","123456",role);
        managerCustomer.getListCustomer().add(customer);

    }

    public ManagerCustomer getManagerCustomer() {
        return managerCustomer;
    }

    public void setManagerCustomer(ManagerCustomer managerCustomer) {
        this.managerCustomer = managerCustomer;
    }

    public ManagerTrademark getManagerShoe() {
        return managerTrademark;
    }

    public void setManagerShoe(ManagerTrademark managerShoe) {
        this.managerTrademark = managerShoe;
    }

    public void begin(Scanner scanner) {
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
                    String choiceName="";
                    Customer newCustomer = managerCustomer.create(scanner,choiceName);
                    managerCustomer.add(newCustomer);
                    break;
            }
        } while (choice != 0);
    }

    public void menuAdmin(Scanner scanner) {
        String pattern = "^[0-2]$";
        boolean check = false;
        String input;
        int choice = -1;
        do {
            do {
                System.out.println("MENU:");
                System.out.println("1. Action Customer");
                System.out.println("2. Action Product");
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
                    actionCustomer(scanner);
                    break;
                case 2:
                    System.out.println("ACTION-PRODUCT");
                    actionProduct(scanner);
                    break;
            }
        } while (choice != 0);

    }

    public void actionProduct(Scanner scanner) {
        String pattern = "^[0-5]$";
        boolean check = false;
        String input;
        int choice = -1;
        do {
            do {
                System.out.println("MENU:");
                System.out.println("1. Display Product");
                System.out.println("2. Create New Product");
                System.out.println("3. Update ProductById");
                System.out.println("4. Delete ProductById");
                System.out.println("5. Action TradeMark");
                System.out.println("----------------------");
                System.out.println("0. Back Login : ");
                System.out.println("---------------------");
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
                    System.out.println("ShowListProduct:");
                    managerProduct.display();
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("CREATE NEW PRODUCT:");
                    String name = managerProduct.choiceProduct(scanner);
                    Product product = managerProduct.create(scanner,name);
                    managerProduct.add(product);
                    break;
                case 3:
                    System.out.println("UPDATE PRODUCT BY ID");
                    managerProduct.findById(scanner, myRegex.getPatternNumber());
                    break;
                case 4:
                    System.out.println("DELETE PRODUCT BY ID");
                    break;
                case 5:
                    System.out.println("ACTION TRADEMARK");
                    actionTradeMark();
                    break;
            }
        } while (choice != 0);
    }
    public void actionTradeMark() {
        String pattern = "^[0-5]$";
        boolean check = false;
        String input;
        int choice = -1;
        do {
            do {
                System.out.println("MENU:");
                System.out.println("1. Display TradeMark");
                System.out.println("2. Create New TradeMark");
                System.out.println("3. Update TradeMark By Id");
                System.out.println("4. Delete TradeMark By Id");
                System.out.println("-----------------------");
                System.out.println("0.  Back Login : ");
                System.out.println("----------------------");
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
                    System.out.println("Show List TradeMark");
                    break;
                case 2:
                    System.out.println("Create New TradeMark");
                    break;
                case 3:
                    System.out.println("Update TradeMark By Id");
                    break;
                case 4:
                    System.out.println("Delete Trade Mark By Id");
                    break;
            }
        } while (choice != 0);
    }
    public void actionCustomer(Scanner scanner) {
        String pattern = "^[0-4]$";
        boolean check = false;
        String input;
        int choice = -1;
        do {
            do {
                System.out.println("MENU:");
                System.out.println("1. Display Customer");
                System.out.println("2. Delete Customer");
                System.out.println("3. Transaction history");
                System.out.println("4. Update Role Customer");
                System.out.println("--------------------");
                System.out.println("0. Back Login  : ");
                System.out.println("--------------------");
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
                    System.out.println("Show List Customer:");
                    managerCustomer.display();
                    break;
                case 2:
                    System.out.println("DELETE CUSTOMER:");
                    String patternNumber= myRegex.getPatternNumber();
                    managerCustomer.findById(scanner,patternNumber);
                    break;
                case 3:
                    System.out.println("TRANSACTION HISTORY");
                    break;
                case 4:
                    System.out.println("UPDATE ROLE CUSTOMER");
                    break;
            }
        } while (choice != 0);

    }

    public void menuCustomer() {

    }
}
