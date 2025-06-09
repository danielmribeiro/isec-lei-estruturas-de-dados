package exercicio2;

import exercicio2.GestorImpressora;
import exercicio2.Impressora;

public class Main {
    public static void main(String[] args) {
        Impressora i1 = new Impressora("cad",32,"HP","180ti", "drv", "32");
        Impressora i2 = new Impressora("caf",32,"HP","180ti", "drv", "32");
        Impressora i3 = new Impressora("cag",32,"HP","180ti", "drv", "32");
        Impressora i4 = new Impressora("cah",32,"HP","180ti", "drv", "32");
        GestorImpressora gi = new GestorImpressora();
        gi.acrescentaImpressora(i1);
        gi.acrescentaImpressora(i2);
        gi.acrescentaImpressora(i3);
        gi.acrescentaImpressora(i4);
        Trabalho t1 = new Trabalho("T1", 0,23);
        Trabalho t2 = new Trabalho("T2", 1,5);
        Trabalho t3 = new Trabalho("T3", 2,9);
        gi.mostraFila();
        gi.imprime(t1);
        gi.mostraFila();
        gi.imprime(t3);
        gi.mostraFila();
        gi.imprime(t2);
        gi.mostraFila();
    }
}
