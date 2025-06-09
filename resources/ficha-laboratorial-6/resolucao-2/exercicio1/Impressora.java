package exercicio1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Impressora {
    private String nome;
    private int porto;
    private String marca;
    private String modelo;
    private String driver;
    private String versao;
    PriorityQueue<Trabalho> pqt = new PriorityQueue<>(new Comparator<Trabalho>() {
        @Override
        public int compare(Trabalho o1, Trabalho o2) {
            return o1.getPaginas()-o2.getPaginas();
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

    public boolean adicionaTrabalho(Trabalho trabalho){
        return pqt.add(trabalho);
    }

    public boolean temProximoTrabalho(){
        return !pqt.isEmpty();
    }

    public Trabalho proximoTrabalho(){
        return pqt.poll();
    }

    public boolean removeTrabalho(Trabalho trabalho){
        Iterator<Trabalho> li = pqt.iterator();

        while (li.hasNext()) {
            if (li.next() == trabalho) {
                li.remove();
                return true;
            }
        }
        return false;
    }

    public int contaTrabalhos() {
        return pqt.size();
    }

    public String show() {
        String str = "";

        str += "Nome: " + nome + " | Marca: " + marca + " | Modelo: " + modelo + " | Versao: " + versao + " | Driver: " + driver + " | Porto: " + porto + "\n";

        str += "Trabalhos: ";

        Iterator it = pqt.iterator();
        Trabalho tb;

        while(it.hasNext()){
            tb = (Trabalho)it.next();
            str += tb.getInfo();
        }

        return str;
    }
}
