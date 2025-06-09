
package ficha4;
import java.util.*;

class ItDezReaisMutavel implements Iterator<Double>{
    int posUltimo = -1;
    boolean podeRemover = false;
    DezReaisMutavel dr;
    int modificacoesConhecidas=0;
    
    public ItDezReaisMutavel(DezReaisMutavel dr){
        this.dr = dr;
    }
    @Override
    public Double next(){
        verificaModificacao();
        if(posUltimo+1 >= dr.size())
            throw new NoSuchElementException();
        podeRemover = true;
        return dr.get(++posUltimo);
    }
    @Override
    public boolean hasNext(){
        verificaModificacao();
        return posUltimo+1 < dr.size();
    }
    @Override
    public void remove(){
        if(!podeRemover)
            throw new IllegalStateException();
        podeRemover = false;
        dr.remove(posUltimo);
        posUltimo--;
        modificacoesConhecidas++;
    }
    
    public void verificaModificacao(){
        if(modificacoesConhecidas != dr.getModificacoes())
            throw new ConcurrentModificationException();
    }
};
