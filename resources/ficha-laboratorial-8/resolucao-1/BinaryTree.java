/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author nelio
 * @param <T>
 */
public class BinaryTree<T extends Comparable<? super T>> implements Iterable {

    private Node<T> root, nullnode;
    private Comparator<T> comp;
    private int rotations;

    BinaryTree(Comparator<T> cmp) { // Comparador recebido no construtor aquando da declaração
        comp = cmp;
        nullnode = new Node<>();
        nullnode.setLeft(nullnode);
        nullnode.setRight(nullnode);
        root = nullnode;
    }

    BinaryTree() {
        comp = new Comparator<T>() {    // Comparador "por omissão", que usa o compareTo
            @Override
            public int compare(T t1, T t2) {
                return t1.compareTo(t2);
            }
        };
    }

    private void set(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void insere(T t) {   // Método público
        Node n = new Node(t);
        root = insere(root, n);
    }

    private Node<T> insere(Node<T> root, Node<T> newNode) { // Método privado recursivo
        if (root == null) {
            return newNode;
        }

        if (newNode == null) {
            return root;
        }

        int cmp = comp.compare(root.get(), newNode.get());

        if (cmp == 0) {
            throw new RuntimeException();
        } else if (cmp < 0) {
            root.setLeft(insere(root.getLeft(), newNode));
        } else if (cmp > 0) {
            root.setRight(insere(root.getRight(), newNode));
        }

        return root;
    }

    public boolean contem(T t) {
        return contemDado(root, t);
    }

    private boolean contemDado(Node<T> n, T data) {
        if (n == null) {
            return false;
        }

        int c = comp.compare(data, n.get());
        if (c == 0) {
            return true;
        }

        if (c < 0) {
            return contemDado(n.getLeft(), data);
        }

        return contemDado(n.getRight(), data);
    }

    public int profundidadeDe(T t) {
        return profundidadeDe(root, t);
    }

    private int profundidadeDe(Node<T> n, T data) {
        int d = 0;

        if (n == null) {
            return 0;
        }
        if (data.compareTo(n.get()) == 0) {
            return 1;
        }

        d = profundidadeDe(n.getLeft(), data);
        if (d > 0) {
            return d + 1;
        }

        d = profundidadeDe(n.getRight(), data);
        if (d > 0) {
            return d + 1;
        }

        return 0;
    }

    public void imprimeOrdem() {
        List<T> inOrderList = new ArrayList<>();
        ordem(root, inOrderList);
        mostraLista(inOrderList);
    }

    public void ordem(Node<T> root, List<T> storageList) {

        if (root == null) {
            return;
        }
        ordem(root.getLeft(), storageList);
        storageList.add(root.get());
        ordem(root.getRight(), storageList);
    }

    public void mostraLista(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    public int profundidade() {
        return profundidade(root);
    }

    private int profundidade(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int pe = profundidade(node.getLeft());
        int pr = profundidade(node.getRight());

        return (pe > pr) ? pe + 1 : pr + 1;
    }

    public int tamanho() {
        return tamanho(root);
    }

    private int tamanho(Node<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + tamanho(root.getLeft()) + tamanho(root.getRight());
    }

    public void imprimeNiveis() {
        List<Node<T>> list = new LinkedList<>();

        list.add(root);

        System.out.println("===== Conteudo da arvore =====");

        while (!list.isEmpty()) {
            Node<T> n = list.remove(0);

            System.out.println(n.get() + "");

            if (n.getLeft() != null) {
                list.add(n.getLeft());
            }

            if (n.getRight() != null) {
                list.add(n.getRight());
            }
        }
    }

    public void imprimeNivel(Node<T> t, List<T> list, int l) {
        T item;
        System.out.println("-----Nivel " + l + "------");
        ListIterator li = list.listIterator();
        while (li.hasNext()) {
            item = (T) li.next();
            if (profundidadeDe(root, item) == l) {
                System.out.println("[" + l + "]" + item);
            }
        }
    }

    public void imprimePorNiveis() {
        System.out.println("Verifica Profundidade");
        int j, l = profundidade(root);
        System.out.println("Cria ArrayList");
        List<T> list = new ArrayList<>();
        ordem(root, list);
        System.out.println("=====Conteudo da arvore=====");
        for (j = 1; j <= l; j++) {
            imprimeNivel(root, list, j);
        }
        System.out.println("============================");
    }

    public void remove(T value) {
        root = remove(root, value);
    }

    private Node<T> remove(Node<T> root, T value) {
        if (root == null) {
            return null;
        }
        int cmp = comp.compare(value, root.get());

        if (cmp < 0) {
            root.setLeft(remove(root.getLeft(), value));
            return root;
        }

        if (cmp > 0) {
            root.setRight(remove(root.getRight(), value));
            return root;
        }

        //cmp == 0  Apaga aqui
        //sem filhos
        if (root.getLeft() == null && root.getRight() == null) {
            return null;
        }

        //pelo menos um dos filhos nao e null
        if (root.getLeft() == null) {
            return root.getRight();
        }
        if (root.getRight() == null) {
            return root.getLeft();
        }

        System.out.println("Tem 2 filhos o " + root.get());
        Node<T> min = minimumElement(root.getRight());
        root.set(min.get());
        root.setRight(remove(root.getRight(), min.get()));
        return root;
    }

    public Node<T> minimumElement(Node<T> root) {
        if (root.getLeft() == null) {
            return root;
        }
        return minimumElement(root.getLeft());
    }

    //ex.10
    T sucessor(T valor) {
        return sucessor(root, valor);
    }

    T sucessor(Node<T> n, T valor) {
        if (n == null) {
            return null;
        }

        int cmp = valor.compareTo(n.get());

        if (cmp < 0) {  //  Se o valor < raiz entao "talvez" a raiz seja sucessor  
            //  verificar se existe "sucessor" na arvore esq. Se nao existir, entao é a raiz o sucessor
            //  caso contario é esse sucessor
            T sucessorMenor = (T) sucessor(n.getLeft(), valor);
            if (sucessorMenor == null) {
                return n.get();
            } else {
                return sucessorMenor;
            }
        }
        //if(cmp >= 0)    Se valor >= raiz entao o sucessor, a existir, encontra-se na sub-arvore direita
        return (T) sucessor(n.getRight(), valor);
    }

    //ex.11
    public boolean compareTo(BinaryTree<T> othertree) {
        return compareTo(root, othertree.getRoot());
    }

    private boolean compareTo(Node<T> n1, Node<T> n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }

        int cmp = n1.get().compareTo(n2.get());

        return cmp == 0 && compareTo(n1.getLeft(), n2.getLeft()) && compareTo(n1.getRight(), n2.getRight());
    }
    
    public void rodaArvoreDir(){
        if(this.tamanho() == 0)
            return;
        
        root = rodaArvoreDir(this.root);
    }
    
    private Node<T> rodaArvoreDir(Node<T> node){
        rotations++; 
        
        if(node == null)
            return null;
        
        Node b = node.getRight();
        Node tmp = b.getLeft();
        
        b.setLeft(node);
        node.setRight(tmp);
        
        int pr = node.getRight() == null ? 0 : node.getRight().getDepth(); // Acertar profundidades
        node.setPr(pr);
        
        int pl = b.getLeft().getDepth();
        b.setPl(pl);
        
        return b;
    }
    
    public void rodaArvoreEsq(){
        root = rodaArvoreEsq(root);
    }
    
    private Node rodaArvoreEsq(Node<T> node){
        rotations++; 
        
        if(node == null)
            return null;
        
        Node b = node.getLeft();
        Node tmp = b.getRight();
        
        b.setLeft(node);
        node.setRight(tmp);
        
        int pr = node.getRight() == null ? 0 : node.getRight().getDepth(); // Acertar profundidades
        node.setPr(pr);
        
        int pl = b.getLeft().getDepth();
        b.setPl(pl);
        
        return b;
    }
    
    private Node rotateDoubleLR(Node n){
        n.setLeft(rodaArvoreDir(n.getLeft()));
        return rodaArvoreEsq(n);
    }
    
    private Node rotateDoubleRL(Node n){
        n.setRight(rodaArvoreEsq(n.getRight()));
        return rodaArvoreDir(n);
    }
    private Node autoBalance(Node<T> n, T value){
        int l1 = n.get().compareTo(value);
        
        boolean LL = (l1 > 0) && (n.getLeft().get().compareTo(value) > 0);
        boolean RR = (l1 > 0) && (n.getLeft().get().compareTo(value) < 0);
        
        boolean RL = (l1 < 0) && (n.getRight().get().compareTo(value) > 0);
        boolean LR = (l1 < 0) && (n.getRight().get().compareTo(value) < 0);
        
        if(RR) return rodaArvoreDir(n);
        if(LR) return rotateDoubleLR(n);
        if(RL) return rotateDoubleRL(n);
        if(LL) return rodaArvoreEsq(n);
        return nullnode;
    }
    
    private Node insere(Node n, T value){
        if(n == null) return new Node(value);
        
        int c = n.get().compareTo(value);
        
        if(c > 0){
            n.setLeft(insere(n.getLeft(), value));
            
            int pl = n.getLeft().getDepth();
            n.setPl(pl);
            
            if(!n.balanced()) return autoBalance(n, value);
        }
        if(c < 0){
            n.setRight(insere(n.getRight(), value));
            int pr = n.getRight().getDepth();
            n.setPr(pr);
            if(!n.balanced()) return autoBalance(n, value);
        }
        if(c == 0){
            if(n != null) throw new RuntimeException(); return new Node(value);
        }
        return n;
    }

    @Override
    public TreeIterator iterator() {
        return new TreeIterator((Node)root);
    }
}
