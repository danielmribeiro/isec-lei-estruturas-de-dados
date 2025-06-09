/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author nelio
 */
public class GestorImpressoras {

    HashMap<String, Impressora> list;
    
    PriorityQueue<Impressora> pqi = new PriorityQueue<Impressora>(new Comparator<Impressora>(){
        @Override
        public int compare(Impressora o1, Impressora o2) {
            return o1.contaTrabalhos() - o2.contaTrabalhos();
        }
    });

    public GestorImpressoras() {
        list = new HashMap<>();
    }

    public Impressora getImpressora(String nome) {
        if (list.isEmpty())
            return null;

        return (Impressora) list.get(nome);
    }// O(1)

    public Set<String> getNomesImpressoras() {
        if (list.isEmpty())
            return null;

        return list.keySet();
    }// O(1)

    public boolean addImpressora(Impressora i) {
        if (i == null)
            return false;

        list.put(i.getNome(), i);
        pqi.add(i);
        return true;
    }

    public Impressora removeImpressora(String i) {
        if(list.isEmpty())
            return null;
        
        return list.remove(i);
    }
    
    public boolean existeImpressora(String i){
        if(list.isEmpty())
            return false;
        
        return list.containsKey(i);
    }
    
    public boolean enviaTrabalho(String i, Trabalho t){
        return list.get(i).adicionaTrabalho(t);
    }
    
    public void imprime(Trabalho t){
        pqi.poll().adicionaTrabalho(t);
    }
    
    public String mostraImpressoras(){
        String str = "";
        Iterator it = pqi.iterator();
        Impressora imp;
        
        while(it.hasNext()){
            imp = (Impressora)it.next();
            str += imp.show();
        }
        return str;
    }
}
