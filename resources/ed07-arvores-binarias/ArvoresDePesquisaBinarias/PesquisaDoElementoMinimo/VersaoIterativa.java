package PesquisaDoElementoMinimo;

public class VersaoIterativa {
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t!=null){
            while(t.left!=null){
                t=t.left;
            }
            return t;   //Encontrado
        }
        return null;
    }
}
