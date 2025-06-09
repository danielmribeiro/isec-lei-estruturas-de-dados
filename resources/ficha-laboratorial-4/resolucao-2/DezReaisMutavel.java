package ficha4;

import java.util.Iterator;

/**
 *
 * @author nelio
 */
class DezReaisMutavel extends DezReais{
   
    private int modificacoes = 0;
    
    void remove(int pos){
        int j;
        modificacoes++;
        for(j=pos; j<last-1; j++){
            numbers[j] = numbers[j+1];
        }
        last--;
    }
    
    public void acrescenta(Double valor){
        modificacoes++;
        add(valor);
    }
    
    public int getModificacoes(){
        return modificacoes;
    }
    
    @Override
    public Iterator<Double> iterator(){
        return new ItDezReaisMutavel(this);
    }
}
