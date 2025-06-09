package Exercicio8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercicio8 {
    public static <T extends Comparable<? super T> > T  maiorg(Iterable<T> d){
        Iterator<T> it=d.iterator();
        T m,temp;

        m= it.next();

        while (it.hasNext()) {
            temp=it.next();
            if(temp.compareTo(m)>0)
                m=temp;
        }
        return m;
    }

    public static void main(String[] args) {
        DezReais d = new DezReais();
        int j;
        for (j = 0; j < 10; j++) {
            d.add(j * 0.8);
        }
        DezReaisMutavel drm = new DezReaisMutavel();
        for (j = 0; j < 10; j++) {
            drm.add(j * 0.1);
        }

        System.out.println(maiorg(d));
        System.out.println(maiorg(drm));
    }
}

class DezReais implements Iterable<Double>{
    protected final int CAPACITY = 10;
    protected Double [] tab = new Double[CAPACITY]; //Poderia ser lista
    protected int last =0; // tamanho da lista / estrutura de dados

    public Double get(int pos){
        return tab[pos];
    }

    public int size(){
        return last;
    }

    public boolean add(Double x){
        if(size()>= CAPACITY)
            throw new RuntimeException();
        tab[last++]=x;
        return true;
    }

    public Iterator<Double> iterator(){
        return new ItDezReais(this);
    }

}

class ItDezReais implements Iterator<Double>{
    int posUltimo=-1; //indice ultimo valor devolvido
    DezReais dr;

    public ItDezReais(DezReais dr){
        this.dr=dr;
    }

    public Double next(){
        if(posUltimo+1 >= dr.size())
            throw new NoSuchElementException();

        return dr.get(++posUltimo);
    }

    public boolean hasNext(){
        return posUltimo+1 < dr.size();
    }
}

class DezReaisMutavel extends DezReais {
    private int modificacoes = 0;

    void remove(int pos){
        int j;
        modificacoes++;
        for(j=pos;j<last-1;j++)
            tab[j]=tab[j+1];
        last--;
    }

    public void acrescenta(Double valor){
        modificacoes++;
        add(valor);
    }

    public int getModificacoes(){
        return modificacoes;
    }

}