package exercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static <T> void fill(List<? super T> d, T n){
        ListIterator it = d.listIterator();
        while(it.hasNext()){
            it.next();
            it.set(n);
        }
    }

    public static void main(String[] args) {
        List alist = new ArrayList();
        alist.add("Daniel");
        alist.add("Marta");
        alist.add("Pedro");

        fill(alist, "Joao");
        System.out.println(alist);
    }
}
