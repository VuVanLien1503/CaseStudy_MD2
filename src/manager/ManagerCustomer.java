package manager;

import Interface.ICrud;
import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagerCustomer implements ICrud<Customer> {
    MyRegex myRegex=new MyRegex();
    Scanner scanner = new Scanner(System.in);
    private int autoId;
    public ArrayList<Customer> listCustomer;

    public ManagerCustomer() {
        listCustomer = new ArrayList<>();
        if (listCustomer.size() > 0) {
            autoId = (listCustomer.get(listCustomer.size() - 1).getId()) + 1;
        } else {
            autoId = 1;
        }

    }

    public ArrayList<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(ArrayList<Customer> listCustomer) {
        this.listCustomer = listCustomer;
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

    public Customer checkLogin(List<Customer> listCustomer, Scanner scanner) {
        String[] login = login(scanner);
        Customer customer = null;
        String outPut;
        boolean check = false;
        for (Customer c : listCustomer) {
            if (c.getEmail().equals(login[0])) {
                if (c.getPassWord().equals(login[1])) {
                    outPut = "Logged in successfully...!\nWelcome Back " + c.getName() + " ....!";
                    System.out.println(outPut);
                    customer = c;
                    check = true;
                    break;
                } else {
                    System.err.println("\nwrong password\n");
                    System.out.println("you have 3 times enter");
                    System.out.println("------------------------");
                    int count = 1;
                    while (count < 4) {
                        System.out.println("Incorrect password : ");
                        System.out.print("Enter password " + count + " times : ");
                        login[1] = scanner.nextLine();
                        System.out.println("------------------------");
                        if (c.getPassWord().equals(login[1])) {
                            outPut = "Logged in successfully...!\nWelcome Back " + c.getName() + " ....!";
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
            System.out.println("\n                                E-mail does not exist yet\n");
            System.out.println("                                      PLEASE SIGN UP ");
        }
        return customer;
    }

    public void title() {
        System.out.printf("%-5s%-10s%-10s%-10s%-10s%-10s%-10s%-15s%s",
                "ID", "NAME", "AGE", "ADDRESS", "PHONE", "EMAIL", "PASSWORD", "CART", "HISTORY\n");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    @Override
    public void display() {
        title();
        for (Customer c :
                listCustomer) {
            c.display();
        }
    }

    @Override
    public Customer create(Scanner scanner) {
        boolean check = false;
        String name;
        String email;
        String passWord;
        System.out.println("\nCreate New Customer...!\n");
        System.out.println("name : (3-15) characters without special characters but accept \"-\";\"_\"");
        do {
            System.out.print("Enter Name : ");
            name = scanner.nextLine();
            if (myRegex.regex(name,myRegex.getPatternName())) {
                check = true;
            } else {
                System.err.println("Malformed Name");
                System.out.println("\nname : (3-15) characters without special characters but accept \"-\";\"_\"");
                check = false;
            }
        } while (!check);
        check = true;
        System.out.print("Enter Email : ");
        do {
            email = scanner.nextLine();
            if (myRegex.regex(email, myRegex.getPatternEmail())) {
                check = true;
            } else {
                System.err.println("Malformed Email");
                System.out.print("\nEnter Email : ");
                check = false;
            }
        } while (!check);
        check = true;
        do {
            System.out.print("Enter PassWord : ");
            passWord = scanner.nextLine();
            if (myRegex.regex(passWord, myRegex.getPatternPassWord())) {
                check = true;
            } else {
                System.err.println("Malformed PassWord");
                System.out.println("\nPassWord (3-15) characters");
                check = false;
            }
        } while (!check);
        Customer customer;
        customer = new Customer(autoId, name, email, passWord);
        System.err.println("                                  Create Successful...! ");
        return customer;
    }

    @Override
    public void add(Customer customer) {
        listCustomer.add(customer);
    }
}
