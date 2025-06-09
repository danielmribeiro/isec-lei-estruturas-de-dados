package Exercicio4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio4 {
    public static double testa4(Fila p, long sz){
        long startTime=System.nanoTime();
        for(int j=0;j<sz;j++){
            p.add(j);
        }
        for(int j=0;j<sz;j++){
            p.remove(); //Este remove é à cabeça
        }
        return (System.nanoTime() - startTime)/1000000.0;
    }

    public static void main(String[] args) {
        List alist = new ArrayList();
        List llist = new LinkedList();
        long n,sz=10000,nruns=20;
        double tm;
        Fila pll = new Fila(llist);
        Fila pal = new Fila(alist);

        System.out.println("Tempo de execução médio "+nruns+" execuções(ms)");
        System.out.println("N | ArrayList | Linked list");

        for (int i = 1; i <=30 ; i++) {
            n=sz*i; // tamanho do pacote de dados a meter neste ciclo
            tm=0;
            for(int j=0;j<nruns;j++)
                tm+=testa4(pal,n);
            System.out.printf("%d | %9.2f | ",i,(float)(tm/nruns));
            tm=0;
            for(int j=0;j<nruns;j++)
                tm+=testa4(pll,n);
            System.out.printf(" %.2f\n",(float)(tm/nruns));
        }
    }
}

class Fila<T>{
    List<? super T> l;
    public Fila(List<? super T> li){
        l = li;
        l.clear();
    }
    public boolean empty(){
        return l.size()==0;
    }
    public void add(T n){
        l.add(n);
    }
    public T remove(){ //Remove primeiro da fila
        return (T) l.remove(0);
    }
    public T element(){ // Devolve primeiro
        ListIterator<? super T> li = l.listIterator();
        return (T) li.next();
    }
}
