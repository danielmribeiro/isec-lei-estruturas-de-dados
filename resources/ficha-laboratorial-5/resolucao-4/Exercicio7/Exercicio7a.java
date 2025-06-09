package Exercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio7a {
    public static <T> void removePares(List<T> alist){
        ListIterator iti = alist.listIterator();
        List<T> l=new ArrayList<>(alist.size()/2+1);//garante a capacidade necessária

        while(iti.hasNext()){
            iti.next();
            if(iti.hasNext())
                l.add((T)iti.next()); //O(1) em AL e LL, copia elementos em posições impares
        }

        alist.clear(); // O(1) para AL e LL
        alist.addAll(l); //O(N) para AL e LL
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
