package Ficha5_ed;

import java.util.ArrayList;

public class SortedPilha<T extends Comparable<? super T>> {
    Pilha <T> val = new Pilha<>(new ArrayList<>());
    Pilha <T> min = new Pilha<>(new ArrayList<>());

    public void push(T v) {
        if(min.empty() || min.peek().compareTo(v) >= 0)
            min.push(v);
        val.push(v);
    }

    public T pop() {
        T ret = val.pop();
        if(ret.compareTo(min.peek()) == 0)
            min.pop();
        return ret;
    }

    public T getMin() {
        return min.peek();
    }

    public void show() {
        System.out.println("Valores: ");
        val.show();
        System.out.println("Minimos: ");
        min.show();
    }
}

