package Exercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Arvore <T extends Comparable<? super T>> implements Iterable<T>{
    private No<T> root, nullnode;
    private Comparator<T>comp;

    public Arvore(Comparator<T> comp) {
        this.comp = comp;
        this.nullnode = new No<>();
        nullnode.setEsquerdo(nullnode);
        nullnode.setDireito(nullnode);
        root = nullnode;
    }

    public Arvore() {
        this.comp = new Comparator<T>() {
            @Override
            public int compare(T t1, T t2) {
                return t1.compareTo(t2);
            }
        };
    }    
    
    public No getRoot() {
        return root;
    }
    
    public void insere(T t){
        No no = new No(t);
        no.setDireito(nullnode);
        no.setEsquerdo(nullnode);
        root = insere(root, no);
    }
    
    private No<T> insere(No<T> r, No<T>novoNo){
        if(r == nullnode)
            return novoNo;
        
        int cmp = comp.compare(r.getValor(), novoNo.getValor());
        if (cmp == 0)
           throw new RuntimeException();
        
        if (cmp > 0) 
            r.setEsquerdo(insere(r.getEsquerdo(), novoNo));
        else
            r.setDireito(insere(r.getDireito(), novoNo));
        return r;
    }
    
    public boolean contem(T t){
        return contem(root, t);
    }

    private boolean contem(No<T> r, T data){
        if(r == nullnode)
            return false;
        
        int cmp = comp.compare(r.getValor(), data);

        if(cmp == 0)
            return true;
        
        if(cmp < 0)
            return contem(r.getEsquerdo(), data);
        else
            return contem(r.getDireito(), data);
    }
    
    public int profundidadeDe(T t){
        return profundidadeDe(root, t);
    }

    private int profundidadeDe(No<T> r, T data){
        int dl = 0, dr = 0; 
        
        if(r == nullnode)
            return 0;
        
        if(data.compareTo(r.getValor()) == 0)
            return 1;
                
       dl = profundidadeDe(r.getEsquerdo(), data);       
       if(dl > 0)
           return dl + 1;
       
       dr = profundidadeDe(r.getDireito(), data);
       if(dr > 0)
           return dr + 1;
       
       return 0;       
    }
    
    public List<T> getOrdem(){
        List<T> inOrderList = new ArrayList<>();
        ordem(root, inOrderList);
        return inOrderList;
    }
    
    public void imprimeOrdem(){
        List<T> inOrderList = new ArrayList<>();
        ordem(root, inOrderList);
        mostraLista(inOrderList);
    }
    
    private void ordem(No<T> r, List<T> storageList){
        if(r == nullnode)
            return;
        
        ordem(r.getEsquerdo(), storageList);
        storageList.add(r.getValor());
        ordem(r.getDireito(), storageList);
    }
    
    public void mostraLista(List<T> lista){
        for(T item : lista)
            System.out.println(item);
    }
    
    public int profundidade(){
        return profundidade(root);
    }
    
    private int profundidade(No<T> r){
        if(r == nullnode)
            return 0;
        
       int dl = profundidade(r.getEsquerdo());      
       int dr = profundidade(r.getDireito());
        
       return dl > dr ? dl + 1 : dr + 1;
    }
    
    public int tamanho(){
        return tamanho(root);
    }
    
    private int tamanho(No<T> r){
        if(r == nullnode)
            return 0;       
       return 1 + tamanho(r.getEsquerdo()) + tamanho(r.getDireito());
    }
    
    public void imprimeNiveis(){
         List<No<T>> list = new LinkedList<>();
         
         list.add(root);
         
         while(!list.isEmpty()){
             No<T> n = list.remove(0);
             System.out.println(n.getValor()+ " ");
             if(n.getEsquerdo()!= nullnode) list.add(n.getEsquerdo());
             if(n.getDireito()!= nullnode) list.add(n.getDireito());
        }
    }
    
    public boolean isEquals(Arvore Tree){
        return isEquals(root, Tree.root);
    }
    
    private boolean isEquals(No<T> root, No<T> Tree){
        if(root == nullnode && Tree == nullnode){
            return true;
        }
        if(root == nullnode || Tree == nullnode){
            return false;
        }
        
        int cmp = root.getValor().compareTo(Tree.getValor());
        
        return cmp == 0 && isEquals(root.getEsquerdo(), Tree.getEsquerdo()) && isEquals(root.getDireito(), Tree.getDireito());
    }
    
    public T nextValNode(T value){
        return nextValNode(root, value);
    }
    
    private T nextValNode(No<T> n, T value){
        if(n == nullnode){
            return null;
        }
        
        int cmp = value.compareTo(n.getValor());
        
        if(cmp < 0){
            T sucessorMenor = (T) nextValNode(n.getEsquerdo(), value);
            if(sucessorMenor == nullnode){
                return n.getValor();
            }
            else{
                return sucessorMenor;
            }
        }
        
        return (T) nextValNode(n.getDireito(), value);
    }
    
    public void removeNodeOneChild(){
        root = removeNodeOneChild(root);
    }
    
    private No<T> removeNodeOneChild(No<T> root){
        if(root == nullnode){
            return nullnode;
        }
        
        if(root.getEsquerdo() == nullnode && root.getDireito() == nullnode){
            return root;
        }
        
        if(root.getEsquerdo() != nullnode && root.getDireito() != nullnode){
            root.setEsquerdo(removeNodeOneChild(root.getEsquerdo()));
            root.setDireito(removeNodeOneChild(root.getDireito()));
            return root;
        }
        
        if(root.getEsquerdo() == nullnode){
            removeNodeOneChild(root.getDireito());
        }
        
        return removeNodeOneChild(root.getEsquerdo());
    }
    
    public void removeNodeLeafs(){
        root = removeNodeLeafs(root);
    }
    
    private No<T> removeNodeLeafs(No<T> root){
        if(root == nullnode){
            return nullnode;
        }
        
        if(root.getEsquerdo() == nullnode && root.getDireito() == nullnode){
            return nullnode;
        }
        
        root.setEsquerdo(removeNodeLeafs(root.getEsquerdo()));
        root.setDireito(removeNodeLeafs(root.getDireito()));
        
        return root;
    }
    
    public void remove(T value){
        root = remove(root, value);
    }
    
    private No<T> remove(No<T> root, T value){
        if(root == nullnode)
            return nullnode;
        
        int cmp = comp.compare(value, root.getValor());
        
        if(cmp < 0){
            root.setEsquerdo(remove(root.getEsquerdo(), value));
            return root;
        }
        
        if(cmp > 0){
            root.setDireito(remove(root.getDireito(), value));
            return root;
        }
        
        // Sem filhos
        if(root.getEsquerdo() == nullnode && root.getDireito() == nullnode)
            return nullnode;
        
        // SÃ³ tem filho direito
        if(root.getEsquerdo() == nullnode)
            return root.getDireito();
        
        // SÃ³ tem filho esquerdo
        if(root.getDireito() == nullnode)
            return root.getEsquerdo();
        
        System.out.println("Tem 2 filhos, o " + root.getValor()); // Se chegarmos aqui tem 2 filhos
        
        No<T> min = minimumElement(root.getDireito());
        root.setValor(min.getValor());
        
        root.setDireito(remove(root.getDireito(), min.getValor()));
        
        return root;
    }
    
    public No<T> minimumElement(No<T> root){
        if(root.getEsquerdo() == nullnode)
            return root;
        
        return minimumElement(root.getEsquerdo());
    }
    
    public void imprimeNivel(No<T> t, List<T> lst, int i){
        T item;
        
        System.out.println("----- NÃ­vel " + i + " -----");
        ListIterator li = lst.listIterator();
        while(li.hasNext()){
            item = (T)li.next();
            if(profundidadeDe(root.getValor()) == i)
                System.out.println("[" + i + "]" + item);
        }   
    }
    
    public void imprimePorNiveis(){
        int j, l = profundidade(root);
        List<T> lst = new ArrayList<>();
        
        ordem(root, lst);
        System.out.println("=====================ConteÃºdo da Ã�rvore=====================");

        for(j = 1; j >= l; j++){
            imprimeNivel(root, lst, j);
        }
        System.out.println("============================================================");
    }

    @Override
    public Iterator<T> iterator() {
        return new ArvoreIterator(this);
    }
    
    //@Override
    public Iterator<T> iteratorProf() {
        return new ArvoreIteratorProf(this.getRoot());
    }
    
    
    
}
