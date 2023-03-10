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
    MyFileBinary<Product> myFileBinary = new MyFileBinary<>();
    private int autoId;
    private ArrayList<Product> listProduct;

    public ManagerProduct(ManagerTrademark managerTrademark) {
        managerTrademark = new ManagerTrademark();
        this.managerTrademark = managerTrademark;
        listProduct = new ArrayList<>();
        listProduct = (ArrayList<Product>) myFileBinary.inputStream(myFileBinary.getPathProduct());
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
        System.out.printf("%-5s%-15s%-20s%-10s%-10s%-15s%-20s%-20s%-25s%s",
                "| ID", "| NAME", "| TYPE", "| SIZE", "| PRICE", "| QUANTITY", "| CATEGORY", "| DESCRIBE", "| TRADEMARK", " |\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public Product findById(Scanner scanner, String patternNumber) {
        Product product = null;
        int id ;
        boolean checkRegex = false;
        do {
            System.out.println("Enter Id : ");
            id = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(id), patternNumber)) {
                if (checkId(id, listProduct)) {
                    checkRegex = true;
                } else {
                    System.err.println("Id Not Exist");
                }

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
    public boolean checkId(int id, ArrayList<Product> list) {
        boolean check = false;
        for (Product p :
                list) {
            if (p.getId() == id) {
                check = true;
                break;
            }
        }
        return check;
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
        boolean check = false;
        String patternIdShoe = "";
        int number = 0;
        String choice;
        boolean checkChoice = false;
        if (nameTradeMark.equals("Shoe")) {
            if (managerTrademark.getListTrademark().isEmpty()) {
                check = true;
            } else {
                do {
                    patternIdShoe = "[0";
                    System.out.println("List TradeMarkShoe :");
                    System.out.println("--------------------------");
                    for (Trademark shoe : managerTrademark.getListTrademark()) {
                        if (shoe instanceof TradeMarkShoe) {
                            TradeMarkShoe tradeMarkShoe = (TradeMarkShoe) shoe;
                            patternIdShoe += tradeMarkShoe.getId();
                            tradeMarkShoe.display();
                        }
                    }
                    patternIdShoe += "]$";
                    System.out.println("--------------------------");
                    System.out.println("0.    Add  New  TradeMark:");
                    System.out.println("--------------------------");
                    System.out.println("Enter ID Choice Trademark " + patternIdShoe);
                    choice = scanner.nextLine();
                    if (myRegex.regex(String.valueOf(choice), patternIdShoe)) {
                        number = Integer.parseInt(choice);
                        checkChoice = true;
                    } else {
                        System.err.println("                               Malformed ID Choice Mark");
                        System.out.println("\n                                 Please re-enter");
                    }
                } while (!checkChoice);
                switch (number) {
                    case 0:
                        trademark = managerTrademark.create(scanner);
                        managerTrademark.add(trademark);
                        return trademark;
                    default:
                        for (Trademark tr :
                                managerTrademark.getListTrademark()) {
                            if (tr.getId() == number) {
                                trademark = tr;
                                return trademark;
                            }
                        }
                }
            }
        } else {
            if (nameTradeMark.equals("HandBag")) {
                if (managerTrademark.getListTrademark().isEmpty()) {
                    check = true;
                } else {
                    do {
                        patternIdShoe = "[0";
                        System.out.println("List TradeMark HandBag : ");
                        System.out.println("--------------------------");
                        for (Trademark handBag : managerTrademark.getListTrademark()) {
                            if (handBag instanceof TradeMarkHandBag) {
                                TradeMarkHandBag tradeMarkHandBag = (TradeMarkHandBag) handBag;
                                patternIdShoe += tradeMarkHandBag.getId();
                                tradeMarkHandBag.display();
                            }
                        }
                        patternIdShoe += "]$";
                        System.out.println("--------------------------");
                        System.out.println("0.    Add  New  TradeMark:");
                        System.out.println("--------------------------");
                        System.out.println("Enter ID Choice Trademark " + patternIdShoe);
                        choice = scanner.nextLine();
                        if (myRegex.regex(String.valueOf(choice), patternIdShoe)) {
                            number = Integer.parseInt(choice);
                            checkChoice = true;
                        } else {
                            System.err.println("                               Malformed ID Choice Mark");
                            System.out.println("\n                                 Please re-enter");
                        }
                    } while (!checkChoice);
                    switch (number) {
                        case 0:
                            trademark = managerTrademark.create(scanner);
                            managerTrademark.add(trademark);
                            return trademark;
                        default:
                            for (Trademark tr :
                                    managerTrademark.getListTrademark()) {
                                if (tr.getId() == number) {
                                    trademark = tr;
                                    return trademark;
                                }
                            }
                    }
                }
            }
        }
        if (check) {
            trademark = managerTrademark.create(scanner);
            managerTrademark.add(trademark);
            return trademark;
        } else {
            return trademark;
        }
    }

    public String choiceType(Scanner scanner, String typeName) {
        String pattern = "^[1-3]$";
        boolean check = false;
        int choice;
        do {
            System.out.println("MENU SHOE TYPE");
            System.out.println("1. Men's " + typeName + "s");
            System.out.println("2. Women's " + typeName + "s");
            System.out.println("3. kid " + typeName + "s");
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
                return "Men's " + typeName + "s";
            case 2:
                return "Women's " + typeName + "s";
            default:
                return "kid " + typeName + "s";
        }
    }

    public String choiceCategoryHandBag(Scanner scanner) {
        String pattern = "^[1-4]$";
        boolean check = false;
        int choice;
        do {
            System.out.println("MENU CATEGORY HANDBAG:");
            System.out.println("1. CrossBody");
            System.out.println("2. Handed");
            System.out.println("3. Portable");
            System.out.println("4. BackPack");
            System.out.println("---------------------");
            System.out.print("Enter choice Category :");
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
                return "CrossBody";
            case 2:
                return "Handed";
            case 3:
                return "Portable";
            default:
                return "BackPack";
        }

    }

    public String choiceCategoryShoe(Scanner scanner) {
        String pattern = "^[1-4]$";
        boolean check = false;
        int choice;
        do {
            System.out.println("MENU CATEGORY:");
            System.out.println("1. Soccer Shoes");
            System.out.println("2. Basketball Shoes");
            System.out.println("3. Office Shoes");
            System.out.println("4. Walking shoes");
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
                return "SoccerShoes";
            case 2:
                return "BasketBallShoes";
            case 3:
                return "OfficeShoes";
            default:
                return "WalkingShoes";
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
    public Product create(Scanner scanner) {
        String choiceName= managerTrademark.choiceNameTradeMark();
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
        System.out.println("\nCreate New Product...!\n");
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
        type = choiceType(scanner, choiceName);
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
        } while (!check);
        if (choiceName.equals("Shoe")) {
            category = choiceCategoryShoe(scanner);
            trademark = choiceTradeMark(scanner, choiceName);
            product = new Shoe(autoId, name, type, size, quantity, category, trademark, price, describe);
            System.err.println("                                              Create Successful...! \n");
            title();
            product.display();
            return product;
        } else {
            category = choiceCategoryHandBag(scanner);
            trademark = choiceTradeMark(scanner, choiceName);
            product = new Shoe(autoId, name, type, size, quantity, category, trademark, price, describe);
            System.err.println("                                                Create Successful...! \n");
            title();
            product.display();
            return product;
        }
    }

    @Override
    public void add(Product product) {
        listProduct.add(product);
        myFileBinary.outPutStream(myFileBinary.getPathProduct(), listProduct);
        autoId++;
    }

    @Override
    public void update(Scanner scanner) {
        display();
        Product product = findById(scanner, myRegex.getPatternNumber());
        boolean check;
        String name;
        String type;
        int size;
        int quantity;
        String category;
        Trademark trademark = null;
        double price;
        String describe;
        System.out.println("\nUpdate New Product...!\n");
        System.out.println("name : (3-15) characters ");
        do {
            System.out.println("UPDATE NAME : ");
            System.out.print(product.getName() + " UPDATE --> ");
            name = scanner.nextLine();
            if (myRegex.regex(name, myRegex.getPatternName())) {
                check = true;
            } else {
                System.err.println("Malformed Name");
                System.out.println("\nname : (3-15) characters ");
                check = false;
            }
        } while (!check);

        product.setName(name);

        check = true;


        do {
            System.out.print("UPDATE SIZE ");
            System.out.print(product.getSize() + " UPDATE --> ");
            size = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(size), myRegex.getPatternNumber())) {
                check = true;
            } else {
                System.err.println("Malformed Size:");
                System.out.println("\nSize :contains only numbers\n ");
                check = false;
            }
        } while (!check);

        product.setSize(size);

        check = true;
        do {
            System.out.print("UPDATE QUANTITY  ");
            System.out.print(product.getQuantity() + " UPDATE --> ");
            quantity = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(quantity), myRegex.getPatternDouble())) {
                check = true;
            } else {
                System.err.println("Malformed Quantity:");
                System.out.println("\nSize :contains only numbers\n ");
                check = false;
            }
        } while (!check);

        product.setQuantity(quantity);

        check = true;

        do {
            System.out.print("UPDATE PRICE ");
            System.out.print(product.getPrice() + " UPDATE --> ");
            price = Double.parseDouble(scanner.nextLine());
            if (myRegex.regex(String.valueOf(price), myRegex.getPatternDouble())) {
                check = true;
            } else {
                System.err.println("Malformed Price:");
                System.out.println("\nPrice :contains only numbers\n ");
                check = false;
            }
        } while (!check);

        product.setPrice(price);

        check = true;
        System.out.print("UPDATE DESCRIBE ");
        System.out.print(product.getDescribe() + " UPDATE --> ");
        describe = scanner.nextLine();
        product.setDescribe(describe);
        String choiceName;
        if (product.getTrademark().getName().equals("Shoe")) {
            choiceName = "Shoe";
            System.out.println("                          List ChoiceType");
            type = choiceType(scanner, choiceName);
            System.out.print(product.getType() + " UPDATE --> " + type + "\n");

            product.setType(type);
            category = choiceCategoryShoe(scanner);
            System.out.println(product.getCategory() + " UPDATE --> " + category + "\n");
            product.setCategory(category);

            trademark = choiceTradeMark(scanner, choiceName);
            System.out.println(product.getTrademark().getName() + " UPDATE --> " + trademark.getName() + "\n");
            product.setTrademark(trademark);

            System.err.println("                                  Create Successful...! ");

        } else {
            choiceName = "HandBag";
            System.out.println("                          List ChoiceType");
            type = choiceType(scanner, choiceName);
            System.out.print(product.getType() + " UPDATE --> " + type + "\n");

            product.setType(type);
            category = choiceCategoryHandBag(scanner);
            System.out.println(product.getCategory() + " UPDATE --> " + category + "\n");
            product.setCategory(category);

            trademark = choiceTradeMark(scanner, choiceName);
            System.out.println(product.getTrademark().getName() + " UPDATE --> " + trademark.getName() + "\n");
            product.setTrademark(trademark);

            System.err.println("                                  Create Successful...! ");
            myFileBinary.outPutStream(myFileBinary.getPathProduct(), listProduct);
        }
    }

    @Override
    public Product delete(Scanner scanner) {
        System.out.println("List Product");
        display();
        Product product= findById(scanner, myRegex.getPatternNumber());
        System.err.println("                                                     Delete Successful \n");
        title();
        product.display();
        listProduct.remove(product);
       myFileBinary.outPutStream(myFileBinary.getPathProduct(), listProduct);
       return product;
    }
}
