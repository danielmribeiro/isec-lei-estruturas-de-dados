/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6;

/**
 *
 * @author nelio
 */
public class Ficha6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorImpressoras gi1 = new GestorImpressoras();
        
        Impressora i1 = new Impressora("L1.1", "HP", "H872P154", "2.3", "1.7.8.2", 12);
        Impressora i2 = new Impressora("L1.2", "Xiaomi", "P567", "4.7.6", "1.3.5.2", 12);
        Impressora i3 = new Impressora("L2.1", "KSTE", "NIAOM5", "2.9", "3.1.2", 10);
        
        gi1.addImpressora(i1);
        gi1.addImpressora(i2);
        gi1.addImpressora(i3);
        
        Impressora imp = gi1.getImpressora("L1.1");
        System.out.println("Impressora: " + imp.show());
        
        gi1.getImpressora(i2.getNome());
        
        System.out.println("Impressoras: \n" + gi1.getNomesImpressoras());
        
        System.out.println("Existe impressora L1.2?: " + gi1.existeImpressora("L1.2"));
        gi1.removeImpressora("L1.2");
        System.out.println("Existe impressora L1.2?: " + gi1.existeImpressora("L1.2"));
        
        PriorityQueueTest pqt = new PriorityQueueTest();
        System.out.println("---------------------\nPriorityQueueTest:");
        pqt.testPQT();
        System.out.println("---------------------\n");
        
        Trabalho t1 = new Trabalho("pdf", 1, 10);
        Trabalho t2 = new Trabalho("word", 2, 4);
        Trabalho t3 = new Trabalho("ED", 1, 100);
        gi1.imprime(t1);
        gi1.imprime(t2);
        gi1.imprime(t3);
        
        System.out.println(gi1.mostraImpressoras());
        
    }
    
}
