package Exercicio6;

import java.util.Iterator;

public class DezReaisMutavel extends DezReais{
    int modificacoes = 0;

    @Override
    public Double get(int pos) {
        return tab[pos];
    }

    @Override
    public boolean add(Double x) {
        modificacoes++;
        if (quantidade == CAPACITY) {
            throw new RuntimeException();
        }
        tab[quantidade++] = x;
        return true;
    }

    @Override
    public int size() {
        return quantidade;
    }

    public void remove(int pos) {
        modificacoes++;
        for (int i = pos; i < size() - 1; i++) {
            tab[i] = tab[i + 1];
        }
        quantidade--;
    }

    @Override
    public Iterator<Double> iterator() {
        return new ItDezReaisMutavel(this);
    }

    public int getModificacoes() {
        return modificacoes;
    }
}
