package Exercicio3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exercicio3 {
    
    public static double testa(Pilha p, long sz) {
        long startTime = System.nanoTime();

        for (int i = 0; i < sz; i++) {
            p.push("a");
        }

        for (int i = 0; i < sz; i++) {
            p.pop();
        }

        return (System.nanoTime() - startTime) / 1000000.0;
    }
    
    public static void main(String[] args) {
        List aList = new ArrayList();
        List lList = new LinkedList();
        long n, sz = 20000000, nruns = 20;
        double tm;
        Pilha pAL = new Pilha(aList);
        Pilha pLL = new Pilha(lList);

        System.out.println("Tempo de execucao medio para " + nruns + " execucoes (ms):");
        System.out.println("N|ArrayList|LinkedList");

        for (int i = 1; i <= 7; i++) {
            n = sz * i;
            tm = 0;

            for (int j = 0; j < nruns; j++) {
                tm += testa(pAL, sz);
            }
            System.out.printf("%d|%9.2f|", i, (float) tm / nruns);

            tm = 0;
            for (int j = 0; j < nruns; j++) {
                tm += testa(pLL, sz);
            }
            System.out.printf("%.2f\n", tm / nruns);
        }
    }
    
    // A ArrayList é muito mais rápida que a LinkedList
    // Deve ser utilizada a ArrayList
}
