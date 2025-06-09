/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author nelio
 * @param <T>
 */
public class Pilha <T>{
    List<? super T> l;
    
    public Pilha(List<? super T> li){
        l = li;
        //l.clear();
    }
    
    public boolean empty(){
        return l.isEmpty();
    }
    
    public T peek(){
        ListIterator <? super T>li = l.listIterator(l.size());
        return (T) li.previous();
        //return (T) l.get(l.size()-1);     // processo mais demorado
    }
    
    public T pop(){
        ListIterator <? super T>li = l.listIterator(l.size());
        T aux = (T)li.previous();
        li.remove();
        return aux;
    }
    
    public boolean push(T value){
        return l.add(value);
    }
    
    // remove primeiro elemento
    public boolean remove(){
        l.remove(0);
        return true;
    }
    
    // devolve primeiro elemento
    public T element(){
        ListIterator <? super T>li = l.listIterator();
        return (T) li.next();
    }
    
    public void mostraLista(){
        int i = 0;
        ListIterator<? super T> li = l.listIterator();
        while(li.hasNext()){
            System.out.println("[" + (++i) + "]: " + li.next());
        }
    }
    
    public boolean inverteLista(){
        List<? super T> aux = new ArrayList(l);
        l.clear();
        ListIterator<? super T> it = aux.listIterator(aux.size());
        while (it.hasPrevious()) {
            l.add((T) it.previous());
        }
        return true;
    }
    
    public boolean removePares(){
        ListIterator<? super T> li = l.listIterator();
        while(li.hasNext()){
            li.next();
            if(li.hasNext()){
                li.next();
                li.remove();
            }
        }
        return true;
        /*
        b)
        List<T> i = new ArrayList<>(l.size()/2 + 1); // garante a capacidade necessaria
        ListIterator iti = l.listIterator();
        
        while(iti.hasNext()){
            i.add((T)iti.next());   // O(1) para AL e LL - copia elementos em posições impares
            if(iti.hasNext()) iti.next();   // O(1) para AL e LL
        }
        
        alist.clear();  // O(1) para AL e LL
        alist.addAll(i);    // O(N) para AL e LL
        */
    }
}
