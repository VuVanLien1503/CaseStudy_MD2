package manager.managerModel.properties;

import Interface.ICrud;
import manager.managerAction.MyFileBinary;
import manager.managerAction.MyRegex;
import model.AC.HandBag;
import model.ACproperties.ACSon.TradeMarkHandBag;
import model.ACproperties.ACSon.TradeMarkShoe;
import model.ACproperties.Trademark;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerTrademark implements ICrud<Trademark> {
    Scanner scanner = new Scanner(System.in);
    MyRegex myRegex = new MyRegex();
    MyFileBinary<Trademark> myFileBinary = new MyFileBinary<>();
    private int autoId;
    private ArrayList<Trademark> listTrademark;

    public ManagerTrademark() {
        listTrademark = new ArrayList<>();
        listTrademark=( (ArrayList<Trademark>) myFileBinary.inputStream(myFileBinary.getPathTradeMark()));
        if (!listTrademark.isEmpty()) {
            autoId = (listTrademark.get(listTrademark.size() - 1).getId()) + 1;
        } else {
            autoId = 1;
        }
    }

    public ArrayList<Trademark> getListTrademark() {
        return listTrademark;
    }

    public void setListTrademark(ArrayList<Trademark> listTrademark) {
        this.listTrademark = listTrademark;
    }

    public void title() {
        System.out.printf("%-10s%s",
                "ID", "NAME\n");
        System.out.println("-----------------");
    }

    @Override
    public Trademark findById(Scanner scanner,String patternNumber) {
        Trademark trademark = null;
        int id;
        boolean checkRegex = false;
        do {
            System.out.println("Enter Id : ");
            id = Integer.parseInt(scanner.nextLine());
            if (myRegex.regex(String.valueOf(id), patternNumber)) {
                checkRegex = true;
            } else {
                System.err.println("Malformed ID");
                System.out.println("\nId Contains Only Numbers\n");
            }
        } while (!checkRegex);
        for (Trademark t :
                listTrademark) {
            if (t.getId() == id) {
                trademark = t;
                break;
            }
        }
        return trademark;
    }

    @Override
    public void display() {
        title();
        for (Trademark tradeMark : listTrademark) {
            tradeMark.display();
        }
    }
    public void display(String nameTradeMark) {
        if (nameTradeMark.equals("Shoe")) {
            for (Trademark tr : listTrademark) {
                if (tr instanceof TradeMarkShoe) {
                    TradeMarkShoe tradeMarkShoe = (TradeMarkShoe) tr;
                    tradeMarkShoe.display();
                }
            }
            System.out.println("-------------------");
        }
        if (nameTradeMark.equals("HandBag")) {
            for (Trademark tr : listTrademark) {
                if (tr instanceof TradeMarkHandBag) {
                    TradeMarkHandBag tradeMarkHandBag = (TradeMarkHandBag) tr;
                    tradeMarkHandBag.display();
                }
            }
            System.out.println("------------------");
        }
    }
    @Override
    public Trademark create(Scanner scanner, String choiceName) {
        boolean check;
        String name;
        System.out.println("\nCreate New TradeMark\n");
        System.out.println("TradeMark : (3-15) characters ");
        do {
            System.out.print("Enter Name : ");
            name = scanner.nextLine();
            if (myRegex.regex(name, myRegex.getPatternName())) {
                check = true;
            } else {
                System.err.println("Malformed Name");
                System.out.println("\nTradeMark : (3-15) characters ");
                check = false;
            }
        } while (!check);
        Trademark trademark;
        if (choiceName.equals("Shoe")) {
            trademark = new TradeMarkShoe(autoId, name);
            return trademark;
        } else {
            trademark = new TradeMarkHandBag(autoId, name);
            return trademark;
        }
    }

    @Override
    public void add(Trademark trademark) {
        listTrademark.add(trademark);
        myFileBinary.outPutStream(myFileBinary.getPathTradeMark(), listTrademark);
        autoId++;
    }

    @Override
    public void update(Scanner scanner) {

    }
}
