package Exercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio7b {
    public static <T> void removePares(List<? super T> alist){
        ListIterator iti = alist.listIterator();

        while(iti.hasNext()){
            iti.next();
            iti.remove();
            if(iti.hasNext()){
                iti.next();
            }
        }
    }

    public static void main(String[] args) {
        List alist = new ArrayList();
        List llist = new LinkedList();

        alist.add("AA");
        alist.add("BB");
        alist.add("CC");
        alist.add("DD");
        alist.add("EE");

        System.out.println(alist);
        removePares(alist);
        System.out.println("Sem os pares:"+alist);
    }
}
