package manager.managerModel;

import Interface.ICrud;
import manager.managerAction.MyRegex;
import model.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerCategory implements ICrud<Category> {
    Scanner scanner = new Scanner(System.in);
    MyRegex myRegex = new MyRegex();
    private int autoId;
    private ArrayList<Category> listCategory;

    public ManagerCategory() {
        listCategory = new ArrayList<>();
        if (listCategory.size() > 0) {
            autoId = (listCategory.get(listCategory.size() - 1).getId() + 1);
        } else {
            autoId = 1;
        }
    }

    public ArrayList<Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(ArrayList<Category> listCategory) {
        this.listCategory = listCategory;
    }
    public void title() {
        System.out.printf("%-15s%s",
                "ID", "NAME\n");
        System.out.println("-----------------");
    }
    @Override
    public Category findById(Scanner scanner) {
        Category category = null;
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
        for (Category c :
                listCategory) {
            if (c.getId()==id){
                category=c;
                checkId=true;
                break;
            }
        }
        return category;
    }
    @Override
    public void display() {
        title();
        for (Category category : listCategory) {
            category.display();
        }
    }

    @Override
    public Category create(Scanner scanner) {
        Category category;
        String name;
        boolean check=false;
        System.out.println("\nCreate New Category\n");
        System.out.println("Category : (3-15) characters without special characters but accept \"-\";\"_\"");
        do {
            System.out.print("Enter Name : ");
            name=scanner.nextLine();
            if (myRegex.regex(name, myRegex.getPatternName())){
                check=true;
            }else {
                System.err.println("Malformed Name");
                System.out.println("\nCategory : (3-15) characters without special characters but accept \"-\";\"_\"");
                check = false;

            }
        }while (!check);
        category=new Category(autoId,name);
        return category;
    }

    @Override
    public void add(Category category) {
    listCategory.add(category);
    }
}
