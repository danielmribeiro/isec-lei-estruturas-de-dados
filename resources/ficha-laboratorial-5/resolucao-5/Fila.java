package Ficha5_ed;

import java.util.List;
import java.util.ListIterator;

public class Fila<T> {
    List<? super T> l;
    public Fila(List<? super T> li) {
        l = li;
        l.clear();
    }

    public boolean empty() {
        return l.size() == 0;
    }

    public void add(T n) {
        l.add(n);
    }

    public T remove() {
        return (T) l.remove(0);
    }

    public T element() {
        ListIterator<? super T> li = l.listIterator();
        return (T) li.next();
    }
}
