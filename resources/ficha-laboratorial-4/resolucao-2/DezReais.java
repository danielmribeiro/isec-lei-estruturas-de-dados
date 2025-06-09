package ficha4;

import java.util.Iterator;
/**
 *
 * @author nelio
 */
public class DezReais implements Iterable<Double> {

    final int CAPACITY = 10;
    Double[] numbers = new Double[CAPACITY];
    int last = 0;   //tamanho da lista

    public Double get(int pos) {
        return numbers[pos];
    }

    public boolean add(Double num) {
        if(size() >= CAPACITY) throw new RuntimeException("Array exeded the limit! (" + CAPACITY + ")");
        numbers[last++] = num;
        return true;
    }
    
    public int size(){
        return last;
    }

    @Override
    public Iterator<Double> iterator() {
        return new ItDezReais(this);
    }

}
