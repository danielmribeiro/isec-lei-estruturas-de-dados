package exercicio2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Impressora {
    private String nome;
    private int porto;
    private String marca;
    private String modelo;
    private String driver;
    private String versao;
    HashMap<String, Trabalho> filaDeEspera = new HashMap<String, Trabalho>();

    public Impressora(String nome, int porto, String marca, String modelo, String driver, String versao) {
        this.nome = nome;
        this.porto = porto;
        this.marca = marca;
        this.modelo = modelo;
        this.driver = driver;
        this.versao = versao;
    }

    PriorityQueue<Trabalho> pq = new PriorityQueue<>(
            new Comparator<Trabalho>(){
                public int compare(Trabalho a, Trabalho b){
                    return a.getPaginas() - b.getPaginas();
                }
            }
    );

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

    public String getNome() {
        return nome;
    }

    public int getPorto() {
        return porto;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDriver() {
        return driver;
    }

    public String getVersao() {
        return versao;
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
}
