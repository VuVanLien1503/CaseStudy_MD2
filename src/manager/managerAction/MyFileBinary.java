package manager.managerAction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileBinary<E> {
   private String pathCustomer = "src\\file\\customer";
    private String pathTradeMark = "src\\file\\trademark";
    private String pathProduct="src\\file\\product";

    public String getPathCustomer() {
        return pathCustomer;
    }

    public void setPathCustomer(String pathCustomer) {
        this.pathCustomer = pathCustomer;
    }

    public String getPathTradeMark() {
        return pathTradeMark;
    }

    public void setPathTradeMark(String pathTradeMark) {
        this.pathTradeMark = pathTradeMark;
    }

    public String getPathProduct() {
        return pathProduct;
    }

    public void setPathProduct(String pathProduct) {
        this.pathProduct = pathProduct;
    }

    public void outPutStream(String path, List<E> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------");

    }

    public List<E> inputStream(String path) {
        List<E> list = new ArrayList<>();
        try {
            File file=new File(path);
            if (!file.exists()){
                file.createNewFile();
            }

            FileInputStream fis = new FileInputStream(path);
            if (fis.available()>0){
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (List<E>) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (IOException |ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
