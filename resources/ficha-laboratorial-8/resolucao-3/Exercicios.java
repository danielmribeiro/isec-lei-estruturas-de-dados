package Exercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Exercicios {
    public static void main(String [] args){
        Arvore<String> tree = new Arvore<>();
        tree.insere("D");
        tree.insere("B");
        tree.insere("E");
        tree.insere("A");
        tree.insere("C");
        tree.insere("F");
        tree.insere("H");
        tree.insere("G");
        System.out.println("\n>>>> In Order: \n");
        tree.imprimeOrdem();
        System.out.println("\n>>>> By Levels: \n");
        tree.imprimeNiveis();
        
        
        Arvore<String> tree2 = new Arvore<> ( 
            new Comparator<String>(){
                public int compare(String s1, String s2){
                    return s1.length() - s2.length();
            }
        });
        
        tree2.insere("D");
        tree2.insere("BB");
        tree2.insere("EEE");
        tree2.insere("AAAA");
        tree2.insere("CCCCC");
        tree2.insere("FFFFFF");
        tree2.insere("HHHHHHH");
        tree2.insere("GGGGGGGG");
        
        System.out.println("\n>>>> In Order: \n");
        tree2.imprimeOrdem();
        System.out.println("\n>>>> By Levels: \n");
        tree2.imprimeNiveis();
//    
//        // 6
//        List<Integer> array = new ArrayList<>();
//        for(int i = 0; i < 1000000; i++)
//            array.add(i);
//        
//        Collections.shuffle(array);
//        
//        Arvore<Integer> arvore = new Arvore<>();
//         
//        for(int i = 0; i < array.size(); i++)
//            arvore.insere(array.get(i));
//        
//        Arvore<Integer> tree = new Arvore<>();
//        tree.insere(1);
//        tree.insere(15);
//        tree.insere(10);
//        tree.insere(12);
//        tree.insere(11);
//        tree.insere(13);
//        tree.insere(25);
//        tree.insere(20);
//        tree.insere(50);
//        
//        Arvore<Integer> tree2 = new Arvore<>();
//        tree2.insere(1);
//        tree2.insere(15);
//        tree2.insere(10);
//        tree2.insere(12);
//        tree2.insere(11);
//        tree2.insere(13);
//        tree2.insere(25);
//        tree2.insere(20);
//        tree2.insere(50);
//        
//        Arvore<Integer> tree3 = new Arvore<>();
//        tree3.insere(1);
//        tree3.insere(15);
//        tree3.insere(10);
//        tree3.insere(12);
//        tree3.insere(11);
//        tree3.insere(13);
//        tree3.insere(25);
//        tree3.insere(20);
//        tree3.insere(51);
//
//        //System.out.println("Profundidade: " + tree.profundidade());
//        
//        //tree.imprimeOrdem();
//        
//        //tree.removeNodeOneChild();
//        //tree.removeNodeLeafs();
//        
//        //System.out.println("valor maior que 15: " + tree.nextValNode(15));
//        //System.out.println("valor maior que 14: " + tree.nextValNode(14));
//        //System.out.println("valor maior que 16: " + tree.nextValNode(16));
//        //System.out.println("valor maior que 26: " + tree.nextValNode(26));
//    
//        System.out.println("Ã�rvores iguais \"tree\" a \"tree2\": " + tree.isEquals(tree2));
//        System.out.println("Ã�rvores iguais \"tree2\" a \"tree3\": " + tree2.isEquals(tree3));
//        
//        tree.imprimeOrdem();
//        
//        Iterator este = tree.iterator();
//        
//        while(este.hasNext()){
//            System.out.println("Iterador: " + este.next());
//        }
        
//Ficha 8
//ex1,2
//        Arvore<Integer> tree = new Arvore<>();
//        tree.insere(20);
//        tree.insere(15);
//        tree.insere(10);
//        tree.insere(17);
//        tree.insere(30);
//        tree.insere(25);
//        tree.insere(35);
//        
//        tree.imprimePorNiveis();
//        
//        tree.rodaNoDireito();
//        
//        tree.imprimePorNiveis();
//        
//        tree.rodaNoEsquerdo();
//        
//        tree.imprimePorNiveis();

//ex3/4
//        Arvore<String> tree = new Arvore<>();
//        tree.insere("D");
//        tree.insere("B");
//        tree.insere("E");
//        tree.insere("A");
//        tree.insere("C");
//        
//        tree.imprimePorNiveis();
//        
//        tree.rodaDuplaDireita();
//        
//        tree.imprimePorNiveis();

//ex5
//        System.out.println("Profundidade: " + tree.profundidade());

//ex6
        




    }    
}
