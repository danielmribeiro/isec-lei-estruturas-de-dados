package ficha4;



import java.util.*;

public class DezReais implements Iterable<Double>{
    private final int CAPACITY = 10;
    protected final Double [] tab = new Double[CAPACITY];
    protected int last = 0;
    
    public Double get(int pos){
        return tab[pos];
    }
    public boolean add(Double x){
        if(size() >= CAPACITY)
            throw new RuntimeException();
        tab[last++] = x;
        return true;
    }
    public int size(){
        return last;
    }
    @Override
    public Iterator <Double> iterator(){
        return new ItDezReais(this);
    }
};
