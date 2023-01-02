package manager.managerModel;

import Interface.ICrud;
import manager.managerAction.MyRegex;
import model.Category;
import model.Shoe;
import model.Trademark;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerShoe implements ICrud<Shoe> {
    ManagerTrademark managerTrademark;
    ManagerCategory managerCategory;
    MyRegex myRegex = new MyRegex();
    private int autoId;
    private ArrayList<Shoe> listShoe;

    public ManagerShoe(ManagerCategory managerCategory, ManagerTrademark managerTrademark) {
        listShoe = new ArrayList<>();
        this.managerCategory = managerCategory;
        this.managerTrademark = managerTrademark;
        if (listShoe.size() > 0) {
            autoId = (listShoe.get(listShoe.size() - 1).getId()) + 1;
        } else {
            autoId = 1;
        }
    }

    public ArrayList<Shoe> getListShoe() {
        return listShoe;
    }

    public void setListShoe(ArrayList<Shoe> listShoe) {
        this.listShoe = listShoe;
    }

    public void title() {
        System.out.printf("%-5s%-10s%-10s%-10s%-10s%-10s%-10s%-15s%s",
                "ID", "NAME", "TYPE", "SIZE", "QUANTITY", "CATEGORY", "TRADEMARK", "PRICE", "DESCRIBE\n");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    @Override
    public Shoe findById(Scanner scanner) {
        Shoe shoe = null;
        int id;
        boolean checkRegex = false;
        do {
            System.out.println("Enter Id : ");
            id = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(id), myRegex.getPatternNumber())) {
                checkRegex = true;
            } else {
                System.err.println("Malformed ID");
                System.out.println("\nId Contains Only Numbers\n");
            }
        } while (!checkRegex);
        for (Shoe s :
                listShoe) {
            if (s.getId() == id) {
                shoe = s;
                break;
            }
        }
        return shoe;
    }

    @Override
    public void display() {
        title();
        for (Shoe shoe : listShoe) {
            shoe.display();
        }
    }

    public Category choiceCategory(Scanner scanner) {
        Category category = null;
        System.out.println("                     List Category : ");
        managerCategory.display();
        System.out.println("--------------------------------");
        System.out.println("0.    Add  New  Category:");
        System.out.println("--------------------------------");
        System.out.println("Enter ID Choice Category");
        category = managerCategory.findById(scanner);
        if (category != null) {
            return category;
        } else {
            category = managerCategory.create(scanner);
            managerCategory.add(category);
            return category;
        }
    }

    public Trademark choiceTradeMark(Scanner scanner) {
        Trademark trademark = null;
        System.out.println("                     List TradeMark : ");
        managerCategory.display();
        System.out.println("--------------------------------");
        System.out.println("0.    Add  New  TradeMark:");
        System.out.println("--------------------------------");
        System.out.println("Enter ID Choice Trademark");
        trademark = managerTrademark.findById(scanner);
        if (trademark != null) {
            return trademark;
        } else {
            trademark = managerTrademark.create(scanner);
            managerTrademark.add(trademark);
            return trademark;
        }

    }

    public String choiceType(Scanner scanner) {
        String pattern = "^[1-3]$";
        boolean check = false;
        int choice;
        do {
            System.out.println("1. Men's Shoes");
            System.out.println("2. Women's Shoes");
            System.out.println("3. kid shoes");
            System.out.println("-------------------");
            System.out.print("Enter ChoiceType :");
            choice = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(choice), pattern)) {
                check = true;
            } else {
                System.out.println("Malformed ChoiceType");
                System.out.println("\nPlease re-enter\n");
            }
        } while (!check);
        switch (choice) {
            case 1:
                return "Men's Shoes";
            case 2:
                return "Women's Shoes";
            default:
                return "kid shoes";
        }
    }

    @Override
    public Shoe create(Scanner scanner) {
        Shoe shoe;
        boolean check = false;
        String name;
        String type;
        int size;
        int quantity;
        Category category;
        Trademark trademark;
        double price;
        String describe;
        System.out.println("\nCreate New Customer...!\n");
        System.out.println("name : (3-15) characters without special characters but accept \"-\";\"_\"");
        do {
            System.out.print("Enter Name : ");
            name = scanner.nextLine();
            if (myRegex.regex(name, myRegex.getPatternName())) {
                check = true;
            } else {
                System.err.println("Malformed Name");
                System.out.println("\nname : (3-15) characters without special characters but accept \"-\";\"_\"");
                check = false;
            }
        } while (!check);
        check = true;
        System.out.println("                          List ChoiceType");
        type = choiceType(scanner);
        do {
            System.out.print("Enter Size : ");
            size = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(size), myRegex.getPatternNumber())) {
                check = true;
            } else {
                System.err.println("Malformed Size:");
                System.out.println("\nSize :contains only numbers\n ");
                check = false;
            }
        } while (!check);
        check = true;
        do {
            System.out.print("Enter Quantity : ");
            quantity = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(quantity), myRegex.getPatternNumber())) {
                check = true;
            } else {
                System.err.println("Malformed Quantity:");
                System.out.println("\nSize :contains only numbers\n ");
                check = false;
            }
        } while (!check);
        check = true;
        category = choiceCategory(scanner);
        trademark = choiceTradeMark(scanner);
        do {
            System.out.print("Enter Price : ");
            price = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(price), myRegex.getPatternNumber())) {
                check = true;
            } else {
                System.err.println("Malformed Price:");
                System.out.println("\nSize :contains only numbers\n ");
                check = false;
            }
        } while (!check);
        check = true;
        do {
            System.out.print("Enter Describe : ");
            describe = scanner.nextLine();
            if (myRegex.regex(describe, myRegex.getPatternName())) {
                check = true;
            } else {
                System.err.println("Malformed Describe");
                System.out.println("\nname : (3-15) characters without special characters but accept \"-\";\"_\"");
                check = false;
            }
        } while (!check);
        shoe = new Shoe(autoId, name, type, size, quantity, category, trademark, price, describe);
        System.err.println("                                  Create Successful...! ");
        return shoe;
    }

    @Override
    public void add(Shoe shoe) {
        listShoe.add(shoe);
    }
}
