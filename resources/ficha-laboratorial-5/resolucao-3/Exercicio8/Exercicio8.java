package Exercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Exercicio8 {
    public static void main(String[] args) {
        List alist = new ArrayList();
        alist.add("AA");
        alist.add("BB");
        alist.add("CC");
        alist.add("DD");
        alist.add("EE");

        System.out.println(alist);
    }
}

class Pilha<T>{
    List<? super T> l;

    public Pilha(List<? super T> li){
        l = li;
        l.clear();
    }

    public boolean empty(){
        return l.size()==0;
    }

    public T peek(){ //Devolve ultimo
        ListIterator<? super T> li = l.listIterator(l.size());
        return (T) li.previous();
    }

    public T pop(){ //Remove no fim
        return (T) l.remove(l.size()-1);
    }

    public void push(T n){ // Adiciona no fim
        l.add(n);
    }

    public void show(){
        ListIterator<? super T> i = l.listIterator();
        while(i.hasNext())
            System.out.println(i.next());
    }
}

class SortedPilha<T extends Comparable<? super T>>{
    Pilha <T> val = new Pilha<>(new ArrayList<T>());
    Pilha <T> min = new Pilha<>(new ArrayList<T>());

    public void push(T v){ //O(1)
        if(min.empty() || min.peek().compareTo(v)>=0)
            min.push(v); //coloca novo minimo no topo
        val.push(v);
    }

    public T pop(){ //O(1)
        T ret=val.pop();
        if(ret.compareTo(min.peek())==0)    //se remover minimo, atualizar pilha de minimos
            min.pop();
        return ret;
    }

    public T getMin(){
        return min.peek();
    } //O(1)

    public void show(){
        System.out.println("Valores: ");
        val.show();
        System.out.println("Minimos: ");
        min.show();
    }
}
