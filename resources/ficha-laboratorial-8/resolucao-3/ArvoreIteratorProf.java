package Exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArvoreIteratorProf <T> implements Iterator<T>{
    private List<No<T>> pathToRoot = new ArrayList<No<T>>();

    void addPathToMinFrom(No<T> tmp){
        while(tmp != null){
            pathToRoot.add(tmp);
            tmp = tmp.getEsquerdo();
        }
    }
    
    public ArvoreIteratorProf(No root) {
        addPathToMinFrom(root);
    }
    
    private No<T> getNext(){
        return pathToRoot.get(pathToRoot.size() - 1);
    }
    
    private void advanceIterator(){
        No<T> current = pathToRoot.remove(pathToRoot.size() - 1);
        if(current.getDireito() != null){
            addPathToMinFrom(current.getDireito());
        }
    }

    @Override
    public boolean hasNext() {
        return pathToRoot.size() > 0;
    }

    @Override
    public T next() {
        No<T> ret = getNext();
        advanceIterator();
        return ret.getValor();
    }
    
}
