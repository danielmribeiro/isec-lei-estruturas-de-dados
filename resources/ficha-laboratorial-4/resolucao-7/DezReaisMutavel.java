
package ficha4;
import java.util.*;

class DezReaisMutavel extends DezReais{
    private int modificacoes = 0;
    void remove(int pos){
        int j;
        modificacoes++;
        for(j=pos; j<last-1; j++)
            tab[j] = tab[j+1];
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
        return (Iterator<Double>) new ItDezReaisMutavel(this);
    }
    
}
