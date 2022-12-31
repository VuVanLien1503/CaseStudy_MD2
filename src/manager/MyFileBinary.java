package manager;

import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileBinary<E> {
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
