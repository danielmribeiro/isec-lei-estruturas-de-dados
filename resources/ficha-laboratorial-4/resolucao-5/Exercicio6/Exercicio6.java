package Exercicio6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercicio6 {
    public static void main(String[] args) {
        DezReaisMutavel drm = new DezReaisMutavel();
        ItDezReaisPositivos idrm = new ItDezReaisPositivos(drm);
        int j=0;

        for (j = 0; j < 10; j++) {
            drm.add(j * 1.0-7.0);
        }
        j=0;

        while (idrm.hasNext())
            System.out.println((j++) + ": " + idrm.next());
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
class ItDezReais implements Iterator<Double> {
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

    public Iterator<Double> iterator(){
        return new ItDezReaisPositivos(this);
    }

}

class ItDezReaisPositivos implements Iterator<Double> {
    int posUltimo=-1; //pos do ultimo valor que foi devolvido
    boolean podeRemover=false;
    int modificacoesConhecidas; //numero de modificações esperado/conhecido pelo iterador
    DezReaisMutavel dr;

    public ItDezReaisPositivos(DezReaisMutavel dr){
        this.dr=dr;
        modificacoesConhecidas = dr.getModificacoes();
    }

    private int nextPositiveIndex(int from){ // Método auxiliar para o next()
        if(from>=dr.size())
            return -1;  //Devolve -1 se não existe
        while(dr.get(from)<0)
            if(++from>=dr.size())
                return -1; //Devolve -1 se não existe
        return from;
    }

    public Double next(){
        posUltimo= nextPositiveIndex(++posUltimo);
        return dr.get(posUltimo);
    }

    public boolean hasNext(){
        return nextPositiveIndex(posUltimo+1)>=0;
    }
}
