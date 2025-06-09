/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author nelio
 */
public class PriorityQueueTest {
    
    public void testPQT(){
        PriorityQueue<String> q = new PriorityQueue<String>();
        q.add("C"); q.add("C++"); q.add("Java"); q.add("Python");
        
        System.out.println("Elemento a cabeca: " + q.peek());
        
        System.out.println("Toda a fila: ");
        Iterator itr = q.iterator();
        while(itr.hasNext()) System.out.println(itr.next());
        
        String e = q.poll();    // atende o primeiro da fila
        System.out.println("Atendido: " + e);
        
        q.remove("Java");
        
        System.out.println("Toda a fila:");
        Iterator<String> itr2 = q.iterator();
        while(itr.hasNext()) System.out.println(itr2.next());
        
        boolean b = q.contains("C");
        System.out.println("Fila em C? " + b);
    }
}
