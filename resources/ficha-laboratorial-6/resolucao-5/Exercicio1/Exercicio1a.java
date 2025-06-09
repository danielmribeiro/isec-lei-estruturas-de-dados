package Exercicio1;

import java.util.HashMap;

public class Exercicio1a {
    public static void main(String[] args) {
        GestorImpressoras gI = new GestorImpressoras();

        Impressora i1 = new Impressora("Nome1",  "Marca1", "Modelo1", "Driver1", "V1",1);

        gI.getPrinter("Nome1");
    }
}

public class GestorImpressoras {
    HashMap<String, Impressora> mp = new HashMap<>();

    public Impressora getPrinter(String nome) {
        return mp.get(nome);
    } //O(1)
}

public class Impressora {
    String nome, marca, modelo, driver, versao;
    Integer porto;

    public Impressora(String nm, String mrc, String md, String drv, String ver, Integer prt) {
        nome = nm;
        marca = mrc;
        modelo = md;
        driver = drv;
        versao = ver;
        porto = prt;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public void show(){
        System.out.println(" "+nome+" | "+marca+" | "+modelo+" | "+driver+" | "+versao+" | "+porto);
    }
}
