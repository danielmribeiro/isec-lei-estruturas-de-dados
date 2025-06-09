package exercicio4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static double testa(Fila f, long sz) {
        long startTime = System.nanoTime();

        for (int i = 0; i < sz; i++) {
            f.add("a");
        }

        for (int i = 0; i < sz; i++) {
            f.remove();
        }

        return (System.nanoTime() - startTime) / 1000000.0;
    }

    public static void main(String[] args) {
        List aList = new ArrayList();
        List lList = new LinkedList();
        long n, sz = 100000, nruns = 20;
        double tm;
        Fila fAL = new Fila(aList);
        Fila fLL = new Fila(lList);

        System.out.println("Tempo de execucao medio para " + nruns + " execucoes (ms):");
        System.out.println("N|ArrayList|LinkedList");

        for (int i = 1; i <= 7; i++) {
            n = sz * i;
            tm = 0;

            for (int j = 0; j < nruns; j++) {
                tm += testa(fAL, sz);
            }
            System.out.printf("%d|%9.2f|", i, (float) tm / nruns);

            tm = 0;
            for (int j = 0; j < nruns; j++) {
                tm += testa(fLL, sz);
            }
            System.out.printf("%.2f\n", tm / nruns);
        }
    }
}
