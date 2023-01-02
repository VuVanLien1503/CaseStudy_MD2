package manager;

import Interface.ICrud;
import manager.managerAction.MyRegex;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerCustomer implements ICrud<Customer> {
    MyRegex myRegex=new MyRegex();
    Scanner scanner = new Scanner(System.in);
    private int autoId;
    ManagerShoe managerShoe;
    public ArrayList<Customer> listCustomer;

    public ManagerCustomer(ManagerShoe managerShoe) {
        listCustomer = new ArrayList<>();
        if (listCustomer.size() > 0) {
            autoId = (listCustomer.get(listCustomer.size() - 1).getId()) + 1;
        } else {
            autoId = 1;
        }
        this.managerShoe=managerShoe;

    }

    public ArrayList<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(ArrayList<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }
    public void title() {
        System.out.printf("%-5s%-10s%-10s%-10s%-10s%-10s%-10s%-15s%s",
                "ID", "NAME", "AGE", "ADDRESS", "PHONE", "EMAIL", "PASSWORD", "CART", "HISTORY\n");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    @Override
    public Customer findById(Scanner scanner) {
        Customer customer = null;
        int id;
        boolean checkRegex=false;
        boolean checkId=false;
        do {
            System.out.println("Enter Id : ");
             id=Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(id), myRegex.getPatternNumber())){
                checkRegex=true;
            }else {
                System.err.println("Malformed ID");
                System.out.println("\nId Contains Only Numbers\n");
            }
        }while (!checkRegex);
        for (Customer c :
                listCustomer) {
            if (c.getId()==id){
                customer=c;
                checkId=true;
                break;
            }
        }
        return customer;
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
