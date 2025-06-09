package ficha4ed;

import java.util.Iterator;

public class DezReaisMutavel extends DezReais{

    void remove(int pos) {
        int j;
        for(j = pos; j < last - 1; j++)
            tab[j] = tab[j + 1];
        last--;
    }

    public Iterator<Double> iterator() {
        return new ItDezReaisMutavel(this);
    }
}
