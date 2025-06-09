package exercicio1;

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
        System.out.println(gi.getImpressoras("cag"));
        System.out.println(gi.getNomesImpressoras());
        gi.removeImpressora("caf");
        System.out.println(gi.getNomesImpressoras());
        System.out.println(gi.existeImpressora("cad"));
        System.out.println(gi.existeImpressora("abc"));
    }
}
