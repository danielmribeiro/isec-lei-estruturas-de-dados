package exercicio1;

import java.util.*;

public class GestorImpressoras {
    HashMap<String,Impressora> mapaImpressoras = new HashMap<>();
    PriorityQueue<Impressora> pqi = new PriorityQueue<Impressora>(new Comparator<Impressora>() {
        @Override
        public int compare(Impressora o1, Impressora o2) {
            return o1.contaTrabalhos() - o2.contaTrabalhos();
        }
    });

    public Impressora getImpressora(String nome){
        return (Impressora) mapaImpressoras.get(nome);
    }

    public Set<String> getNomesImpressoras(){
        return mapaImpressoras.keySet();
    }

    public Impressora acrescentaImpressora(Impressora impressora){
        return mapaImpressoras.put(impressora.getNome(),impressora);
    }

    public Impressora removeImpressora(String nome){
        return mapaImpressoras.remove(nome);
    }

    public boolean existeImpressora(String nome){
        return mapaImpressoras.containsKey(nome);
    }

    public void imprime(Trabalho trabalho){
        pqi.poll().adicionaTrabalho(trabalho);
    }
    public boolean enviaTrabalho(String i, Trabalho t){
        return mapaImpressoras.get(i).adicionaTrabalho(t);
    }


    public String mostraImpressoras(){
        String str = "";
        Iterator it = pqi.iterator();
        Impressora imp;

        while(it.hasNext()){
            imp = (Impressora)it.next();
            str += imp.show();
        }
        return str;
    }
}
