package exercicio3a;

import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args){

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
}
