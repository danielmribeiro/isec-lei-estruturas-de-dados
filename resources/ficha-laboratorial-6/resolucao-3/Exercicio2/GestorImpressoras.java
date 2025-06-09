package Exercicio2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class GestorImpressoras {
    Map<String, Impressora> mImpressoras = new HashMap();
    
    PriorityQueue pqImpressoras = new PriorityQueue<>(
    new Comparator<Impressora>() {
        @Override
        public int compare(Impressora a, Impressora b) {
            return a.numeroTrabalhos() - b.numeroTrabalhos();
        }
    });

    public Impressora getImpressora(String nome) {
        return mImpressoras.get(nome);
    }

    public Set<String> getNomesImpressoras() {
        return mImpressoras.keySet();
    }

    public void acrescentaImpressora(Impressora impressora) {
        mImpressoras.put(impressora.getNome(), impressora);
        pqImpressoras.add(impressora);
    }

    public void removeImpressora(String nome) {
        pqImpressoras.remove(mImpressoras.get(nome));
        mImpressoras.remove(nome);
    }

    public boolean existeImpressora(String nome) {
        return mImpressoras.containsKey(nome);
    }
    
    public void imprime(Trabalho trabalho) {
        Impressora impressora =  (Impressora) pqImpressoras.poll();
        impressora.enviaTrabalho(trabalho);
        pqImpressoras.add(impressora);
    }
    
    public void mostraFila() {
        Iterator it = pqImpressoras.iterator();
        Impressora impressora;
        
        while(it.hasNext()) {
            impressora = (Impressora) it.next();
            impressora.show();
        }
    }
}
