package exercicio6;

import java.util.Iterator;

public class IteradorDezReaisPositivos implements Iterator<Double> {
    int posUltimo=-1;
    boolean podeRemover=false;
    int modificacoesConhecidas;
    DezReaisMutavel dr;

    public IteradorDezReaisPositivos(DezReaisMutavel dr){
        this.dr=dr;
        modificacoesConhecidas = dr.getModificacoes();
    }

    private int nextPositiveIndex(int from){
        if(from>=dr.size())
            return -1;
        while(dr.get(from)<0)
            if(++from>=dr.size())
                return -1;
        return from;
    }

    public Double next(){
        posUltimo= nextPositiveIndex(++posUltimo);
        return dr.get(posUltimo);
    }

    public boolean hasNext(){
        return nextPositiveIndex(posUltimo+1)>=0;
    }
}
