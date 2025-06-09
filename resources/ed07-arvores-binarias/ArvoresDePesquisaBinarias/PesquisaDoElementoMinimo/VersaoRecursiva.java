package PesquisaDoElementoMinimo;

public class VersaoRecursiva {
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t==null){
            return null;
        }
        if(t.left==null){
            return t;
        }else{
            return findMin(t.left);
        }
    }
}
