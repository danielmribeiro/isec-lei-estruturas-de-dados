package Exercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio7 {
    
    public static <T> void removePares(List<? super T> lista) {
        ListIterator it = lista.listIterator();

        it.next(); // Switch par - impar
        while (it.hasNext()) {
            it.next();
            if (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }
    
    public static <T> void removePares_b(List<? super T> lista) {
        List<T> l = new ArrayList<>(lista.size() / 2 + 1); //garante capacidade necessária
        ListIterator it = lista.listIterator();

        it.next(); // Switch par - impar
        while (it.hasNext()) {
            l.add((T) it.next());   //O(1) para AL e LL - copia elementos em posições Impares
            
            if (it.hasNext()) {
                it.next();          //O(1) para AL e LL
            }
        }
        lista.clear();              //O(1) para AL e LL
        lista.addAll(l);            //O(N) para AL e LL
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
        System.out.println("original ArrayList: "+aList);
        // reverse the ArrayList with removePares
        removePares(aList);
        System.out.print("ArrayList elements after removePares(): "+aList);
        
        System.out.println();

        System.out.println("original LinkedList: "+lList);
        // reverse the LinkedList with removePares
        removePares(lList);
        System.out.print("LinkedList elements after removePares(): "+lList);
        
        
        System.out.println("");
        
        
        // create array list object       
        List aList_b = new ArrayList();
        // create linked list object
        List lList_b = new LinkedList();

        int nElementos_b = 100;
        
        // populate the list
        for (int i = 0; i < nElementos_b; i++) {
            aList_b.add(i);
        }
        for (int i = 0; i < nElementos_b; i++) {
            lList_b.add(i);
        }
        System.out.println("original ArrayList: "+aList_b);
        // reverse the ArrayList with removePares_b
        removePares_b(aList_b);
        System.out.print("ArrayList elements after removePares_b(): "+aList_b);
        
        System.out.println();

        System.out.println("original LinkedList: "+lList_b);
        // reverse the LinkedList with removePares_b
        removePares_b(lList_b);
        System.out.print("LinkedList elements after removePares_b(): "+lList_b);
    }
}
