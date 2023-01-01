package Interface;

import java.util.Scanner;

public interface ICrud <E>{
    void display();
    E findById(Scanner scanner);
    E create(Scanner scanner);
    void add(E e);
}
