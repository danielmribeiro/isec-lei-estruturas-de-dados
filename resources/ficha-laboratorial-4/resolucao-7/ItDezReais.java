package ficha4;

import java.util.Iterator;



public class ItDezReais implements Iterator <Double>{
    int posUltimo = -1;
    DezReais dr;
    
    public ItDezReais(DezReais dr){
        this.dr = dr;
    }
    @Override
    public Double next(){
        return dr.get(++posUltimo);
    }
    @Override
    public boolean hasNext(){
        return posUltimo + 1 < dr.size();
    }
}
