package Exercicio2;

import Exercicio1.GestorImpressoras;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exercicio2a {
    public static void main(String[] args) {
        Exercicio1.Impressora n, i = new Exercicio1.Impressora("Lab 1",  "HP", "mod 82", "drv 1", "v1",1);
        Exercicio1.Impressora i2 = new Exercicio1.Impressora("Lab 2",  "HP 2", "mod 83", "drv 2", "v2",2);
        Exercicio1.Impressora i3 = new Exercicio1.Impressora("Lab 3",  "HP 3", "mod 84", "drv 3", "v3",3);
    }
}

public class Trabalho {
    String nome;
    int paginas;

    public Trabalho(String nm, int pg) {
        nome = nm;
        paginas = pg;
    }
    public void show{
        System.out.println("Trabalho"+nome+", paginas"+paginas);
    }

    public int getPaginas() {
        return paginas;
    }
}

public class Impressora {
    String nome, marca, modelo, driver, versao;
    Integer porto;
    PriorityQueue<Trabalho> pq = new PriorityQueue<>(
new Comparator<Trabalho>(){
        public int compare(Trabalho a, Trabalho b){
            return a.getPaginas() - b.getPaginas();
        }
    }
);

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

    public boolean temProximoTrabalho(){
        return !pq.isEmpty();
    }

    public Trabalho proximoTrabalho(){
        return pq.poll();
    }

    public void enviaTravalho(Trabalho t){
        pq.add(t);
    }
    public int getNumeroTrabalhos(){ return pq.size(); }

    public void show(){
        System.out.println(" "+nome+" | "+marca+" | "+modelo+" | "+driver+" | "+versao+" | "+porto);
    }
}