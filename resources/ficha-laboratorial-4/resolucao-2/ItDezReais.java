package ficha4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author nelio
 */
class ItDezReais implements Iterator<Double> {

    int posUltimo = -1;
    DezReais dr = new DezReais();

    public ItDezReais(DezReais dr) {
        this.dr = dr;
    }

    @Override
    public boolean hasNext() {
        if (posUltimo + 1 > dr.size())
            throw new NoSuchElementException();
        return posUltimo + 1 < dr.size();
    }

    @Override
    public Double next() {
        return dr.get(++posUltimo);
    }
}
