/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author nelio
 * @param <T>
 */
public class TreeIterator <T> implements Iterator<T>{

    List<Node> pathToRoot = new ArrayList<>();
    
    void addPathtoMinFrom(Node tmp){
        while(tmp != null){
            pathToRoot.add(tmp);
            tmp = tmp.getLeft();
        }
    }
    
    TreeIterator(Node root){
        addPathtoMinFrom(root);
    }
    
    private Node getNext(){
        return pathToRoot.get(pathToRoot.size() - 1);
    }
    
    private void advanceIterator(){
        Node current = pathToRoot.remove(pathToRoot.size()-1);
        if(current.getRight() != null){
            addPathtoMinFrom(current.getRight());
        }
    }
    
    @Override
    public boolean hasNext() {
        return pathToRoot.size() > 0;
    }

    @Override
    public T next() {
        Node ret = getNext();
        advanceIterator();
        return (T)ret.get();
    }    
}
