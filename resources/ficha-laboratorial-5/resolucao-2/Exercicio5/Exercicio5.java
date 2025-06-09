package Exercicio5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio5 {
    
    public static <T> void inverte(List<? super T> lista) {
        ListIterator iti = lista.listIterator();
        ListIterator itf = lista.listIterator(lista.size());

        while (iti.nextIndex() < itf.previousIndex()) {
            T hold = (T) iti.next();
            iti.set(itf.previous());
            itf.set(hold);
        }
    }
    
    public static void main(String[] args) {
        // create array list object       
        List aList = new ArrayList();
        // create linked list object
        List lList = new LinkedList();

        int nElementos = 100;
        
        // populate the list
        for (int i = 0; i < nElementos; i++) {
            aList.add(i);
        }
        for (int i = 0; i < nElementos; i++) {
            lList.add(i);
        }
        System.out.println("ArrayList elements before fill: "+aList);

        // reverse the ArrayList with Collections.reverse
        Collections.reverse(aList);
        System.out.println("ArrayList elements after Collections.reverse(): "+aList);
        Collections.reverse(aList);
        System.out.println("ArrayList elements back to normal after Collections.reverse(): "+aList);
        
        // reverse the ArrayList with inverte
        inverte(aList);
        System.out.println("ArrayList elements after inverte(): "+aList);
        inverte(aList);
        System.out.println("ArrayList elements back to normal after inverte(): "+aList);
        
        
        System.out.println();

        System.out.println("LinkedList elements before fill: "+lList);

        // reverse the LinkedList with Collections.reverse
        Collections.reverse(lList);
        System.out.println("LinkedList elements after Collections.reverse(): "+lList);
        Collections.reverse(lList);
        System.out.println("LinkedList elements back to normal after Collections.reverse(): "+lList);
        
        // reverse the LinkedList with inverte
        inverte(lList);
        System.out.println("LinkedList elements after inverte(): "+lList);
        inverte(lList);
        System.out.println("LinkedList elements back to normal after inverte(): "+lList);
    }
}
