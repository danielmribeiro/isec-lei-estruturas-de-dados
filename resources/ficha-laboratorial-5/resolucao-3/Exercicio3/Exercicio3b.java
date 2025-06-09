package Exercicio3;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio3b {
    public static double testa(Pilha p, long sz){
        long startTime=System.nanoTime();
        for (int j = 0; j < sz; j++) {
            p.push(j);
        }
        for (int j = 0; j < sz; j++) {
            p.pop();
        }
        return (System.nanoTime()-startTime)/1000000.0;
    }

    public static void main(String[] args) {
        List llist = new LinkedList();
        long n,sz=50000,nruns=20;
        double tm;
        Pilha pll= new Pilha(llist);

        System.out.println("Tempo de execução médio "+nruns+" execuções(ms)");
        System.out.println("N | Linked list");

        for (int i = 1; i <=30 ; i++) {
            n=sz*i; // tamanho do pacote de dados a meter neste ciclo
            tm=0;
            for(int j=0;j<nruns;j++)
                tm+=testa(pll,n);
            System.out.printf("%d | %.2f\n",i,(float)(tm/nruns));
        }

        // A ArrayList é muito mais rápida que a LinkedList
        // Deve ser utilizada a ArrayList
    }
}

class Pilha<T>{
    List<? super T> l;

    public Pilha(List<? super T> li){
        l = li;
        l.clear();
    }

    public boolean empty(){
        return l.size()==0;
    }

    public T peek(){ //Devolve ultimo
        ListIterator<? super T> li = l.listIterator(l.size());
        return (T) li.previous();
    }

    public T pop(){ //Remove no fim
        return (T) l.remove(l.size()-1);
    }

    public void push(T n){ // Adiciona no fim
        l.add(n);
    }
}