package manager.managerAction;

import manager.ManagerCustomer;
import model.Customer;

import java.util.List;
import java.util.Scanner;

public class ManagerLogin {
    private String admin = "admin@gmail.com";
    MyRegex myRegex = new MyRegex();
    ManagerCustomer managerCustomer;

    public ManagerCustomer getManagerCustomer() {
        return managerCustomer;
    }

    public void setManagerCustomer(ManagerCustomer managerCustomer) {
        this.managerCustomer = managerCustomer;
    }

    public ManagerLogin(ManagerCustomer managerCustomer) {
        this.managerCustomer = managerCustomer;
    }

    public String[] login(Scanner scanner) {
        System.out.println("\n                              WElCOME TO LOGIN : \n");
        boolean check = false;
        String inputEmail;
        String inputPassWord;
        System.out.print("Enter Email : ");
        do {
            inputEmail = scanner.nextLine();
            if (myRegex.regex(inputEmail, myRegex.getPatternEmail())) {
                check = true;
            } else {
                System.err.print("Email format is incorrect\nPlease re-enter : ");
            }
        } while (!check);
        System.out.print("Enter PassWord : ");
        inputPassWord = scanner.nextLine();
        return new String[]{inputEmail, inputPassWord};
    }

    public boolean isAdmin(Customer customer) {
        boolean checkAdmin = false;
        try {
            if (customer.getEmail().toLowerCase().equals(admin)) {
                checkAdmin = true;
            }
        } catch (NullPointerException e) {
            checkAdmin = false;
        }

        return checkAdmin;
    }

    public Customer checkLogin(List<Customer> listCustomer, Scanner scanner) {
        String[] login = login(scanner);
        Customer customer = null;
        String outPut;
        boolean check = false;
        for (Customer c : listCustomer) {
            if (c.getEmail().equals(login[0])) {
                if (c.getPassWord().equals(login[1])) {
                    outPut = "                    Welcome Back " + c.getName() + " ....!";
                    System.out.println(outPut);
                    customer = c;
                    check = true;
                    break;
                } else {
                    System.err.println("wrong password\n");
                    System.out.println("\nyou have 3 times enter");
                    System.out.println("------------------------");
                    int count = 1;
                    while (count < 4) {
                        System.out.println("Incorrect password : ");
                        System.out.print("Enter password " + count + " times : ");
                        login[1] = scanner.nextLine();
                        System.out.println("------------------------");
                        if (c.getPassWord().equals(login[1])) {
                            outPut = "                    Welcome Back " + c.getName() + " ....!";
                            System.out.println(outPut);
                            check = true;
                            return c;
                        } else {
                            count++;
                        }
                    }
                    System.out.println("Too many times invite you back to login");
                    return checkLogin(listCustomer, scanner);
                }
            } else {
                check = false;
            }
        }
        if (!check) {
            System.err.println("\n                                  Login Unsuccessful\n");
            System.out.println("\n                                E-mail does not exist yet");
            System.out.println("                                     PLEASE SIGN UP ");
            System.out.println("                              -------------------------------");
        }
        return customer;
    }

}
