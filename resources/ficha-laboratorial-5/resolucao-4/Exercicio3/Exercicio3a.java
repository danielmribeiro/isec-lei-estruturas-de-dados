package Exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio3a {
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
        List alist = new ArrayList();
        long n,sz=50000,nruns=20;
        double tm;
        Pilha pal= new Pilha(alist);

        System.out.println("Tempo de execução médio "+nruns+" execuções(ms)");
        System.out.println("N | ArrayList");

        for (int i = 1; i <=30 ; i++) {
            n=sz*i; // tamanho do pacote de dados a meter neste ciclo
            tm=0;
            for(int j=0;j<nruns;j++)
                tm+=testa(pal,n);
            System.out.printf("%d | %9.2f\n",i,(float)(tm/nruns));
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