package Interface;

import java.util.Scanner;

public interface ICrud <E>{
    void display();
    E findById(Scanner scanner,String pattern);
    E create(Scanner scanner,String actionName);
    void add(E e);
    void update(Scanner scanner);
}
