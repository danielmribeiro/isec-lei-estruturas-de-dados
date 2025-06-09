/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

import java.util.ArrayList;

/**
 *
 * @author nelio
 * @param <T>
 */
public class SortedPilha <T extends Comparable<? super T>> {
    Pilha<T> val = new Pilha<>(new ArrayList<T>());
    Pilha<T> min = new Pilha<>(new ArrayList<T>());
    
    public void push(T v){
        if(min.empty() || min.peek().compareTo(v) >= 0)
            min.push(v);
        val.push(v);
    }
    
    public T pop(){
        T ret = val.pop();
        if(ret.compareTo(min.peek()) == 0)
            min.pop();
        return ret;
    }
    
    public T getMin(){
        return min.peek();
    }
    
    public void show(){
        System.out.println("Valores: "); val.mostraLista();
        System.out.println("Minimos: "); min.mostraLista();
    }
}
