package Interface;

import java.util.ArrayList;
import java.util.Scanner;

public interface ICrud <E>{
    void display();
    E findById(Scanner scanner,String pattern);
    boolean checkId(int id, ArrayList<E>list);
    E create(Scanner scanner);
    void add(E e);
    void update(Scanner scanner);
    E delete(Scanner scanner);
}
