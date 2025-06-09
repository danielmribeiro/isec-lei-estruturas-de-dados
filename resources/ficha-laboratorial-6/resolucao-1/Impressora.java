/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

/**
 *
 * @author nelio
 */
public class Impressora {

    String nome, marca, modelo, versao, driver;
    int porto;
    PriorityQueue<Trabalho> pqt = new PriorityQueue<>(new Comparator<Trabalho>() {
        @Override
        public int compare(Trabalho o1, Trabalho o2) {
            return o1.getNumPaginas() - o2.getNumPaginas();
        }
    });

    public Impressora(String n, String ma, String mo, String v, String d, int p) {
        this.nome = n;
        this.marca = ma;
        this.modelo = mo;
        this.versao = v;
        this.driver = d;
        this.porto = p;
    }

    public String getNome() {
        return nome;
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

    public int getPorto() {
        return porto;
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

    public boolean adicionaTrabalho(Trabalho t) {
        return pqt.add(t);
    }
    
    public Trabalho proximoTrabalho(){
        return pqt.poll();
    }

    public boolean removeTrabalho(Trabalho t) {
        Iterator<Trabalho> li = pqt.iterator();

        while (li.hasNext()) {
            if (li.next() == t) {
                li.remove();
                return true;
            }
        }
        return false;
    }

    public int contaTrabalhos() {
        return pqt.size();
    }

    public boolean temProximoTrabalho() {
        return !pqt.isEmpty();
    }
}
