package Exercicio8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItDezReais implements Iterator<Double>{
    int posUltimo = -1; //Indice do ultimo valor devolvido
    DezReais dr;

    ItDezReais(DezReais dr) {
        this.dr = dr;
    }

    @Override
    public boolean hasNext() {
        return posUltimo + 1 < dr.size();
    }

    @Override
    public Double next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return dr.get(++posUltimo);
    }
    
}
