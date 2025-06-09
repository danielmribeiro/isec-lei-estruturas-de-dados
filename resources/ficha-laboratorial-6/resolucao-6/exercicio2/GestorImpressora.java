package exercicio2;

import java.util.*;

public class GestorImpressora {

    HashMap<String, Impressora> conjuntoDeImpressoras = new HashMap<String, Impressora>();

    public GestorImpressora() {
    }

    public Impressora getImpressoras(String nome) {
        return (Impressora) conjuntoDeImpressoras.get(nome);
    }

    public Set<String> getNomesImpressoras() {
        return conjuntoDeImpressoras.keySet();
    }

    public Impressora acrescentaImpressora(Impressora impressora) {
        return conjuntoDeImpressoras.put(impressora.getNome(), impressora);
    }

    PriorityQueue<Impressora> impressoras= new PriorityQueue<>(
            new Comparator<Impressora>() {
                public int compare(Impressora a, Impressora b) {
                    if(a.getNumeroTrabalhos()< b.getNumeroTrabalhos()){
                        return a.getNumeroTrabalhos();
                    }else if(a.getNumeroTrabalhos()>b.getNumeroTrabalhos()){
                        return b.getNumeroTrabalhos();
                    }else{
                        if(a.proximoTrabalho().getPaginas()<b.proximoTrabalho().getPaginas()){
                            return a.getNumeroTrabalhos();
                        }else if(a.proximoTrabalho().getPaginas()>b.proximoTrabalho().getPaginas()){
                            return b.getNumeroTrabalhos();
                        } else{
                            return a.getNumeroTrabalhos();
                        }
                    }
                }
            });

    public void mostraFila(){
        Iterator i = impressoras.iterator();
        Impressora imp;
        while(i.hasNext()){
            imp = (Impressora)i.next();
            imp.toString();
        }
    }

    public void imprime(Trabalho t){
        Impressora imp=impressoras.remove();
        imp.enviaTrabalho(t);
        impressoras.add(imp);
    }

    public Impressora removeImpressora(String nome){
        return conjuntoDeImpressoras.remove(nome);
    }

    public boolean existeImpressora(String nome){
        return conjuntoDeImpressoras.containsKey(nome);
    }
}
