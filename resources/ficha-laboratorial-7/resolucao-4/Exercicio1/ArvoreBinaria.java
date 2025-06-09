package Exercicio1;


import java.util.Comparator;
import java.util.Iterator;

public class ArvoreBinaria <T extends Comparable<? super T>> implements Iterable{
    private Node<T> raiz;
    private Node sentinela = null;
    private Comparator<T> comparator;

    int rotations = 0;

    public ArvoreBinaria(Comparator<T> comparator) {
        this.comparator = comparator;

        sentinela = new Node();
        sentinela.setLeft(sentinela);
        sentinela.setRight(sentinela);
        raiz = sentinela;
    }

    public ArvoreBinaria() {
        comparator = new Comparator<T>() {
            @Override
            public int compare(T t1, T t2) {
                return t1.compareTo(t2);
            }
        };

        sentinela = new Node();
        sentinela.setLeft(sentinela);
        sentinela.setRight(sentinela);
        raiz = sentinela;
    }

    public Node<T> getRaiz() {
        return raiz;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    @Override
    public Iterator iterator() {
        return new ArvoreIterator(this);
    }

    public void Insert(T value) {
        Node node = new Node(value);
        node.setLeft(sentinela);
        node.setRight(sentinela);
        raiz = Insert(node, raiz);
    }

    private Node<T> Insert(Node toInsert, Node subARaiz) {
        if (subARaiz == sentinela) {
            return toInsert;
        }

        int cmp = comparator.compare((T) toInsert.getValue(), (T) subARaiz.getValue());

        if (cmp == 0) {
            throw new RuntimeException();
        } else if (cmp < 0) {
            subARaiz.setLeft(Insert(toInsert, subARaiz.getLeft()));
            subARaiz.setDl(subARaiz.getLeft().getDepth());
        } else {
            subARaiz.setRight(Insert(toInsert, subARaiz.getRight()));
            subARaiz.setDr(subARaiz.getRight().getDepth());
        }

        return subARaiz;
    }
}
