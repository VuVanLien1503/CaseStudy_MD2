package manager;

import model.Trademark;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerTrademark {
    String patternEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    String patternName = "^[a-zA-Z]{1}[a-z0-9_-]{3,15}$";
    String patternPhone = "^[0][0-9]{9}$";
    String patternPassWord = "^[a-zA-Z0-9]{4,15}$";
    Scanner scanner = new Scanner(System.in);

    private int autoId;
    private ArrayList<Trademark>listTrademark;

    public ManagerTrademark() {
        listTrademark=new ArrayList<>();
        if (listTrademark.size() > 0) {
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
}
