/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha7;

/**
 *
 * @author nelio
 * @param <T>
 */
public class Node <T>{
    
    private T data;
    private Node<T> left, right;

    public Node(T data) {
        this.data = data;
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
    
    public void set(T data){
        this.data = data;
    }
    
    public void setLeft(Node l){
        left = l;
    }
    
    public void setRight(Node r){
        right = r;
    }
}

