package ficha6;

public class Main {
    public static void main(String[] args) {
        GestorImpressoras gi = new GestorImpressoras();
        Impressora i1 = new Impressora("nome1",1,"marca1","modelo1","driver1","versao1");
        Impressora i2 = new Impressora("nome2",2,"marca2","modelo2","driver2","versao2");
        Impressora i3 = new Impressora("nome3",3,"marca3","modelo3","driver3","versao3");
        Impressora i4 = new Impressora("nome4",4,"marca4","modelo4","driver4","versao4");
        gi.acrescentaImpressora(i1);
        gi.acrescentaImpressora(i2);
        gi.acrescentaImpressora(i4);
        System.out.println(gi.getImpressora("nome1"));
        System.out.println(gi.getImpressora("nome3"));
        System.out.println(gi.getImpressora("nome4"));
        gi.removeImpressora("nome1");
        System.out.println(gi.getImpressora("nome1"));
        System.out.println(gi.existeImpressora("nome1"));
        System.out.println(gi.existeImpressora("nome4"));

        System.out.println("\n\n\n\n");

        Trabalho t1 = new Trabalho("nomeFicheiro1",0, 100);
        Trabalho t2 = new Trabalho("nomeFicheiro2",50, 100);
        Trabalho t3 = new Trabalho("nomeFicheiro3",25, 100);
        Trabalho t4 = new Trabalho("nomeFicheiro4",10, 12);
        Trabalho t5 = new Trabalho("nomeFicheiro5",10, 90);

        gi.mostraFila();
        i2.enviaTrabalho(t1);
        gi.mostraFila();
        gi.imprime(i2);
        gi.mostraFila();
        i2.enviaTrabalho(t2);
        gi.mostraFila();
        i2.enviaTrabalho(t3);
        i2.enviaTrabalho(t4);
        i2.enviaTrabalho(t5);
        gi.mostraFila();
    }
}
