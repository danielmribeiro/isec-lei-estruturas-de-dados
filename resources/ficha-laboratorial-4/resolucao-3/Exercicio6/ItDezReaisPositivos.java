package Exercicio6;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItDezReaisPositivos implements Iterator<Double> {
    int posUltimo = -1;
    boolean podeRemover = false;
    DezReaisMutavel dr;
    int modificacoesConhecidas = 0;

    public ItDezReaisPositivos(DezReaisMutavel dr) {
        this.dr = dr;
        modificacoesConhecidas = dr.getModificacoes();
    }

    public int nextPositivoIndex(int from) {
        int j;

        if (from >= dr.size())
            return -1;
        while (dr.get(from) < 0)
            if (++from >= dr.size())
                return -1;
        return from;
    }

    public void verificaModificacao() {
        if (modificacoesConhecidas != dr.getModificacoes())
            throw new ConcurrentModificationException();
    }

    @Override
    public Double next() {
        if (posUltimo + 1 > dr.size())
            throw new NoSuchElementException();
        podeRemover = true;
        return dr.get(++posUltimo);
    }

    @Override
    public boolean hasNext() {
        return posUltimo + 1 < dr.size();
    }
}
