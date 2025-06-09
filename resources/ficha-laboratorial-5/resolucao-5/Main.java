package Ficha5_ed;

import java.util.*;

public class Main {

    public static <T> void myFill(List <? super T> d, T n) {
        ListIterator it = d.listIterator();
        while(it.hasNext()) {
            it.next();
            it.set(n);
        }
    }

    public static void imprimeInverso(List<?> alist) {
        ListIterator it = alist.listIterator(alist.size());

        int j = alist.size();
        while(it.hasPrevious())
            System.out.println("[" + (--j) + "] " + it.previous());
    }

    public static double testa(Pilha p, long sz) {
        long startTime = System.nanoTime();
        for(int j = 0; j < sz; j++)
            p.push(j);
        for (int j = 0; j < sz; j++)
            p.pop();
       return (System.nanoTime() - startTime )/ 1000000.0;
    }

    public static double testa(Fila p, long sz) {
        long startTime = System.nanoTime();
        for(int j = 0; j < sz; j++)
            p.add(j);
        for (int j = 0; j < sz; j++)
            p.remove();
        return (System.nanoTime() - startTime )/ 1000000.0;
    }

    public static <T> void rev(List<? super T> alist) {
        ListIterator iti = alist.listIterator();
        ListIterator itf = alist.listIterator(alist.size());
        T temp;
        while(iti.nextIndex() < itf.previousIndex()) {
            temp = (T) iti.next();
            iti.set(itf.previous());
            itf.set(temp);
        }
    }

    public static <T> void redPrint(Collection<T> col) {
        Pilha<T> pilha = new Pilha<>(new ArrayList<>());

        for(T valor:col)
            pilha.push(valor);
        while(!pilha.empty())
            System.out.println(pilha.pop());
    }

    public static <T> void removeParesb(List<T> alist) {
        List<T> l = new ArrayList<>(alist.size() / 2 + 1);
        ListIterator iti = alist.listIterator();

        while(iti.hasNext()) {
            iti.next();
            if(iti.hasNext())
                l.add((T) iti.next());
        }
        alist.clear();
        alist.addAll(l);
    }

    public static <T> void removePares(List<? super T> alist) {
        ListIterator iti = alist.listIterator();

        while(iti.hasNext()) {
            iti.next();
            if(iti.hasNext()) {
                iti.next();
                iti.remove();
            }
        }
    }

    public static void main(String[] args) {
	    List alist = new ArrayList();
	    List llist = new LinkedList();
	    long n, sz = 5000, nruns = 20;
	    double tm;
	    Fila pll = new Fila(llist);
	    Fila pal = new Fila(alist);

        System.out.println("Tempo de execucao medio " + nruns + "execucoes (ms)");
        System.out.println("N | Arraylist |Linked list");
        for (int i = 1; i <= 30; i++) {
            n = sz * i;
            tm = 0;
            for (int j = 0; j < nruns; j++)
                tm += testa(pal, n);
            System.out.printf("%d | %9.2f | ", i, (float)(tm/nruns));
            tm = 0;
            for (int j = 0; j < nruns; j++)
                tm += testa(pll, n);
            System.out.printf("%.2f\n", (float)(tm/nruns));
        }
        /*System.out.println("Lista original: " + alist);
        Collections.fill(alist, "ED");
        System.out.println("Lista preenchida com fill: " + alist);
        myFill(alist, "F");
        System.out.println("Lista preenchida com myFill: " + alist);
         */
        imprimeInverso(alist);
    }
}
