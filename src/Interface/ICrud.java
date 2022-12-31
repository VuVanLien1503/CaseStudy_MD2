package Interface;

import java.util.Scanner;

public interface ICrud <E>{
    void display();
    E create(Scanner scanner);
    void add(E e);
}
