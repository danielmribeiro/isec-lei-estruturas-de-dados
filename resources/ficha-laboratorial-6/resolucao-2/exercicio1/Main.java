package exercicio1;

public class Main {
    public static void main(String[] args) {
        GestorImpressoras gi = new GestorImpressoras();
        Impressora i1 = new Impressora("Nome1",1,"Marca1","modelo1","driver1","versao1");
        Impressora i2 = new Impressora("Nome2",1,"Marca2","modelo2","driver2","versao2");
        Impressora i3 = new Impressora("Nome3",1,"Marca3","modelo3","driver3","versao3");
        Impressora i4 = new Impressora("Nome4",1,"Marca4","modelo4","driver4","versao4");
        Impressora i5 = new Impressora("Nome5",1,"Marca5","modelo5","driver5","versao5");

        gi.acrescentaImpressora(i1);
        gi.acrescentaImpressora(i2);
        gi.acrescentaImpressora(i3);
        gi.acrescentaImpressora(i4);
        gi.acrescentaImpressora(i5);

        System.out.println(gi.getImpressora("Nome3"));
        System.out.println(gi.getNomesImpressoras());
        gi.removeImpressora("Nome2");
        System.out.println(gi.getNomesImpressoras());
        System.out.println(gi.existeImpressora("Nome2"));
        System.out.println(gi.existeImpressora("Nome4"));
    }
}
