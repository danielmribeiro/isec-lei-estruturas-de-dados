package Exercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GestorImpressoras {
    Map<String, Impressora> mImpressoras = new HashMap();
    
    // a)
    public Impressora getImpressora(String nome) {
        return mImpressoras.get(nome);
    }

    // b)
    public Set<String> getNomesImpressoras() {
        return mImpressoras.keySet();
    }

    // c)
    public void acrescentaImpressora(Impressora impressora) {
        mImpressoras.put(impressora.getNome(), impressora);
    }

    // d)
    public void removeImpressora(String nome) {
        mImpressoras.remove(nome);
    }

    // e)
    public boolean existeImpressora(String nome) {
        return mImpressoras.containsKey(nome);
    }
}
