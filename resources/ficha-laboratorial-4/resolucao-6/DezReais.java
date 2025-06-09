package ficha4ed;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class DezReais implements Iterable<Double> {
    protected final int CAPACITY = 10;
    protected Double [] tab = new Double[CAPACITY];
    protected int last = 0;

    public Double get(int pos) {
        return tab[pos];
    }

    public int size() {
        return last;
    }

    public boolean add(Double x) {
        if(size() >= CAPACITY )
            throw new RuntimeException();
        tab[last++] = x;
        return true;
    }

    @Override
    public Iterator<Double> iterator() {
        return new ItDezReais(this);
    }
}

class ItDezReais implements Iterator<Double> {
    int posUltimo = -1;
    DezReais dr;

    public ItDezReais(DezReais dr) {
        this.dr = dr;
    }

    @Override
    public boolean hasNext() {
        return posUltimo + 1 < dr.size();
    }

    @Override
    public Double next() {
        if(posUltimo + 1 > dr.size())
            throw new NoSuchElementException();
        return dr.get(++posUltimo);
    }
}

