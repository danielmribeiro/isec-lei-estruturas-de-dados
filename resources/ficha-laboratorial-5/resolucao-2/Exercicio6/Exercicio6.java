package Exercicio6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Exercicio6 {
    
    public static <T> void mostraInverso(Collection<T> colection) {
        Pilha<T> pilha = new Pilha<>(new ArrayList<T>());

        for (T valor : colection) {
            pilha.push(valor);
        }

        System.out.print("[");
        while(!pilha.empty()){
            System.out.print(pilha.pop());
            if(!pilha.empty()){
                System.out.print(", ");
            }
        }
        System.out.println("]");
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
        // reverse the ArrayList with mostraInverso
        System.out.print("ArrayList elements after mostraInverso(): ");mostraInverso(aList);
        
        System.out.println();

        System.out.println("LinkedList elements before fill: "+lList);
        // reverse the LinkedList with mostraInverso
        System.out.print("LinkedList elements after mostraInverso(): ");mostraInverso(lList);
    }
}
