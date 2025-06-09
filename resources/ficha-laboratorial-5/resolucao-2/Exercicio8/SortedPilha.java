package Exercicio8;

import java.util.ArrayList;
import java.util.List;

public class SortedPilha<T extends Comparable<? super T>> {

    Pilha<T> val = new Pilha<>(new ArrayList<T>());
    Pilha<T> min = new Pilha<>(new ArrayList<T>());

    private List<? super T> list;

    public SortedPilha(List<T> list) {
        this.list = list;
    }
    
    public void push(T v) {
        if (min.empty() || min.peek().compareTo(v) >= 0) {
            min.push(v); //Coloca o minimo do topo do min
        }
            val.push(v);
    }

    public T pop() {    //O(1)
        T ret = val.pop();
        if (ret.compareTo(min.peek()) == 0) {//Se remover o minimo, atualizar pilhas de minimos
            min.pop();
        }
        return ret;
    }
    
    public T getMin() { //O(1)
        return min.peek();
    }
    
    public void show() {
        System.out.println("Valores: ");
        val.show();
        System.out.println("Minimos: ");
        min.show();
    }
}
