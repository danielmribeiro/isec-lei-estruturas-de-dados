package Exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio2 {
    public static void imprimeInverso(List<?> alist){
        ListIterator it = alist.listIterator(alist.size());

        int j= alist.size();
        while(it.hasPrevious())
            System.out.println("["+(--j)+"] "+it.previous());
    }

    public static void main(String[] args) {
        List alist = new ArrayList();
        alist.add("A");
        alist.add("B");
        alist.add("C");

        System.out.println("Lista original: "+alist);
        imprimeInverso(alist);
    }
}
