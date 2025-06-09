package ficha4;
import java.util.*;

class ItDezReaisPositivos implements Iterator<Double>{
    int posUltimo = -1;
    boolean podeRemover = false;
    int modificacoesConhecidas;
    DezReaisMutavel dr;
    
    public ItDezReaisPositivos(DezReaisMutavel dr){
        this.dr = dr;
        modificacoesConhecidas = dr.getModificacoes();
    }
    
    public int nextPositiveIndex(int from){
        if(from >= dr.size())
            return -1;
        while(dr.get(from) < 0)
            if(++from >= dr.size())
                return -1;
        return from;
    }
    public void veridicaModificacao(){
        if(modificacoesConhecidas != dr.getModificacoes())
            throw new ConcurrentModificationException();
    }
    public static Double maior(Iterable<Double> d){
        Iterator<Double> it = d.iterator();
        Double m, j;
        m = it.next();
        while(it.hasNext()){
            j = it.next();
            if(j > m)
                m = j;
        }
        return m;
    }
    public static <T extends Comparable<? super T> > T maiorg(Iterable<T> d){
        Iterator<T> it = d.iterator();
        T m, j;
        m = it.next();
        while(it.hasNext()){
            j = it.next();
            if(j.compareTo(m) > 0)
                m = j;
        }
        return m;
    }
};
