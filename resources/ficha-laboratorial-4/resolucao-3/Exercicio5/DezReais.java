package Exercicio5;


import java.util.Iterator;

public class DezReais implements Iterable<Double> {

    protected final int CAPACITY = 10;
    protected double[] tab = new double[CAPACITY];
    protected int quantidade = 0;

    public Double get(int pos) {
        return tab[pos];
    }

    public boolean add(Double x) {
        if (quantidade == CAPACITY) {
            throw new RuntimeException();
        }

        tab[quantidade++] = x;
        return true;
    }

    public int size() {
        return quantidade;
    }
    
    @Override
    public String toString() {
        for (int i = 0; i < tab.length; i++) {
            System.out.print("["+tab[i]+"]");
        }
        return "";
    }
    
    @Override
    public Iterator<Double> iterator() {
        return new ItDezReais(this);
    }

}
