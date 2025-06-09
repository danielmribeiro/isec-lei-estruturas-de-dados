package Ficha5_ed;

import java.util.List;
import java.util.ListIterator;

public class Pilha<T> {
    List<? super T> l;

    public Pilha(List<? super T> li) {
        l = li;
        l.clear();
    }

    public boolean empty() {
        return l.size() == 0;
    }

    public T peek() {
        ListIterator<? super T> li = l.listIterator(l.size());
        return (T) li.previous();
    }

    public T pop() {
        return (T) l.remove(l.size() - 1);
    }

    public void push(T n) {
        l.add(n);
    }

    public void show() {
        ListIterator<? super T> i = l.listIterator();
        while(i.hasNext())
            System.out.println(i.next());
    }
}
