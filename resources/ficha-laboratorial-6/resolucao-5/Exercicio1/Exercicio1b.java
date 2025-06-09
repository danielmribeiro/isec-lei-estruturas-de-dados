package Exercicio1;

import java.util.HashMap;
import java.util.Set;

public class Exercicio1b {
    public static void main(String[] args) {
        GestorImpressoras gI = new GestorImpressoras();

        Impressora i1 = new Impressora("Nome1",  "Marca1", "Modelo1", "Driver1", "V1",1);
        Impressora i2 = new Impressora("Nome2",  "Marca2", "Modelo2", "Driver2", "V2",2);
        Impressora i3 = new Impressora("Nome3", "Marca3", "Modelo3", "Driver3", "V3",3);

        gI.getNomes();
    }
}

public class GestorImpressoras {
    HashMap<String, Impressora> mp = new HashMap<>();

    public Impressora getPrinter(String nome) {
        return (Impressora)mp.get(nome);
    } //O(1)

    public Set<String> getNomes() {
        return mp.keySet();
    }//O(1)
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
