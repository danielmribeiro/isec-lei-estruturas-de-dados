package Exercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Exercicio1 {
    public static <T> void myFill(List<? super T> d, T n){
        //Collections.fill(d,n);
        //for(int j=0;j<d.size();j++)
        //  d.set(j,n); //O(N2) em linked list
        ListIterator it = d.listIterator();
        while(it.hasNext()){
            it.next();
            it.set(n);  // it.set() é O(1) tanto em LL como AL
        }
    }

    public static void main(String[] args) {
        List alist = new ArrayList();
        alist.add("A");
        alist.add("B");
        alist.add("C");

        System.out.println("Lista original: "+alist);
        Collections.fill(alist,"ED");
        System.out.println("Lista preenchida com fill: "+alist);
        myFill(alist, "F");
        System.out.println("Lista preenchida com myFill: "+alist);
    }
}
