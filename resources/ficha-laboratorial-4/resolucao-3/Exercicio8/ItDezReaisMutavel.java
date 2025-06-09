package Exercicio8;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItDezReaisMutavel implements Iterator<Double>{
    int posUltimo = -1; //Indice do ultimo valor devolvido
    DezReaisMutavel dr;
    boolean podeRemover = false;
    int modificacoesConhecidas = 0;

    ItDezReaisMutavel(DezReaisMutavel dr) {
        this.dr = dr;
        modificacoesConhecidas = dr.getModificacoes();
    }

    @Override
    public boolean hasNext() {
        verificaModificacoes();
        return posUltimo + 1 < dr.size();
    }

    @Override
    public Double next() {
        verificaModificacoes();

        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        podeRemover = true;
        return dr.get(++posUltimo);
    }

    public void add(Double x) {
        modificacoesConhecidas++;
        dr.add(x);
    }

    @Override
    public void remove() {
        if (posUltimo == -1) {
            throw new IllegalStateException();
        }

        dr.remove(posUltimo);
        podeRemover = false;

        modificacoesConhecidas++;
    }

    public void verificaModificacoes() {
        if (modificacoesConhecidas != dr.getModificacoes()) {
            throw new ConcurrentModificationException();
        }
    }

    public int nextPositiveIndex(int from) {
        int i;

        if (from >= dr.size()) {
            return -1;
        }
        
        while(dr.get(from) < 0){
            if(++from >= dr.size()) {
                return -1;
            }
        }
        return from;
    }
}
