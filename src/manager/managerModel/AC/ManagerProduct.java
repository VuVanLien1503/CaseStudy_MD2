package manager.managerModel.AC;

import Interface.ICrud;
import Interface.Product;
import manager.managerAction.MyFileBinary;
import manager.managerAction.MyRegex;
import manager.managerModel.properties.ManagerTrademark;
import model.AC.HandBag;
import model.AC.Shoe;
import model.ACproperties.ACSon.TradeMarkHandBag;
import model.ACproperties.ACSon.TradeMarkShoe;
import model.ACproperties.Trademark;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct implements ICrud<Product> {

    ManagerTrademark managerTrademark;
    MyRegex myRegex = new MyRegex();
    MyFileBinary<Product>myFileBinary=new MyFileBinary<>();
    private int autoId;
    private ArrayList<Product> listProduct;

    public ManagerProduct(ManagerTrademark managerTrademark) {
        managerTrademark=new ManagerTrademark();
        this.managerTrademark = managerTrademark;
        listProduct = new ArrayList<>();
        if (listProduct.size() > 0) {
            autoId = (listProduct.get(listProduct.size() - 1).getId()) + 1;
        } else {
            autoId = 1;
        }
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public void title() {
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s%-20s%s",
                "ID", "NAME", "TYPE", "SIZE", "QUANTITY", "CATEGORY",  "PRICE", "DESCRIBE","TRADEMARK\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public Product findById(Scanner scanner) {
        Product product = null;
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
        for (Product s :
                listProduct) {
            if (s.getId() == id) {
                product = s;
                break;
            }
        }
        return product;
    }

    @Override
    public void display() {
        title();
        for (Product product : listProduct) {
            if (product instanceof Shoe) {
                Shoe shoe = (Shoe) product;
                shoe.display();
            } else {
                if (product instanceof HandBag) {
                    HandBag handBag = (HandBag) product;
                    handBag.display();
                }
            }

        }
    }

    public Trademark choiceTradeMark(Scanner scanner, String nameTradeMark) {
        Trademark trademark = null;
        if (nameTradeMark.equals("Shoe")) {
            if (managerTrademark.getListTrademark().isEmpty()) {

                trademark = managerTrademark.create(scanner, nameTradeMark);
                managerTrademark.add(trademark);
                return trademark;
            }else {
                System.out.println("                     List TradeMarkShoe : ");
                for (Trademark shoe : managerTrademark.getListTrademark()) {
                    if (shoe instanceof TradeMarkShoe) {
                        TradeMarkShoe tradeMarkShoe = (TradeMarkShoe) shoe;
                        tradeMarkShoe.display();
                        System.out.println("--------------------------------");
                        System.out.println("0.    Add  New  TradeMark:");
                        System.out.println("--------------------------------");
                        System.out.println("Enter ID Choice Trademark");
                        trademark = managerTrademark.findById(scanner);
                        return trademark;
                    }
                }
            }
        } else {
            if (nameTradeMark.equals("HandBag")) {
                if (managerTrademark.getListTrademark().isEmpty()) {
                    trademark = managerTrademark.create(scanner, nameTradeMark);
                    managerTrademark.add(trademark);
                    return trademark;
                }else {
                    System.out.println("                    List TradeMarkShoe : ");
                    for (Trademark handBag : managerTrademark.getListTrademark()) {
                        if (handBag instanceof TradeMarkHandBag) {
                            TradeMarkHandBag tradeMarkHandBag = (TradeMarkHandBag) handBag;
                            tradeMarkHandBag.display();
                            System.out.println("---------------------------------");
                            System.out.println("0.    Add  New  TradeMark :");
                            System.out.println("---------------------------------");
                            System.out.println("Enter ID Choice Trademark ");
                            trademark = managerTrademark.findById(scanner);
                            return trademark;
                        }
                    }
                }
            }
        }
        return trademark;
    }

    public String choiceType(Scanner scanner) {
        String pattern = "^[1-3]$";
        boolean check = false;
        int choice;
        do {
            System.out.println("1. Giầy Nam");
            System.out.println("2. Giầy Nữ");
            System.out.println("3. Giầy Trẻ em");
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
                return "Giày Nam";
            case 2:
                return "Giày Nữ";
            default:
                return "Giày Trẻ Em";
        }
    }

    public String choiceCategoryShoe(Scanner scanner) {
        String pattern = "^[1-4]$";
        boolean check = false;
        int choice;
        do {
            System.out.println("MENU CATEGORY:");
            System.out.println("1. Giày Bóng Đá");
            System.out.println("2. Giầy Bóng Rổ");
            System.out.println("3. Giầy Công Sở");
            System.out.println("4. Giày  Đi  Bộ");
            System.out.println("--------------------");
            System.out.print("Enter choice Shoe :");
            choice = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(choice), pattern)) {
                check = true;
            } else {
                System.out.println("Malformed ChoiceShoe");
                System.out.println("\nPlease re-enter\n");
            }
        } while (!check);
        switch (choice) {
            case 1:
                return "Giày Bóng Đá";
            case 2:
                return "Giầy Bóng Rổ";
            case 3:
                return "Giầy Công Sở";
            default:
                return "Giày  Đi  Bộ";
        }
    }

    public String choiceProduct(Scanner scanner) {
        String pattern = "^[1-2]$";
        boolean check = false;
        int choice;
        do {
            System.out.println("1. Action Shoes");
            System.out.println("2. Action HandBag");
            System.out.println("-------------------");
            System.out.print("Enter Choice :");
            choice = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(choice), pattern)) {
                check = true;
            } else {
                System.out.println("Malformed Choice");
                System.out.println("\nPlease re-enter\n");
            }
        } while (!check);
        switch (choice) {
            case 1:
                return "Shoe";
            default:
                return "HandBag";
        }
    }

    @Override
    public Product create(Scanner scanner, String choiceName) {
        Product product;
        boolean check;
        String name;
        String type;
        int size;
        int quantity;
        String category;
        Trademark trademark = null;
        double price;
        String describe;
        System.out.println("\nCreate New Customer...!\n");
        System.out.println("name : (3-15) characters ");
        do {
            System.out.print("Enter Name : ");
            name = scanner.nextLine();
            if (myRegex.regex(name, myRegex.getPatternName())) {
                check = true;
            } else {
                System.err.println("Malformed Name");
                System.out.println("\nname : (3-15) characters ");
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
            if (myRegex.regex(String.valueOf(quantity), myRegex.getPatternDouble())) {
                check = true;
            } else {
                System.err.println("Malformed Quantity:");
                System.out.println("\nSize :contains only numbers\n ");
                check = false;
            }
        } while (!check);
        check = true;
        category = choiceCategoryShoe(scanner);
        do {
            System.out.print("Enter Price : ");
            price = Double.parseDouble(scanner.nextLine());
            if (myRegex.regex(String.valueOf(price), myRegex.getPatternDouble())) {
                check = true;
            } else {
                System.err.println("Malformed Price:");
                System.out.println("\nPrice :contains only numbers\n ");
                check = false;
            }
        } while (!check);
        check = true;
        do {
            System.out.print("Enter Describe : ");
            describe = scanner.nextLine();
            if (myRegex.regex(describe, myRegex.getPatternText())) {
                check = true;
            } else {
                System.err.println("Malformed Describe");
                System.out.println("\nname : (3-15) characters");
                check = false;
            }
        } while (!check);
        if (choiceName.equals("Shoe")) {
            trademark = choiceTradeMark(scanner, "Shoe");
            product = new Shoe(autoId, name, type, size, quantity, category, trademark, price, describe);
            System.err.println("                                  Create Successful...! ");
            return product;
        } else {
            product = new Shoe(autoId, name, type, size, quantity, category, trademark, price, describe);
            System.err.println("                                  Create Successful...! ");
            return product;
        }

    }

    @Override
    public void add(Product product) {
        listProduct.add(product);
        myFileBinary.outPutStream(myFileBinary.getPathProduct(),listProduct);
        autoId++;
    }
}
