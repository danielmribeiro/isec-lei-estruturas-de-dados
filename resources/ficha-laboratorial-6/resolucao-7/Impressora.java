package ficha6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Impressora {
    public String nome;
    public int porto;
    public String marca;
    public String modelo;
    public String driver;
    public String versao;
    PriorityQueue<Trabalho> pqTrabalho = new PriorityQueue<>(
        new Comparator<Trabalho>(){
            @Override
            public int compare(Trabalho o1, Trabalho o2) {
                return o1.getPaginas()-o2.getPaginas();
            }
        }
    );


    public int getNumeroTrabalhos() {
        return pqTrabalho.size();
    }

    public Impressora(String nome, int porto, String marca, String modelo, String driver, String versao) {
        this.nome = nome;
        this.porto = porto;
        this.marca = marca;
        this.modelo = modelo;
        this.driver = driver;
        this.versao = versao;
    }

    @Override
    public String toString() {
        return "Impressora{" +
                "nome='" + nome + '\'' +
                ", porto=" + porto +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", driver='" + driver + '\'' +
                ", versao='" + versao + '\'' +
                '}';
    }

    public boolean temProximoTrabalho(){
        return !pqTrabalho.isEmpty();
    }

    public Trabalho proximoTrabalho(){
        return pqTrabalho.poll();
    }

    public void enviaTrabalho(Trabalho trabalho) {
        pqTrabalho.add(trabalho);
    }
}
