package Exercicio2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Impressora {
    private String nome;
    private int porto;
    private String marca;
    private String modelo;
    private String driver;
    private String versao;
    private PriorityQueue<Trabalho> trabalhos = new PriorityQueue<>(new Comparator<Trabalho>() {
        @Override
        public int compare(Trabalho a, Trabalho b) {
            return a.getPaginas() - b.getPaginas();
        }
    });

    public Impressora(String nome, int porto, String marca, String modelo, String driver, String versao) {
        this.nome = nome;
        this.porto = porto;
        this.marca = marca;
        this.modelo = modelo;
        this.driver = driver;
        this.versao = versao;
    }

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
    
    public boolean temProximoTrabalho() {
        return !trabalhos.isEmpty();
    }
    
    public Trabalho proximoTrabalho() {
        return trabalhos.poll();
    }
    
    public void enviaTrabalho(Trabalho trabalho) {
        trabalhos.add(trabalho);
    }
    
    public void removeTrablho(Trabalho trabalho) {
        trabalhos.remove(trabalho);
    }
    
    public int numeroTrabalhos() {
        return trabalhos.size();
    }
    
    public void show() {
        System.out.println(nome + " | " + porto + " | " + marca + " | " + modelo + " | " + driver + " | " + versao);
    }
    
}
