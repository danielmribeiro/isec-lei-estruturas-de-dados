package Exercicios;

import java.lang.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable<? super T>> implements Iterable {

    private Node<T> root;
    private Node sentinel = null;
    private Comparator<T> comparator;

    int rotations = 0;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;

        sentinel = new Node();
        sentinel.setLeft(sentinel);
        sentinel.setRight(sentinel);
        root = sentinel;
    }

    public BinaryTree() {
        comparator = new Comparator<T>() {
            @Override
            public int compare(T t1, T t2) {
                return t1.compareTo(t2);
            }
        };

        sentinel = new Node();
        sentinel.setLeft(sentinel);
        sentinel.setRight(sentinel);
        root = sentinel;
    }

    public Node<T> getRoot() {
        return root;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(this);
    }

    /*-------------------------------------------------------------------*/
    public void Insert(T value) {
        Node node = new Node(value);
        node.setLeft(sentinel);
        node.setRight(sentinel);
        root = Insert(node, root);
    }

    private Node<T> Insert(Node toInsert, Node subTRoot) {
        if (subTRoot == sentinel) {
            return toInsert;
        }

        int cmp = comparator.compare((T) toInsert.getValue(), (T) subTRoot.getValue());

        if (cmp == 0) {
            throw new RuntimeException();
        } else if (cmp < 0) {
            subTRoot.setLeft(Insert(toInsert, subTRoot.getLeft()));
            subTRoot.setDl(subTRoot.getLeft().getDepth());
        } else {
            subTRoot.setRight(Insert(toInsert, subTRoot.getRight()));
            subTRoot.setDr(subTRoot.getRight().getDepth());
        }

        return subTRoot;
    }

    /*-------------------------------------------------------------------*/
    public boolean Contains(T value) {
        if (root == sentinel) {
            return false;
        }

        return Contains(value, root);
    }

    private boolean Contains(T value, Node<T> node) {
        if (node == sentinel) {
            return false;
        }

        int cmp = comparator.compare(value, node.getValue());

        if (cmp == 0) {
            return true;
        }

        if (cmp < 0) {
            return Contains(value, node.getLeft());
        } else { // cmp > 0
            return Contains(value, node.getRight());
        }
    }

    /*-------------------------------------------------------------------*/
    public int DepthOf(T value) {
        if (root == sentinel) {
            return 0;
        }

        if (!Contains(value)) {
            throw new NoSuchElementException();
        }

        return DepthOf(value, root, 0);
    }

    private int DepthOf(T value, Node node, int depth) {
        int cmp = comparator.compare(value, (T) node.getValue());

        if (cmp == 0) {
            return ++depth;
        } else if (cmp < 0) {
            return DepthOf(value, node.getLeft(), ++depth);
        } else {
            return DepthOf(value, node.getRight(), ++depth);
        }
    }

    /*-------------------------------------------------------------------*/
    public int Depth() {
        return Depth(root);
    }

    private int Depth(Node node) {
        if (node == sentinel) {
            return 0;
        }

        int dL = Depth(node.getLeft());
        int dR = Depth(node.getRight());

        return dL > dR ? dL + 1 : dR + 1;
    }

    /*-------------------------------------------------------------------*/
    public int Size() {
        return NodeSize(root);
    }

    private int NodeSize(Node<T> node) {
        if (node == sentinel) {
            return 0;
        }

        return 1 + NodeSize(node.getLeft()) + NodeSize(node.getRight());
    }

    /*-------------------------------------------------------------------*/
    public void Print() {
        PrintNode(root);
    }

    private void PrintNode(Node node) {
        if (node == sentinel) {
            return;
        }

        if (node.getLeft() != sentinel) {
            PrintNode(node.getLeft());
        }
        System.out.println("Value = " + node.getValue());

        if (node.getRight() != sentinel) {
            PrintNode(node.getRight());
        }
    }

    /*-------------------------------------------------------------------*/
    void Sort(Node<T> subTRoot, List<T> list) {
        if (subTRoot == sentinel) {
            return;
        }
        list.add(subTRoot.getValue());
        Sort(subTRoot.getLeft(), list);
        Sort(subTRoot.getRight(), list);
    }

    /*-------------------------------------------------------------------*/
    void PrintLevels() {
        List<Node<T>> list = new LinkedList<>();

        list.add(root);

        System.out.println("=====CONTEUDO DA ARVORE=====");

        while (!list.isEmpty()) {
            Node<T> node = list.remove(0);
            System.out.println(node.getValue());
            if (node.getLeft() != sentinel) {
                list.add(node.getLeft());
            }

            if (node.getRight() != sentinel) {
                list.add(node.getRight());
            }
        }
    }

    /*-------------------------------------------------------------------*/
    public void PrintLevel(Node<T> node, List<T> list, int level) {
        T item;
        System.out.println("------Level " + level + "------");
        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            item = (T) it.next();
            if (DepthOf(item) == level) {
                System.out.println("[" + level + "] " + item);
            }
        }
    }

    public void PrintByLevel() {
        int level = Depth();
        List<T> list = new ArrayList<>();
        Sort(root, list);

        System.out.println("=====CONTEUDO DA ARVORE=====");
        for (int i = 1; i <= level; i++) {
            PrintLevel(root, list, i);
        }
        System.out.println("============================");
    }

    /*-------------------------------------------------------------------*/
    public Node<T> GetMinimumElement(Node<T> subTRoot) {
        if (subTRoot.getLeft() == sentinel) {
            return subTRoot;
        }
        return GetMinimumElement(subTRoot.getLeft());
    }

    public Node<T> GetMaximumElement(Node<T> subTRoot) {
        if (subTRoot.getRight() == sentinel) {
            return subTRoot;
        }
        return GetMaximumElement(subTRoot.getRight());
    }

    /*-------------------------------------------------------------------*/
    public void Remove(T value) {
        root = Remove(root, value);
    }

    private Node<T> Remove(Node<T> subTRoot, T value) {
        if (subTRoot == sentinel) {
            return sentinel;
        }
        int cmp = comparator.compare(value, subTRoot.getValue());

        if (cmp < 0) {
            Node<T> temp = Remove(subTRoot.getLeft(), value);
            root.setLeft(temp);
            return subTRoot;
        }
        if (cmp > 0) {
            root.setRight(Remove(subTRoot.getRight(), value));
            return subTRoot;
        }

        // Remover (cmp == 0)
        // NÃ£o tem filhos
        if (subTRoot.getLeft() == sentinel && subTRoot.getRight() == sentinel) {
            return sentinel;
        }

        // Tem, pelo menos, um filho
        if (subTRoot.getLeft() == sentinel) {
            return subTRoot.getRight();
        }
        if (subTRoot.getRight() == sentinel) {
            return subTRoot.getLeft();
        }
        // Tem 2 filhos
        Node<T> node = GetMinimumElement(subTRoot.getRight());
        subTRoot.setLeft(node);
        root.setRight(Remove(subTRoot.getRight(), node.getValue()));

        return subTRoot;
    }

    /*-------------------------------------------------------------------*/
    void RemoveParentsOfOne() {
        root = RemoveParentsOfOne(root);
    }

    Node<T> RemoveParentsOfOne(Node<T> subTRoot) {
        if (subTRoot == sentinel) {
            return subTRoot;
        }

        if (subTRoot.getLeft() == sentinel && subTRoot.getRight() != sentinel) {
            return subTRoot.getRight();
        }

        if (subTRoot.getLeft() != sentinel && subTRoot.getRight() == sentinel) {
            return subTRoot.getLeft();
        }

        subTRoot.setLeft(RemoveParentsOfOne(subTRoot.getLeft()));
        subTRoot.setRight(RemoveParentsOfOne(subTRoot.getRight()));

        return subTRoot;
    }

    /*-------------------------------------------------------------------*/
    void RemoveLeafs() {
        root = RemoveLeafs(root);
    }

    Node<T> RemoveLeafs(Node<T> subTRoot) {
        if (subTRoot == sentinel) {
            return subTRoot;
        }

        if (subTRoot.getLeft() == sentinel && subTRoot.getRight() == sentinel) {
            return sentinel;
        }

        subTRoot.setLeft(RemoveLeafs(subTRoot.getLeft()));
        subTRoot.setRight(RemoveLeafs(subTRoot.getRight()));

        return subTRoot;
    }

    /*-------------------------------------------------------------------*/
    Node<T> SmallestChildGreaterThan(T value) {
        return SmallestChildGreaterThan(value, root);
    }

    Node<T> SmallestChildGreaterThan(T value, Node<T> subTRoot) {
        if (subTRoot == sentinel) {
            return null;
        }

        int cmp = comparator.compare((T) value, (T) subTRoot.getValue());

        if (cmp > 0) {
            return SmallestChildGreaterThan(value, subTRoot.getRight());
        }
        if (cmp < 0) {
            return SmallestChildGreaterThan(value, subTRoot.getLeft());
        }

        //Encontrou o valor
        if (subTRoot.getRight() != sentinel) {
            return null;
        } else {
            return GetMinimumElement(subTRoot.getRight());
        }
    }

    /*-------------------------------------------------------------------*/
    public boolean EqualTo(BinaryTree bT) {
        return EqualTo(root, bT.root);
    }

    private boolean EqualTo(Node<T> subTRoot1, Node<T> subTRoot2) {
        if (subTRoot1.getValue() == null && subTRoot2.getValue() == null) {
            return true;
        }

        if (subTRoot1.getValue() == null || subTRoot2.getValue() == null) {
            return false;
        }

        if (comparator.compare((T) subTRoot1.getValue(), (T) subTRoot2.getValue()) != 0) {
            return false;
        }

        return (EqualTo(subTRoot1.getLeft(), subTRoot2.getLeft()) && EqualTo(subTRoot1.getRight(), subTRoot2.getRight()));
    }

    /*-------------------------------------------------------------------*/
    public void RotateWithRight() {
        root = RotateWithRight(root);
    }

    private Node<T> RotateWithRight(Node<T> subTRoot) {
        rotations++;

        Node<T> toRotate = subTRoot.getRight();

        if (toRotate == sentinel) {
            return subTRoot;
        }

        Node<T> node = toRotate.getLeft();
        subTRoot.setRight(node);
        toRotate.setLeft(subTRoot);

        int dL;
        dL = toRotate.getLeft() == sentinel ? 0 : toRotate.getLeft().getDepth();
        toRotate.setDl(dL);

        int dR;
        dR = subTRoot.getRight() == sentinel ? 0 : subTRoot.getRight().getDepth();
        subTRoot.setDr(dR);

        return toRotate;
    }

    /*-------------------------------------------------------------------*/
    public void RotateWithLeft() {
        root = RotateWithLeft(root);
    }

    private Node<T> RotateWithLeft(Node<T> subTRoot) {
        rotations++;

        Node<T> toRotate = subTRoot.getLeft();

        if (toRotate == sentinel) {
            return subTRoot;
        }

        Node<T> node = toRotate.getRight();
        subTRoot.setLeft(node);
        toRotate.setRight(subTRoot);

        int dR;
        dR = toRotate.getRight() == sentinel ? 0 : toRotate.getRight().getDepth();
        toRotate.setDl(dR);

        int dL;
        dL = subTRoot.getLeft() == sentinel ? 0 : subTRoot.getLeft().getDepth();
        subTRoot.setDr(dL);

        return toRotate;
    }

    /*-------------------------------------------------------------------*/
    private Node<T> DoubleRotateWithLeft(Node<T> subTRoot) {
        subTRoot.setLeft(RotateWithLeft(subTRoot.getLeft()));
        return RotateWithLeft(subTRoot);
    }

    private Node<T> DoubleRotateWithRight(Node<T> subTRoot) {
        subTRoot.setRight(RotateWithRight(subTRoot.getRight()));
        return RotateWithRight(subTRoot);
    }

    public int NumberOfParentsOfTwo() {
        return NumberOfParentsOfTwo(root);
    }

    private int NumberOfParentsOfTwo(Node<T> subTRoot) {
        int sum = 0;
        int hasTwo = 1;

        if (subTRoot.getLeft() == sentinel && subTRoot.getRight() == sentinel) {
            return 0;
        }

        if (subTRoot.getLeft() != sentinel) {
            sum += NumberOfParentsOfTwo(subTRoot.getLeft());
        } else {
            hasTwo = 0;
        }

        if (subTRoot.getRight() != sentinel) {
            sum += NumberOfParentsOfTwo(subTRoot.getRight());
        } else {
            hasTwo = 0;
        }

        return sum + hasTwo;
    }

    public void RemoveNodesWithoutLeft() {
        root = RemoveNodesWithoutLeft(root);
    }

    private Node<T> RemoveNodesWithoutLeft(Node<T> subTRoot) {
        if (subTRoot == sentinel) {
            return subTRoot;
        }

        if (subTRoot.getRight() != sentinel) {
            subTRoot.setRight(RemoveNodesWithoutLeft(subTRoot.getRight()));
        }

        if (subTRoot.getLeft() == sentinel) {
            return subTRoot.getRight();
        }

        subTRoot.setLeft(RemoveNodesWithoutLeft(subTRoot.getLeft()));
        
        return subTRoot;
    }
}

