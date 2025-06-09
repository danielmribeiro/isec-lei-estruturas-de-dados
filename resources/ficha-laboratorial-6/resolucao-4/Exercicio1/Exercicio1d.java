package Exercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exercicio1d {
    public static void main(String[] args) {
        GestorImpressoras gi = new GestorImpressoras();

        Impressora n, i = new Impressora("Lab 1",  "HP", "mod 82", "drv 1", "v1",1);
        Impressora i2 = new Impressora("Lab 2",  "HP 2", "mod 83", "drv 2", "v2",2);
        Impressora i3 = new Impressora("Lab 3",  "HP 3", "mod 84", "drv 3", "v3",3);

        gi.addPrinter(i);
        gi.addPrinter(i2);
        gi.addPrinter(i3);

        System.out.printf("Impressoras: ");
        System.out.println(gi.getNomes());

        gi.removePrinter("Lab 2");

        System.out.printf("Impressoras depois de removida Lab2: ");
        System.out.println(gi.getNomes());
    }
}

public class GestorImpressoras {
    HashMap<String, Impressora> mp = new HashMap<>();

    public GestorImpressoras(){}

    public Map getMapa(){
        return mp;
    }

    public void addPrinter(Impressora i){
        mp.put(i.getNome(), i);
    }

    void removePrinter(String nome){
        mp.remove(nome);
    }

    public Impressora getPrinter(String nome) {
        return (Impressora)mp.get(nome); //O(1)
    }

    public Set<String> getNomes() {
        return mp.keySet();
    }
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
