package exercicio8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorDezReais implements Iterator<Double>{
    DezReais dr;
    int pos;

    public IteradorDezReais(DezReais dezReais) {
        dr=dezReais;
        pos=-1;
    }

    @Override
    public boolean hasNext() {
        return pos+1<dr.size();
    }

    @Override
    public Double next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return dr.get(++pos);
    }
}
