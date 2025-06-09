/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author nelio
 */
public class Ficha7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinaryTree<Integer> bti = new BinaryTree<>();
        bti.insere(1);
        bti.insere(2);
        bti.insere(3);
        bti.insere(4);
        
        bti.imprimeNiveis();
        
        System.out.println(bti.profundidade());
        
        
        // ex4
        Comparator c = new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    
                return s2.length()-s1.length();
            }
        };
        BinaryTree<String> bts = new BinaryTree<>();
       
        bts.insere("D");
        bts.insere("BB");
        bts.insere("EEE");
        bts.insere("AAAA");
        bts.insere("CCCCC");
        bts.insere("FFFFFF");
        bts.insere("GGGGGGG");
             
        System.out.println(">>> Inorder:");
        bts.imprimeOrdem();
        
        bts.imprimeNiveis();
        
        // ex6
        BinaryTree<Integer> it = new BinaryTree<>();
        ArrayList<Integer> al = new ArrayList<>();
        int i, a, b, len = 1000000,hl;
        Integer temp;
        Random r = new Random();
        
        for(i=0;i<len;i++) al.add(i);
        
        hl = len/2;
        for(i=0;i<hl;i++){
            a = r.nextInt(len);
            b = r.nextInt(len);
            temp = al.get(a);
            al.set(a, al.get(b));
            al.set(b, temp);
        }
        
        Iterator ai = al.iterator();
        while(ai.hasNext()) it.insere( (Integer)ai.next());
        
        System.out.println("A arvore tem " + it.tamanho() + " elementos, em " + it.profundidade() + " niveis.");
        System.out.println("Devia ter estes niveis: " + Math.log(len)/Math.log(2));
        
        // ex7
        BinaryTree<Integer> bti2 = new BinaryTree<>();
       
        bti2.insere(4);
        bti2.insere(2);
        bti2.insere(10);
        bti2.insere(13);
        bti2.insere(67);
        bti2.insere(100);
        bti2.insere(22222);
        
        bti2.imprimePorNiveis();
        
        bti2.remove(22222);
        
        bti2.imprimePorNiveis();
        
        //  ex11
        BinaryTree<Integer> bti3 = new BinaryTree<>();
       
        bti3.insere(4);
        bti3.insere(2);
        bti3.insere(10);
        bti3.insere(13);
        bti3.insere(67);
        bti3.insere(100);
        
        
        bti3.imprimePorNiveis();
        
        System.out.println("bti2 == bti3? " + bti3.compareTo(bti2));
        
        bti3.insere(22222);
        
        System.out.println("bti2 == bti3? " + bti3.compareTo(bti2));
        
    }
    
}
