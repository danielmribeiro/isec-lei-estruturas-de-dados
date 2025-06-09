package Exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class ArvoreIterator <T> implements Iterator<T>{

    private int size;
    private int point;
    private Arvore root;
    private List<T> inOrderList;

    public ArvoreIterator(Arvore root) {
        this.root = root;
        this.size = root.tamanho();
        this.point = 0;
        this.inOrderList = root.getOrdem();
    }
    
    @Override
    public boolean hasNext() {
        return (point < size);
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return inOrderList.get(point++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
}
