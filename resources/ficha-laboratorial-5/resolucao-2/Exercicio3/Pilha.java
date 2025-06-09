package Exercicio3;

import java.util.List;
import java.util.ListIterator;

public class Pilha<T> {
    private List<? super T> list;

    public Pilha(List<T> list) {
        this.list = list;
    }
    
    public boolean empty() {
        return (list.isEmpty());
    }

    public T peek() {
        ListIterator it = list.listIterator(list.size());

        return (T) it.previous();
    }

    public T pop() {
        return (T) list.remove(list.size() - 1);
    }

    public void push(T e) {
        list.add(e);
    }
    
    public void show() {
        System.out.println(list);
    }
}
