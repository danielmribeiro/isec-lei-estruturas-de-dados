package Exercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Exercicio1 {
    
    public static <T> void ex1a(List<? super T> list, T value) {
        for (int i = 0; i < list.size(); i++) { // O(N^2) em Linked List
            list.set(i, value); // O(N)
        }
    }
    
    public static <T> void ex1b(List<? super T> list, T value) {
        ListIterator it = list.listIterator();

        while (it.hasNext()) { // O(N)
            it.next();
            it.set(value); // O(1)
        }
    }
    
    public static void main(String[] args) {
        // create array list object       
        List arrlist = new ArrayList();

        // populate the list
        arrlist.add("A");
        arrlist.add("B");
        arrlist.add("C");
        System.out.println("List elements before fill: "+arrlist);

        // fill the list with 'OLA'
        Collections.fill(arrlist,"OLA");
        System.out.println("List elements after fill: "+arrlist);
        
        // fill the list with 'ED'
        ex1a(arrlist,"ED");
        System.out.println("List elements after ex1a: "+arrlist);
        
        // fill the list with 'ADEUS'
        ex1a(arrlist,"ADEUS");
        System.out.println("List elements after ex1b: "+arrlist);
    }
}
