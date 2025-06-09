package Exercicio5;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercicio5 {
    public static void main(String[] args) {
        DezReaisMutavel drm = new DezReaisMutavel();
        ItDezReaisMutavel idrm = new ItDezReaisMutavel(drm);
        int j=0;

        for (j = 0; j < 10; j++) {
            drm.add(j * 0.1+5.0);
        }
        j=0; Double dbl;

        while (idrm.hasNext() && (dbl=idrm.next())<5.4)
            System.out.println((j++)+": ultimo: " + dbl);

        idrm.remove();

        ItDezReaisMutavel idrm2 = new ItDezReaisMutavel(drm);
        j = 0;
        drm.acrescenta(10.0); //exception
        while (idrm2.hasNext())
            System.out.println((j++) + ": Sem 5.4 " + idrm2.next());
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

class DezReaisMutavel extends DezReais{
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
        return new ItDezReaisMutavel(this);
    }

}

class ItDezReaisMutavel implements Iterator<Double>{
    int posUltimo=-1; //pos do ultimo valor
    boolean podeRemover=false;
    DezReaisMutavel dr;
    int modificacoesConhecidas=0;

    public ItDezReaisMutavel(DezReaisMutavel dr){
        this.dr=dr;
        modificacoesConhecidas = dr.getModificacoes();
    }

    public void verificaModificacao(){ //caso a estrutura tenha sido modificada sem o conhecimento do iterador, gera exceção
        if(modificacoesConhecidas!=dr.getModificacoes())
            throw new ConcurrentModificationException();
    }

    public Double next(){
        verificaModificacao();
        if(posUltimo+1 >= dr.size())
            throw new NoSuchElementException();

        podeRemover=true;
        return dr.get(++posUltimo);
    }

    public boolean hasNext(){
        verificaModificacao();
        return posUltimo+1 < dr.size();
    }

    public void remove(){
        verificaModificacao();
        if(!podeRemover)
            throw new IllegalStateException();
        podeRemover=false; //após remover o valor, não é possivel remover outra vez
        dr.remove(posUltimo);
        posUltimo--;
        modificacoesConhecidas++;
    }
}
