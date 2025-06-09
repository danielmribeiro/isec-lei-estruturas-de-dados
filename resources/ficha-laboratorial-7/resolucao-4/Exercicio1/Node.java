package Exercicio1;


public class Node <T>{
    private Node<T> left;
    private Node<T> right;
    private T value;

    private int dl, dr;

    public Node() {}

    public Node(T value) {
        this.left = null;
        this.right = null;
        this.value = value;
        this.dl = 0;
        this.dr = 0;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public int getDepth() {
        return (dl > dr) ? dl + 1 : dr + 1;
    }

    boolean balanced() {
        return Math.abs(dl - dr) <= 1;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setDl(int dl) {
        this.dl = dl;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

}
