/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

/**
 *
 * @author nelio
 */
public class Ficha8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> bt1 = new BinaryTree<>();
        
        bt1.insere(20);
        bt1.insere(15);
        bt1.insere(30);
        bt1.insere(10);
        bt1.insere(17);
        bt1.insere(25);
        bt1.insere(35);
        
        bt1.imprimePorNiveis();
        
        bt1.rodaArvoreEsq();
        
        bt1.imprimePorNiveis();
    }
    
}
