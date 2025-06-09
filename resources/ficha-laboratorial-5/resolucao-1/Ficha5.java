/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author nelio
 */
public class Ficha5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List alist = new ArrayList();
        alist.add("A");
        alist.add("B");
        alist.add("C");
        System.out.println("Lista original: " + alist);

        Collections.fill(alist, "ED");
        System.out.println("Lista preenchida com [fill]: " + alist);

        myFill(alist, 1);
        System.out.println("Lista preenchida com [myFill]: " + alist);

        System.out.println("");
        alist.add("A");
        alist.add("B");
        alist.add("C");
        System.out.println("[mostraListaInvertida]: ");
        mostraListaInvertida(alist);

        Pilha<Integer> p1 = new Pilha(new ArrayList());
        long n, sz = 50000, nruns = 20;
        double tm;
        p1.push(1);
        p1.push(2);
        System.out.println("");
        System.out.println("[Mostra Lista Classe Pilha]:");
        p1.mostraLista();
        System.out.println("");
        System.out.println("[testaPop]Tempo de execução médio " + nruns + " execucoes(ms)");
        System.out.println("N | Arraylist | Linked list");

        for (int i = 1; i <= 7; i++) {
            n = sz * i;
            tm = 0;
            for (int j = 0; j < nruns; j++) tm += testaPop(p1, n);
            System.out.printf("%d | %9.2f |", i, (float)(tm/nruns));
            tm = 0;
            for(int j=0; j<nruns; j++) tm += testaPop(p1, n);
            System.out.printf(" %.2f", (float)(tm/nruns));
            System.out.println("");
        }
        
        System.out.println("");
        System.out.println("[testaRemove]Tempo de execução médio " + nruns + " execucoes(ms)");
        System.out.println("N | Arraylist | Linked list");

        for (int i = 1; i <= 7; i++) {
            n = sz * i;
            tm = 0;
            for (int j = 0; j < nruns; j++) tm += testaRemove(p1, n);
            System.out.printf("%d | %9.2f |", i, (float)(tm/nruns));
            tm = 0;
            for(int j=0; j<nruns; j++) tm += testaRemove(p1, n);
            System.out.printf(" %.2f", (float)(tm/nruns));
            System.out.println("");
        }
        
        Pilha<Character> p2 = new Pilha(new ArrayList());
        p2.push('R');
        p2.push('O');
        p2.push('M');
        p2.push('A');
        System.out.println("");
        System.out.println("Mostra pilha 2:");
        p2.mostraLista();
        System.out.println("");
        System.out.println("[inverteLista]:");
        p2.inverteLista();
        p2.mostraLista();
        System.out.println("");
        System.out.println("[removePares]:");
        p2.removePares();
        p2.mostraLista();
        
        SortedPilha sp = new SortedPilha<>();
        sp.push(1);
        sp.push(2);
        sp.push(0);
        sp.show();
    }

    public static <T> void myFill(List<? super T> d, T n) {
        //Collections.fill(d, n);
        //for(int j=0; j<d.size(); j++) d.set(j, n);  // O(N2) em linked list

        ListIterator it = d.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(n);
        }
    }

    public static void mostraListaInvertida(List<?> d) {
        ListIterator it = d.listIterator(d.size());
        int j = d.size();
        while (it.hasPrevious()) {
            System.out.println("[" + (j--) + "]: " + it.previous());
        }
    }

    public static double testaPop(Pilha p, long sz) {
        long start = System.nanoTime();
        for (int j = 0; j < sz; j++) {
            p.push(j);
        }
        for (int j = 0; j < sz; j++) {
            p.pop();    //percorre lista com remove(j), sendo que o remove(j) tambem percorre a lista até posição j
        }
        return (System.nanoTime() - start) / 100000000.0;
    }
    
    public static double testaRemove(Pilha p, long sz) {
        long start = System.nanoTime();
        for (int j = 0; j < sz; j++) {
            p.push(j);
        }
        for (int j = 0; j < sz; j++) {           
            p.remove();     // percorre lista com remove(0), removendo sempre o primeiro 
        }
        return (System.nanoTime() - start) / 1000000.0;
    }
    
    /*public boolean inverteLista(List<?> l){
        ListIterator iti = l.listIterator();
        ListIterator itf = l.listIterator(l.size());
        T temp;
        
        while (itf.nextIndex() < itf.previousIndex()) {
            temp = (T)iti.next();
            (T)iti.previous() = temp;
        }
        return true;
    }*/
    
    public static <T extends Comparable> void revPrint(Collection <T> col){
        Pilha<T> pilha = new Pilha<>(new ArrayList<T>());
        
        for(T valor:col) pilha.push(valor);
        
        while(!pilha.empty()) System.out.println(pilha.pop());
    }
}
