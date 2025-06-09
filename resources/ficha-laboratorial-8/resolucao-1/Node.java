/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

/**
 *
 * @author nelio
 * @param <T>
 */
public class Node <T extends Comparable<? super T>>{
    
    private T data;
    private Node<T> left, right;
    private int pl, pr;

    public Node(T data) {
        this.data = data;
        left = null; right = null;
        pl = pr = 0;
    }
    
    public Node(){ }
    
    public Node getLeft(){
        return left;
    }
    
    public Node getRight(){
        return right;
    }
    
    public T get(){
        return data;
    }
    
    public int compareTo(T value){
        return data.compareTo(value);
    }
    
    public void set(T data){
        this.data = data;
    }
    
    public void setLeft(Node l){
        left = l;
    }
    
    public void setRight(Node r){
        right = r;
    }
    
    public void setPl(int pl){
        this.pl = pl;
    }
    
    public void setPr(int pr){
        this.pr = pr;
    }
    
    public int getDepth(){
        return (pl>pr) ? pl + 1 : pr + 1;
    }
    
    boolean balanced(){
        return Math.abs(pl-pr) <= 1;
    }
}

