package Exercicio2;

public class Exercicio2 {
    public static void main(String[] args) {
        GestorImpressoras gI = new GestorImpressoras();

        Impressora i1 = new Impressora("Nome1", 1, "Marca1", "Modelo1", "Driver1", "V1");
        Impressora i2 = new Impressora("Nome2", 2, "Marca2", "Modelo2", "Driver2", "V2");
        Impressora i3 = new Impressora("Nome3", 3, "Marca3", "Modelo3", "Driver3", "V3");

        gI.acrescentaImpressora(i1);
        gI.acrescentaImpressora(i2);
        gI.acrescentaImpressora(i3);

        System.out.println("Existe Nome2: " + gI.existeImpressora("Nome2"));
        
        gI.removeImpressora("Nome2");
        
        System.out.println("Existe Nome2: " + gI.existeImpressora("Nome2"));
    }
}
