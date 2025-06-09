package Exercicio6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class Exercicio6 {
    public static <T> void revPrint(Collection<T> col){
        Pilha <T> pilha = new Pilha <>(new ArrayList<T>());

        for (T valor : col){
            pilha.push(valor);
        }
        while(!pilha.empty()){
            System.out.println(pilha.pop());
        }
    }

    public static void main(String[] args) {
        List alist = new ArrayList();
        alist.add("Ana");
        alist.add("João");
        alist.add("Mia");
        alist.add("Zé");

        System.out.println(alist);
        revPrint(alist);
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