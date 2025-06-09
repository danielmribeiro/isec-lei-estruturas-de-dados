package Exercicio2;

import java.util.*;

public class Exercicio2b {
    public static void main(String[] args) {
        Exercicio1.GestorImpressoras gi = new Exercicio1.GestorImpressoras();

        Exercicio1.Impressora n, i = new Exercicio1.Impressora("Lab 1",  "HP", "mod 82", "drv 1", "v1",1);
        Exercicio1.Impressora i2 = new Exercicio1.Impressora("Lab 2",  "HP 2", "mod 83", "drv 2", "v2",2);
        Exercicio1.Impressora i3 = new Exercicio1.Impressora("Lab 3",  "HP 3", "mod 84", "drv 3", "v3",3);

        gi.addPrinter(i);
        gi.addPrinter(i2);
        gi.addPrinter(i3);

        Trabalho t, t1 = new Trabalho("T1", 3);
        Trabalho t2 = new Trabalho("T2", 2);

        System.out.println("-> Fila de espera");
        gi.mostraFila();

        System.out.println("-> Fila de espera com t1");
        gi.imprime(t1);
        gi.mostraFila();
        System.out.println("-> Fila de espera com t1 e t2");
        gi.imprime(t2);
        gi.mostraFila();
        System.out.println("-> Fila de espera com t1, t2 e t3");
        gi.imprime(t3);
        gi.mostraFila();
        System.out.println("-> Fila de espera com t1, t2, t3 e t4");
        gi.imprime(t4);
        gi.mostraFila();
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

public class GestorImpressoras {
    HashMap<String, Exercicio1.Impressora> mp = new HashMap<>();

    PriorityQueue<Impressora> impressoras= new PriorityQueue<>(
            new Comparator<Impressora>() {
                public int compare(Impressora a, Impressora b) {
                    int dt=a.getNumeroTrabalhos();
                    return dt;//falta fer páginas
                }
            });

    void removePrinter(String nome){
        mp.remove(nome);
    }

    public void addPrinter(Impressora i){
        mp.put(i.getNome(), i);
        impressoras.add(i);
    }

    public void imprime(Trabalho t){
        Impressora imp=impressoras.remove();
        imp.enviaTrabalho(t);
        impressoras.add(imp);
    }

    public void mostraFila(){
        Iterator i = impressoras.iterator();
        Impressora imp;
        while(i.hasNext()){
            imp = (Impressora)i.next();
            imp.show();
        }
    }

    boolean existe (String nome){
        return mp.containsKey(nome);
    }

    public Exercicio1.Impressora getPrinter(String nome) {
        return (Exercicio1.Impressora)mp.get(nome); //O(1)
    }

    public Set<String> getNomes() {
        return mp.keySet();
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

    public void enviaTrabalho(Trabalho t){
        pq.add(t);
    }

    public int getNumeroTrabalhos(){ return pq.size(); }

    public void show(){
        System.out.println(" "+nome+" | "+marca+" | "+modelo+" | "+driver+" | "+versao+" | "+porto);
    }
}