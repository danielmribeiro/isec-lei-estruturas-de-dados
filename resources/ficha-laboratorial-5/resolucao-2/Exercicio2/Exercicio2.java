package Exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio2 {
    
    public static <T> void ex2(List<? super T> list) {
        ListIterator it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }
    
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("P");
        list.add("R");
        list.add("O");
        list.add("G");
        list.add("R");
        list.add("A");
        list.add("M");
        list.add("A");

        ex2(list);
    }
}
