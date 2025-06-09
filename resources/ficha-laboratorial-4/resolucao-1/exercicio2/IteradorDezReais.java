package exercicio2;

import java.util.Iterator;

public class IteradorDezReais implements Iterator<Double>{
    DezReais dr;
    int pos;

    public IteradorDezReais(DezReais dezReais) {
        dr = dezReais;
        pos = -1;
    }

    @Override
    public boolean hasNext() {
        return pos+1<dr.size();
    }

    @Override
    public Double next() {
        return dr.get(++pos);
    }
}
