package ficha4ed;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItDezReaisMutavel implements Iterator<Double> {
    int posUltimo = -1;
    boolean podeRemover = false;
    DezReaisMutavel dr;

    public ItDezReaisMutavel(DezReaisMutavel dr) {
        this.dr = dr;
    }

    public Double next() {
        if(posUltimo + 1 >= dr.size())
            throw new NoSuchElementException();
        podeRemover = true;
        return dr.get(++posUltimo);
    }

    public boolean hasNext() {
        return posUltimo + 1 < dr.size();
    }

    public void remove() {
        if(!podeRemover)
            throw new IllegalStateException();
        podeRemover = false;
        dr.remove(posUltimo);
        posUltimo--;
    }
}
