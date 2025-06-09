package Exercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArvoreIterator<T> implements Iterator {

    List<Node<T>> array = new ArrayList<Node<T>>();
    int lastPos = -1;

    public ArvoreIterator(ArvoreBinaria ab) {
        AddToArray(ab.getRaiz());
    }

    private void AddToArray(Node<T> subARaiz) {
        if (subARaiz == null) {
            return;
        }

        AddToArray(subARaiz.getLeft());
        array.add(subARaiz);
        AddToArray(subARaiz.getRight());
    }

    @Override
    public boolean hasNext() {
        return lastPos + 1 < array.size();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return array.get(lastPos + 1);
    }

}
