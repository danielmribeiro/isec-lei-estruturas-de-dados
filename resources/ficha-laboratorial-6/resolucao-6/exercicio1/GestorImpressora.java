package exercicio1;

import java.util.HashMap;
import java.util.Set;

public class GestorImpressora {

    HashMap<String, Impressora> conjuntoDeImpressoras = new HashMap<String, Impressora>();

    public GestorImpressora() {
    }

    public Impressora getImpressoras(String nome){
        return (Impressora) conjuntoDeImpressoras.get(nome);
    }

    public Set<String> getNomesImpressoras(){
        return conjuntoDeImpressoras.keySet();
    }

    public Impressora acrescentaImpressora(Impressora impressora){
        return conjuntoDeImpressoras.put(impressora.getNome(),impressora);
    }

    public Impressora removeImpressora(String nome){
        return conjuntoDeImpressoras.remove(nome);
    }

    public boolean existeImpressora(String nome){
        return conjuntoDeImpressoras.containsKey(nome);
    }
}
