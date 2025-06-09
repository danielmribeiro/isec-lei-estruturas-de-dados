/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author nelio
 */
public class ItDezReaisPositivos implements Iterator<Double>{
    int posUltimo = -1;
    boolean podeRemover = false;
    int modificacoesConhecidas;
    DezReaisMutavel drm;
    
    public ItDezReaisPositivos(DezReaisMutavel drm){
        this.drm = drm;
        modificacoesConhecidas = drm.getModificacoes();
    }
    
    public int nextPositiveIndex(int from){
        int j;
        
        if(from >= drm.size()) return -1;       //devolve -1 se nao existir
        while(drm.get(from) < 0)
            if(++from >= drm.size()) return -1;
        return from;
    }
    
    public void verificaModificacao(){
        if(modificacoesConhecidas != drm.getModificacoes())
            throw new ConcurrentModificationException();
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
