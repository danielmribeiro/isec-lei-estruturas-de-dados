package ficha6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class GestorImpressoras {
    HashMap<String, Impressora> mapaImpressoras = new HashMap<>();
    PriorityQueue<Impressora> pqImpressoras = new PriorityQueue<>(
            new Comparator<Impressora>(){

                @Override
                public int compare(Impressora o1, Impressora o2) {
                    return o1.getNumeroTrabalhos() - o2.getNumeroTrabalhos();
                }
            }
    );

    public Impressora getImpressora(String nome){
        return mapaImpressoras.get(nome);
    }

    public void acrescentaImpressora(Impressora impressora){
        mapaImpressoras.put(impressora.nome, impressora);
    }

    public void removeImpressora(String nome){
        mapaImpressoras.remove(nome);
    }

    public boolean existeImpressora(String nome){
        return mapaImpressoras.containsKey(nome);
    }

    public void imprime(Impressora impressora){
        pqImpressoras.add(impressora);
    }

    public void mostraFila() {
        Iterator it = pqImpressoras.iterator();
        Impressora impressora;

        while(it.hasNext()) {
            impressora = (Impressora) it.next();
            impressora.toString();
        }
    }
}
